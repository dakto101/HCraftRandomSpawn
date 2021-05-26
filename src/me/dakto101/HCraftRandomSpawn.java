package me.dakto101;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class HCraftRandomSpawn extends JavaPlugin {
    
	public static HCraftRandomSpawn plugin;
	
    public void onEnable() {
    	plugin = this;
    	registerEvent(new HCraftRandomSpawnListener());
    }
    
    public void onDisable() {
    	
    }
    
	public static void registerEvent(Listener... listener) {
		for (Listener l : listener) {
			plugin.getServer().getPluginManager().registerEvents(l, plugin);
		}
	}
    
}
