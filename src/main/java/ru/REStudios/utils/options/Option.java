package ru.REStudios.utils.options;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public abstract class Option<T> {

    private T value;
    String inFile;

    ArrayList<OptionGroup> myGroups = new ArrayList<>();

    public Option(String inFileName,T defaultValue){
        this.value = defaultValue;
        inFile = inFileName;
        Options.register(this);
    }

    public T get() {
        return value;
    }

    public Option<T> addGroup(OptionGroup group){
        myGroups.add(group);
        return this;
    }

    public boolean isBelongs(OptionGroup group){
        return group.isBelongs(this);
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

    @Override
    public String toString() {
        return get().toString();
    }
}
