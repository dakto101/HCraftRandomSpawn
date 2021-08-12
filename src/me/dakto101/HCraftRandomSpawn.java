package me.dakto101;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import io.netty.util.internal.ThreadLocalRandom;

public class HCraftRandomSpawn extends JavaPlugin {
    
	public static HCraftRandomSpawn plugin;
	
    public void onEnable() {
    	plugin = this;
    	setNewSpawnLocationTask();
    }
    
    public void onDisable() {
    	
    }
    
	public static void registerEvent(Listener... listener) {
		for (Listener l : listener) {
			plugin.getServer().getPluginManager().registerEvents(l, plugin);
		}
	}
	
	private static void setNewSpawnLocationTask() {
		BukkitScheduler s = plugin.getServer().getScheduler();
		//Set new spawn location each 7200 seconds.
		s.scheduleSyncRepeatingTask(plugin, () -> {
			World w = Bukkit.getWorld("world");

			if (w != null) {
				for (int i = 0; i < 50; i++) {
			    	int centerX = 0;
			    	int centerZ = 0;
			    	int variance = 5000;
			    	
			    	int x = ThreadLocalRandom.current().nextInt(centerX - variance / 2, centerX + variance / 2);
			    	int y = 100;
			    	int z = ThreadLocalRandom.current().nextInt(centerZ - variance / 2, centerZ + variance / 2);
			        if (!w.getBiome(x, y, z).toString().contains("OCEAN") && w.getTemperature(x, y, z) > 0.1) {
			        	w.setSpawnLocation(x, y, z);
			        	break;
			        }
				}
			}

			
		}, 0L, 7200*20L);

	}
    
}
