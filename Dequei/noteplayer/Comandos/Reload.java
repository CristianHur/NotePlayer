package Dequei.noteplayer.Comandos;

import Dequei.noteplayer.NotePlayer;
import static org.bukkit.Bukkit.getLogger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Reload implements CommandExecutor
{
    private final NotePlayer Main;
    
    public Reload(NotePlayer Main)
    {
        this.Main = Main;
    }
            
    @Override
    public boolean onCommand(CommandSender enviador, Command comando, String label, String[] argumentos) 
    {   
        if(!(enviador instanceof Player))
        {
            Main.reloadConfig();
            getLogger().info(Main.getConfig().getString("Reloaded").replace("&", "§"));
            
            return true;
        }
        else
        {
            Player Jugador = (Player) enviador;
            if(Jugador.hasPermission("np.reload") || Jugador.hasPermission("np.*"))
            {
                Main.reloadConfig();
                Jugador.sendMessage(Main.getConfig().getString("Reloaded").replace("&", "§"));
                        
                return true;
            }
            else
            {
                Jugador.sendMessage(Main.getConfig().getString("NoPermission").replace("&", "§"));
                
                return true;
            }
        }
    }
    
}
