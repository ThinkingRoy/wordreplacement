package mckitsu.net.wordreplacement.file;

import mckitsu.net.wordreplacement.command.CommandAdd;
import net.mckitsu.file.FileManager;
import net.mckitsu.file.YamlManager;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MakeFile {

    public void makeFile(){
        Map<String, String> keyMap = new HashMap<>();
        FileManager fileManager = new FileManager("WordReplacement-1.0-SNAPSHOT", "config.yml");

        YamlManager<Map<String, String>> yamlManager = new YamlManager<>();

        if (!fileManager.exists()){
            fileManager.createFile();
            fileManager.write(yamlManager.dump(keyMap), StandardCharsets.UTF_8);
        }
    }
}
