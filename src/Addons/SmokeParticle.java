package me.nosaj9.CSaddons;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.shampaggon.crackshot.events.WeaponShootEvent;

public class SmokeParticle implements Listener {

	public SmokeParticle(Main plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onShoot(WeaponShootEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation().toVector().add(p.getLocation().getDirection().multiply(1.2)).toLocation(p.getWorld());
		p.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc.getX(), loc.getY()+1.45, loc.getZ(), 0);
																								//g, r,	b
	}
}
