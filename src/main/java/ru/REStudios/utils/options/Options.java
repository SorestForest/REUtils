package ru.REStudios.utils.options;

import ru.REStudios.utils.files.FileHandle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    public static void loadFromLines(String... s) {
        try {
        for (String line : s) {
            line = line.trim();
            String[] sp = line.split("=");
            String name = sp[0];
            String value = String.join("=", Arrays.copyOfRange(sp, 1, sp.length));
            for (Map.Entry<String, Option<?>> entry : OPTIONS.entrySet()) {
                if (name.equals(entry.getKey())) {
                    entry.getValue().setFromString(value);
                    break;
                }
            }
        }
        } catch (ArrayIndexOutOfBoundsException ignored){
            throw new OptionsLoadException("Options can't be load because wrong line parsed.");
        }
    }

    public static void loadFromFile(String file) throws IOException {
        loadFromLines(new FileHandle(file).readAllLinesUTF8());
    }

    public static String saveToString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String,Option<?>>> it = OPTIONS.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Option<?>> entry = it.next();
            String ser = entry.getValue().writeInString();
            sb.append(entry.getKey()).append("<=>").append(ser);
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

    public static String saveByGroup(OptionGroup group){
        Iterator<Map.Entry<String,Option<?>>> it = OPTIONS.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()){
            Map.Entry<String,Option<?>> entry = it.next();
            if (entry.getValue().isBelongs(group)){
                sb.append(entry.getKey()).append("=").append(entry.getValue().writeInString());
                if (it.hasNext()){
                    sb.append("\n");
                }
            }
            if (!it.hasNext()){
                return sb.toString();
            }
        }
        return "";
    }

    public static void saveToFile(OptionGroup group) throws IOException {
        FileHandle handle = new FileHandle(group.file());
        handle.writeString(saveByGroup(group));
    }


}
