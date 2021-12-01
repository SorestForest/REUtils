package ru.REStudios.utils.options.custom;

import ru.REStudios.utils.oop.RENumbers;
import ru.REStudios.utils.options.Option;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class FloatOption extends Option<Float> {
    public FloatOption(String inFileName, Float defaultValue) {
        super(inFileName, defaultValue);
    }

    @Override
    public void setFromString(String str) {
        set(RENumbers.parseFloat(str));
    }

    @Override
    public String writeInString() {
        return String.valueOf(get());
    }
}
