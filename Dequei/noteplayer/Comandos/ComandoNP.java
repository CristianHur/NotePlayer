package Dequei.noteplayer.Comandos;

import Dequei.noteplayer.NotePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoNP implements CommandExecutor
{
    private final NotePlayer Main;
    
    public ComandoNP(NotePlayer Main)
    {
        this.Main = Main;
    }
    
    @Override
    public boolean onCommand(CommandSender enviador, Command comando, String label, String[] argumentos) 
    {
        Player Jugador = (Player) enviador;
        
        if( (comando.getName().equalsIgnoreCase("np") || label.equalsIgnoreCase("noteplayer")))
        {
            if ( (argumentos.length == 0) && (Jugador.hasPermission("np.help") || Jugador.hasPermission("np.*")))
            {
                Jugador.performCommand("help noteplayer");
                
                return true;
            }
            else
            {
                if( argumentos[0].equalsIgnoreCase("addnote") && (Jugador.hasPermission("np.addnote") || Jugador.hasPermission("np.*")) )
                {
                    Jugador.sendMessage("ADDNOTE");
                
                    return true;
                }
                else
                {
                    Jugador.sendMessage(Main.getConfig().getString("NoPermission").replace("&", "§"));
                }
            }
        }
        
        return false;
    }    
}
