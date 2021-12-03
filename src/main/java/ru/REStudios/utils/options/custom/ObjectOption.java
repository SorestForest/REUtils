package ru.REStudios.utils.options.custom;

import org.jetbrains.annotations.NotNull;
import ru.REStudios.utils.functional.Factory;
import ru.REStudios.utils.options.Option;

import java.util.function.BiConsumer;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("ALL")
public class ObjectOption<T> extends Option<T> {

    private final Factory<T,String> factory;
    private final @NotNull BiConsumer<T, StringBuffer> writer;

    public ObjectOption(String inFileName, T defaultValue, @NotNull Factory<T,String> factory, @NotNull BiConsumer<T,StringBuffer> writer) {
        super(inFileName, defaultValue);
        this.factory = factory;
        this.writer = writer;
    }

    @Override
    public void setFromString(String str) {
        set(factory.create(str));
    }

    @Override
    public String writeInString() {
        StringBuffer s = new StringBuffer();
        writer.accept(get(),s);
        return s.toString();
    }
}
