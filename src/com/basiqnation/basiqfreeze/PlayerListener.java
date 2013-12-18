package com.basiqnation.basiqfreeze;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;

public class PlayerListener implements Listener {
	public static BasiqFreeze plugin;

	public PlayerListener(BasiqFreeze instance) {
		plugin = instance;
	}

	

	// Listens for player movement
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(final PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Location current = event.getFrom();
		Location move = event.getTo();
		BasiqFreezeManager.Freeze(player, current, move);

	}

	// Cancel all damage dealt to frozen players
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDamaged(final EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if ((entity instanceof Player)) {
			Player damagee = ((Player) entity).getPlayer();
			if (BasiqFreezeManager.isFrozen(damagee)) {
				event.setCancelled(true);
			}

		}
		return;
	}

	// stops players from breaking the environment whilst frozen
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (BasiqFreezeManager.isFrozen(player)) {
			event.setCancelled(true);

		}
		return;

	}
}
