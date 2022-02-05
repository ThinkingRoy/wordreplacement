package mckitsu.net.wordreplacement;

import mckitsu.net.wordreplacement.event.EventCommand;
import mckitsu.net.wordreplacement.file.LoadFile;
import mckitsu.net.wordreplacement.file.MakeFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class WordReplacement extends JavaPlugin {

    @Override
    public void onEnable() {
        LoadFile file = new LoadFile();
        MakeFile make = new MakeFile();
        make.makeFile();
        Replacement replacement = new Replacement();
        replacement.addReplaceMap(file.loadFile());
        Objects.requireNonNull(this.getCommand("word")).setExecutor(new EventCommand());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
