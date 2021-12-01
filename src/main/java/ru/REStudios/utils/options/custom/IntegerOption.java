package ru.REStudios.utils.options.custom;

import ru.REStudios.utils.oop.RENumbers;
import ru.REStudios.utils.options.Option;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class IntegerOption extends Option<Integer> {
    public IntegerOption(String inFileName, Integer defaultValue) {
        super(inFileName, defaultValue);
    }

    @Override
    public void setFromString(String str) {
        set(RENumbers.parseInteger(str));
    }

    @Override
    public String writeInString() {
        return String.valueOf(get());
    }
}
