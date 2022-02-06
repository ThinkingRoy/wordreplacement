package mckitsu.net.wordreplacement;

import mckitsu.net.wordreplacement.event.EventCommand;
import mckitsu.net.wordreplacement.file.FileLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;



public final class WordReplacement extends JavaPlugin {
    public static final Replacement replacement = new Replacement();



    @Override
    public void onEnable() {
        Replacement replacement = new Replacement();
        replacement.addReplaceMap(FileLoader.load());
        Objects.requireNonNull(this.getCommand("word")).setExecutor(new EventCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
