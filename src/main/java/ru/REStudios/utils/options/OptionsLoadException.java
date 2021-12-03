package ru.REStudios.utils.options;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class OptionsLoadException extends RuntimeException {
    
    private final String msg;
    
    public OptionsLoadException(String msg){
        this.msg = msg;
    }


    @Override
    public String getMessage() {
        return this.msg;
    }

    @Override
    public String getLocalizedMessage() {
        return this.msg;
    }
}
