package ru.REStudios.utils.options;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public abstract class Option<T> {

    private T value;
    String inFile;

    public Option(String inFileName,T defaultValue){
        this.value = defaultValue;
        inFile = inFileName;
        Options.register(this);
    }

    public T get() {
        return value;
    }

    @SuppressWarnings("all")
    public T set(T value){
        T temp = this.value;
        this.value = value;
        return temp;
    }

    public abstract void setFromString(String str);

    public abstract String writeInString();

    @Contract(value = "!null->!null;null->null")
    public T getOrDefault(T v){
        if (get() == null){
            return v;
        }
        return get();
    }

    @NotNull
    public T getOrDefaultNonNull(T v){
        return Objects.requireNonNullElse(get(),v);
    }

}
