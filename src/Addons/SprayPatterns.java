package me.nosaj9.CSaddons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.shampaggon.crackshot.events.WeaponShootEvent;

import net.minecraft.server.v1_12_R1.PacketPlayOutPosition;
import net.minecraft.server.v1_12_R1.PacketPlayOutPosition.EnumPlayerTeleportFlags;

public class SprayPatterns implements Listener {

	private Set<EnumPlayerTeleportFlags> teleportFlags;
	private HashMap<String, RecoilModule> recoilList;

	public SprayPatterns(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);

		teleportFlags = new HashSet<>(Arrays.asList(EnumPlayerTeleportFlags.X, EnumPlayerTeleportFlags.Y, EnumPlayerTeleportFlags.Z, EnumPlayerTeleportFlags.Y_ROT, EnumPlayerTeleportFlags.X_ROT));
		recoilList = new HashMap<String, RecoilModule>();

		recoilList.put("M1", new RecoilModule(0.0f, -0.55f));
		recoilList.put("Carbine", new RecoilModule(0.05f, -0.55f));
		recoilList.put("Thompson", new RecoilModule(-0.045f, -0.4f));
		recoilList.put("Browning Automatic Rifle", new RecoilModule(0.2f, -0.5f));

		recoilList.put("MP40", new RecoilModule(-0.045f, -0.4f));
		recoilList.put("STG44", new RecoilModule(-0.2f, -0.6f));
		recoilList.put("MG 42", new RecoilModule(0.3f, -0.5f));

		recoilList.put("PPSh", new RecoilModule(0.1f, -0.5f));

		System.out.println("CS Addons >> Loaded 8 spray patterns");
	}

	@EventHandler
	public void onShoot(WeaponShootEvent e) {

		String weapon = e.getWeaponTitle();

		if(weapon == null || !recoilList.containsKey(weapon))
			return;

		RecoilModule recoil = recoilList.get(weapon);
		Player p = e.getPlayer();

		PacketPlayOutPosition packet = new PacketPlayOutPosition(0, 0, 0, recoil.getYaw(), recoil.getPitch(), teleportFlags, 0);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}	
}
