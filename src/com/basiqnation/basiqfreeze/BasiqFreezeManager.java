package com.basiqnation.basiqfreeze;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.Location;
import com.basiqnation.basiqfreeze.PlayerListener;
import com.basiqnation.basiqfreeze.freeze.Freeze;
import org.bukkit.event.player.PlayerMoveEvent;

public class BasiqFreezeManager {

	public static Boolean FreezePlayer(Player freezee) throws SQLException {
		String pName = freezee.getName();

		if (!(pName.isEmpty())) {
			if (!(Freeze.isFrozen(freezee))) {
				try {
					BasiqFreeze.sql.query("INSERT INTO frozen (name) VALUES ('"
							+ pName + "')");
					freezee.sendMessage("Freezing " + pName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			} else {
				BasiqFreeze.sql.query("DELETE FROM frozen WHERE name='" + pName
						+ "'");
				freezee.sendMessage("UnFreezing " + pName);
				return true;
			}

		}
		return false;
	}

	public static void Freeze(Player player, Location current, Location move)
			throws SQLException {
		if (Freeze.isFrozen(player)) {
			if (move != current) {
				player.teleport(current);
			}
		}

	}
}
