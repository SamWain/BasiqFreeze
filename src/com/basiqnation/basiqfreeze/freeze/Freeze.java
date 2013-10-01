package com.basiqnation.basiqfreeze.freeze;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

import com.basiqnation.basiqfreeze.BasiqFreeze;

public class Freeze {
	public Player player;
	public String iPos;
	public String fPos;
	
	public boolean isFrozen() throws SQLException{
		ResultSet frozen = BasiqFreeze.sql.query("SELECT count(name) AS counted FROM frozen WHERE name='" + player.getName());
		return true;
		
	}
}
