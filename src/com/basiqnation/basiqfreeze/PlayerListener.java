package com.basiqnation.basiqfreeze;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;





public class PlayerListener implements Listener {
	public static BasiqFreeze plugin;
	
	public PlayerListener (BasiqFreeze instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(final PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
	}
}
