package com.basiqnation.basiqfreeze;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import com.basiqnation.basiqfreeze.PlayerListener;

public class BasiqFreezeManager {
	
	public static Boolean FreezePlayer(Player freezee, String position){
		String pName = freezee.getName();
		if (!pName.isEmpty()){
			
			return true;
		}
		return false;
	}
}
