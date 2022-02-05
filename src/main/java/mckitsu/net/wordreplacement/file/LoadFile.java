package mckitsu.net.wordreplacement.file;

import net.mckitsu.file.FileManager;
import net.mckitsu.file.YamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LoadFile {
    public Map<String, String> loadFile(){
        FileManager fileManager = new FileManager("", "config.yml");
        YamlManager<Map<String, String>> yamlManager = new YamlManager<>();
        Map<String, String> keyMap = null;
        try{
            keyMap = yamlManager.load(fileManager.readAsString(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyMap;
    }


}
