package com.basiqnation.basiqfreeze;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
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
	
	private void addCommands() {
		getCommand("freeze").setExecutor(new BasiqFreezeCommands(this));
	}
	
	
	private void createTables() {
		// Create Titles Table
		sql.createTable("CREATE TABLE if not exists frozen (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL);");
	}

	private void startListeners() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this),
				this);
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdf = this.getDescription();
		
		sql = new SQLite(logger, "[ " + pdf.getName() + "]", getDataFolder().getPath() ,"frozen");
		
		sql.open();
		
		createTables();
		addCommands();
		startListeners();
		setupPermissions();
		logger.info("[" + pdf.getName() + "] v" + pdf.getVersion() + " is now enabled!");
	}
	
	private Boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

}
