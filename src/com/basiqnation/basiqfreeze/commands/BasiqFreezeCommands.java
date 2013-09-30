package com.basiqnation.basiqfreeze.commands;


import java.io.IOException;
import java.util.List;
import com.basiqnation.basiqfreeze.BasiqFreeze;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class BasiqFreezeCommands implements CommandExecutor {
	 
	private BasiqFreeze plugin;
	
	public BasiqFreezeCommands(BasiqFreeze instance){
		plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}