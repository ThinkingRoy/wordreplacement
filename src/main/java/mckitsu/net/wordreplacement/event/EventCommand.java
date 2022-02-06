package mckitsu.net.wordreplacement.event;

import mckitsu.net.wordreplacement.command.CommandAdd;
import mckitsu.net.wordreplacement.command.CommandInfo;
import mckitsu.net.wordreplacement.command.CommandReload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class EventCommand implements CommandExecutor {
    private final HashMap<String, CommandExecutor> commandList = new HashMap<>();


    public EventCommand() {
        this.commandList.put("add", new CommandAdd());
        this.commandList.put("reload", new CommandReload());
        this.commandList.put("info", new CommandInfo());
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0)
            return false;

        args[0] = args[0].toLowerCase();
        CommandExecutor commandExecutor = this.commandList.get(args[0]);

        if(commandExecutor == null)
            return false;

        try {
            return commandExecutor.onCommand(sender, command, label, args);

        }catch (Throwable ignore){
            return false;

        }
    }
}
