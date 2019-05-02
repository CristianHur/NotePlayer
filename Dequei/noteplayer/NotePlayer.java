/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dequei.noteplayer;

import Dequei.noteplayer.Comandos.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Dequei
 */
public class NotePlayer extends JavaPlugin
{ 
    @Override
    public void onEnable()
    {
        //getLogger().info("onEnable se ejecuto correctamente!");
        this.getCommand("np").setExecutor(new ComandoNP(this));
        this.getCommand("npreload").setExecutor(new Reload(this));
        this.saveDefaultConfig();
    }
    
    @Override
    public void onDisable()
    {
        //getLogger().info("onDisable se ejecuto correctamente!");        
    }
}
