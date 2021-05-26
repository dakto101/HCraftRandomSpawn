package me.dakto101;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import io.netty.util.internal.ThreadLocalRandom;

public class HCraftRandomSpawnListener implements Listener {

    /**
     * When players first join...
     * 
     * @param event
     */
	@EventHandler
	public static void onFirstJoin(final PlayerLoginEvent e) {
        if (!Bukkit.getOfflinePlayer(e.getPlayer().getUniqueId()).hasPlayedBefore()) {
        	setNewSpawnLocation(e.getPlayer().getWorld());
        }
	}
	
    /**
     * When players die...
     * 
     * @param event
     */
	@EventHandler
	public static void onDeath(final PlayerDeathEvent e) {
		setNewSpawnLocation(e.getEntity().getWorld());
	}
	
	private static void setNewSpawnLocation(final World world) {
    	int centerX = 0;
    	int centerZ = 0;
    	int variance = 5000;
    	
    	int x = ThreadLocalRandom.current().nextInt(centerX - variance / 2, centerX + variance / 2);
    	int y = 100;
    	int z = ThreadLocalRandom.current().nextInt(centerZ - variance / 2, centerZ + variance / 2);
        world.setSpawnLocation(x, y, z);
	}
	
}
