package com.basiqnation.basiqfreeze.commands;


import java.io.IOException;

import com.basiqnation.basiqfreeze.BasiqFreeze;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class BasiqFreezeCommands implements CommandExecutor {
	public static BasiqFreeze plugin;
	public static String cmdName = null;
	public static String cmdDesc = null;
	public static String cmdUsage = null;
	public static String pluginName;
	public static String pluginVersion;
	
	public BasiqFreezeCommands(BasiqFreeze instance){
		plugin = instance;
		PluginDescriptionFile pdf = plugin.getDescription();
		pluginName = pdf.getName();
		pluginVersion = pdf.getVersion();
	}
	
	private boolean checkPerm(Player player, String perm) {
		if (player.isOp()
				|| player.hasPermission(pluginName.toLowerCase() + "."
						+ perm.toLowerCase()))
			return true;
		else {
			player.sendMessage("You do not have permission.");
			return false;
		}
	}
	
	private void displayCmdHelp(Player player) {
		player.sendMessage("�5[�6 " + pluginName
				+ " Help �5]�f--------------------------");
		player.sendMessage("�f| �bCommand: �3" + cmdName);
		player.sendMessage("�f| �bDescription: �3" + cmdDesc);
		player.sendMessage("�f| �bUsage: �3" + cmdUsage);
		player.sendMessage("�5[�6 " + pluginName
				+ " Help �5]�f--------------------------");
	}
	
	private void displayHelp(Player player) {
		player.sendMessage("�5[�6 " + pluginName
				+ " Help �5]�f--------------------------");
		player.sendMessage("�f �b/freeze �3[user]");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("Sorry, you can not run these commands from the console!");
			return true;
		}

		if (args.length == 0 || args[0].equals("?")) {
			displayHelp((Player) sender);
			return true;
		}
	
		
		if (freezeCommand("freeze", args, sender, "freeze")) {
			cmdName = "Freeze";
			cmdDesc = "Freezes or unfreezes a player";
			cmdUsage = "/freeze <user>";
			if (args[1].equalsIgnoreCase("?")) {
				displayCmdHelp((Player) sender);
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[1]);
			if (target == null) {
				sender.sendMessage("That player does not exist or is offline!");
				return true;
			}
			sender.sendMessage("Success!");
			
		}
		return true;
	}
	
		private boolean freezeCommand(String label, String[] args,
				CommandSender sender, String perm) {
			if (args[0].equalsIgnoreCase(label) || checkPerm((Player) sender, perm))
				return true;
			else
				sender.sendMessage("Not enough perms");
				return false;
		}
	}