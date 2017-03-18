package com.slabbababba.pluginTest;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Klanc on 17/03/2017.
 */
public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        this.getCommand("steal").setExecutor(new CommandStealChunks());
    }
    @Override
    public void onDisable(){
        //Fired when the server enables the plugin
    }
}

