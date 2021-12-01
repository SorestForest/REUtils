package ru.REStudios.utils.options.custom;

import ru.REStudios.utils.options.Option;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class StringOption extends Option<String> {
    public StringOption(String inFileName, String defaultValue) {
        super(inFileName, defaultValue);
    }

    public StringOption(String inFileName){
        super(inFileName,"not loaded");
    }

    @Override
    public void setFromString(String str) {
        set(str);
    }

    @Override
    public String writeInString() {
        return get();
    }
}
