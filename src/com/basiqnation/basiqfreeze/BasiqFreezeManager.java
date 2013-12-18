package com.basiqnation.basiqfreeze;

import java.util.ArrayList;

import org.bukkit.entity.*;

import org.bukkit.Location;

public class BasiqFreezeManager{

	private static ArrayList<String> pList = new ArrayList<String>();

	public static void loadNames(ArrayList<String> Names){
		pList = Names;
	}
	
	public static ArrayList<String> getNames(){
		return pList;
	}
	
	
	
	public static Boolean FreezePlayer(Player freezee) {
		String pName = freezee.getName();
		if (pList.contains(pName)) {
			pList.remove(pName);
		} else {
			pList.add(pName);
		}
		return true;
	}

	public static Boolean isFrozen(Player freezee) {
		String pName = freezee.getName();
		if (pList.contains(pName)) {
			return true;
		}
		return false;
	}

	// Stops frozen players from moving
	public static void Freeze(Player player, Location current, Location move) {
		if (isFrozen(player)) {
			if (move != current) {
				player.teleport(current);
			}
		}

	}
}
