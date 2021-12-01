package ru.REStudios.utils.options.custom;

import ru.REStudios.utils.oop.RENumbers;
import ru.REStudios.utils.options.Option;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class DoubleOption extends Option<Double> {
    public DoubleOption(String inFileName, Double defaultValue) {
        super(inFileName, defaultValue);
    }

    @Override
    public void setFromString(String str) {
        set(RENumbers.parseDouble(str));
    }

    @Override
    public String writeInString() {
        return String.valueOf(get());
    }
}
