package me.nosaj9.CSaddons;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.shampaggon.crackshot.events.WeaponPreShootEvent;

import me.nosaj9.CSaddons.Main;

public class JumpRecoil implements Listener {
	
	public JumpRecoil(Main plugin) {	
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void on(WeaponPreShootEvent e) {
		if(!(e.getPlayer().isOnGround())) 
			e.setBulletSpread(e.getBulletSpread() + 1.2);
	}
}
