package mckitsu.net.wordreplacement.command;

import mckitsu.net.wordreplacement.Replacement;
import mckitsu.net.wordreplacement.file.MakeFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Map;

public class CommandAdd implements CommandExecutor {
    Replacement replacement = new Replacement();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;
        player.sendMessage(String.format("長度是%d", args.length));
        for(int i=0; i<args.length; i++){
            player.sendMessage(String.format("args[%d] = %s", i, args[i]));
        }

        if(args.length<2){
            return false;
        }

        if(args.length>2){

            try {
                player.sendMessage(String.format("已新增%s及%s至伺服過濾器", args[1], args[2]));
                replacement.library.put(args[1], args[2]);

            }catch (Throwable exc){
                player.sendMessage("文字檔新增失敗");
                exc.printStackTrace();
                return false;
            }

        }

        return false;
    }
}
