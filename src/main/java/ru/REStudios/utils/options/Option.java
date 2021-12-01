package ru.REStudios.utils.options;

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

}
