package me.nosaj9.CSaddons;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		new SprayPatterns(this);
		new JumpRecoil(this);
		//new SmokeParticle(this);
		new DisableSwapDelay(this);
		
		System.out.println("CS Addons >> Loaded events");
	}
	
	@Override
	public void onDisable() {
		System.out.println("CS Addons >> Disabled");
	}
}
