package mckitsu.net.wordreplacement.command;

import mckitsu.net.wordreplacement.Replacement;
import mckitsu.net.wordreplacement.WordReplacement;
import mckitsu.net.wordreplacement.file.FileLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReload implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;


        if(args.length == 1){

            try {
                WordReplacement.replacement.clear();
                WordReplacement.replacement.addReplaceMap(FileLoader.load());
                player.sendMessage("成功");

            }catch (Throwable exc){
                player.sendMessage("§creload failed");
                exc.printStackTrace();
                return false;
            }

        }



        return true;
    }
}
