package mckitsu.net.wordreplacement;


import net.mckitsu.file.FileManager;

import java.util.HashMap;
import java.util.Map;

public class Replacement {



    public final Map<String, String> library = new HashMap<>();

    public String replace(String source){
        String replacement = source;



        for (Map.Entry<String, String> entry : library.entrySet()){

            if (source.contains(entry.getKey())){
                replacement = replacement.replace(entry.getKey(),entry.getValue());
            }

        }
        return replacement;
    }



    public void addReplaceMap(Map<String, String> books) {
        library.putAll(books);
    }
}