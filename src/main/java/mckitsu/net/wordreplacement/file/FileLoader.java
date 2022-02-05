package mckitsu.net.wordreplacement.file;

import net.mckitsu.file.FileManager;
import net.mckitsu.file.YamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {
    public static final String filePath = "plugins\\WordReplacement";

    public static Map<String, String> load(){
        FileManager fileManager = new FileManager(FileLoader.filePath, "config.yml");
        if(fileManager.exists()){
            YamlManager<Map<String, String>> yamlManager = new YamlManager<>();
            try {
                Map<String, String> result = yamlManager.load(fileManager.readAsString(StandardCharsets.UTF_8));
                if(result == null)
                    return new HashMap<>();

                return  result;

            } catch (IOException e) {
                e.printStackTrace();
                return new HashMap<>();
            }

        }else{
            fileManager.createFile();
            return new HashMap<>();
        }
    }

    public static void write(Map<String, String> map){
        if(map == null)
            return;

        FileManager fileManager = new FileManager(FileLoader.filePath, "config.yml");
        YamlManager<Map<String, String>> yamlManager = new YamlManager<>();
        fileManager.deleteFile();
        fileManager.createFile();
        fileManager.write(yamlManager.dump(map), StandardCharsets.UTF_8);
    }
}
