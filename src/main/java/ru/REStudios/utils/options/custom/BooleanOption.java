package ru.REStudios.utils.options.custom;

import ru.REStudios.utils.options.Option;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class BooleanOption extends Option<Boolean> {
    public BooleanOption(String inFileName, Boolean defaultValue) {
        super(inFileName, defaultValue);
    }

    @Override
    public void setFromString(String str) {
        set(Boolean.parseBoolean(str));
    }

    @Override
    public String writeInString() {
        return String.valueOf(get());
    }
}
