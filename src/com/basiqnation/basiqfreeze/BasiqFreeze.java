package com.basiqnation.basiqfreeze;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;


import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import com.basiqnation.basiqfreeze.commands.BasiqFreezeCommands;

import net.milkbowl.vault.permission.Permission;

import lib.PatPeter.SQLibrary.*;

public final class BasiqFreeze extends JavaPlugin {
	public static BasiqFreeze plugin;
	public static SQLite sql;
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Permission permission = null;
	public File players = new File("plugins/basiqFreeze/frozenplayers.txt");

	private void addCommands() {
		getCommand("freeze").setExecutor(new BasiqFreezeCommands(this));
	}

	private void startListeners() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this),
				this);
	}
	private void Names() throws FileNotFoundException {
		Scanner s = new Scanner(players);
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		BasiqFreezeManager.loadNames(list);
	}
	private void saveNames() throws IOException{
		ArrayList<String> pNames = BasiqFreezeManager.getNames();
		FileWriter fw = new FileWriter(players.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(String names : pNames){
			bw.append(names);
			bw.close();
		}
		
	}

	@Override
	public void onEnable() {
		if (!players.exists()) {
			try {
				players.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Names();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addCommands();
		startListeners();
		setupPermissions();
		logger.info("[BasiqFreeze] is now enabled!");
	}

	@Override
	public void onDisable() {
		try {
			saveNames();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer()
				.getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			permission = permissionProvider.getProvider();
		}
		return (permission != null);
	}

}
