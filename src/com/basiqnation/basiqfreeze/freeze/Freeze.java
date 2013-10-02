package com.basiqnation.basiqfreeze.freeze;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import com.basiqnation.basiqfreeze.BasiqFreeze;

public class Freeze {

	public static boolean isFrozen(Player player) throws SQLException {
		ResultSet frozen = BasiqFreeze.sql
				.query("SELECT count(name) AS counted FROM frozen WHERE name='"
						+ player.getName() + "'");
		int counted = frozen.getInt("counted");
		frozen.close();
		if (counted > 0) {
			return true;

		}
		return false;
	}

}
