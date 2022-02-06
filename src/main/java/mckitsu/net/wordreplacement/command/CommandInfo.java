package mckitsu.net.wordreplacement.command;

import mckitsu.net.wordreplacement.WordReplacement;
import mckitsu.net.wordreplacement.file.FileLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.function.BiConsumer;

public class CommandInfo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;



        if(args.length == 1){

            try {
                player.sendMessage("test info");
                WordReplacement.replacement.library.forEach(new BiConsumer<String, String>() {
                    @Override
                    public void accept(String s, String s2) {
                        player.sendMessage(String.format("目前名單內有%s",WordReplacement.replacement.library));
                    }
                });

            }catch (Throwable exc){
                player.sendMessage("查詢失敗");
                exc.printStackTrace();
                return false;
            }

        }
        return true;
    }
}
