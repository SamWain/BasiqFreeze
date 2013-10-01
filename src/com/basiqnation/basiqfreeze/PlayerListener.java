package com.basiqnation.basiqfreeze;

import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;

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
}
