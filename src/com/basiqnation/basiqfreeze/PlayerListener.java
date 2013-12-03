package com.basiqnation.basiqfreeze;

import java.sql.SQLException;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;

import com.basiqnation.basiqfreeze.freeze.Freeze;

public class PlayerListener implements Listener {
	public static BasiqFreeze plugin;

	public PlayerListener(BasiqFreeze instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove(final PlayerMoveEvent event) throws SQLException {
		Player player = event.getPlayer();
		Location current = event.getFrom();
		Location move = event.getTo();
		BasiqFreezeManager.Freeze(player, current, move);

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDamaged(final EntityDamageEvent event)
			throws SQLException {
		Entity entity = event.getEntity();
		if ((entity instanceof Player)) {
			Player damagee = ((Player) entity).getPlayer();
			if (Freeze.isFrozen(damagee)) {
				event.setCancelled(true);
			}

		}
		return;
	}
}
