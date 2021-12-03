package ru.REStudios.utils.options;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class OptionGroup {

    private final String file;

    public OptionGroup(String file) {
        this.file = file+".options";
    }

    public boolean isBelongs(Option<?> forTest){
        return forTest.myGroups.contains(this);
    }

    public String file(){
        return this.file;
    }
}
