package com.basiqnation.basiqfreeze;

import org.bukkit.plugin.java.JavaPlugin;
import com.basiqnation.basiqfreeze.commands.BasiqFreezeCommands;

public final class BasiqFreeze extends JavaPlugin{
	
	private void startListeners() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
	
}
