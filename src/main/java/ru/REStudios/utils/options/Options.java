package ru.REStudios.utils.options;

import ru.REStudios.utils.files.FileHandle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class Options {

    private static final HashMap<String,Option<?>> OPTIONS = new HashMap<>();

    public static void register(Option<?> option){
        OPTIONS.put(option.inFile,option);
    }

    public static void loadFromString(String s){
        loadFromLines(s.split("\n"));
    }

    public static void loadFromLines(String... s){
        for (String line : s) {
            line = line.trim();
            String[] sp = line.split("<=>");
            String name = sp[0];
            String value = sp[1];
            for (Map.Entry<String, Option<?>> entry : OPTIONS.entrySet()) {
                if (name.equals(entry.getKey())){
                    entry.getValue().setFromString(value);
                }
            }
        }
    }
    public static void loadFromFile(String file) throws IOException {
        loadFromLines(new FileHandle(file).readAllLines());
    }

    public static String saveToString(){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String,Option<?>>> set = OPTIONS.entrySet();
        Iterator<Map.Entry<String,Option<?>>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Option<?>> entry = it.next();
            sb.append(entry.getKey()).append("<=>").append(entry.getValue().writeInString());
            if (it.hasNext()){
                sb.append("\n");
                continue;
            }
            return sb.toString();
        }
        return "";
    }

    public static void saveToFile(String file) throws IOException {
        FileHandle handle = new FileHandle(file);
        handle.writeString(saveToString());
    }


}
