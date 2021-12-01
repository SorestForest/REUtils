package ru.REStudios.utils.functional;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("unused")
public interface NonNullSupplier<T> extends Supplier<T> {

    /**
     * Simple supplier method
     * @return value
     */
    T a();

    @NotNull
    default T get(){
        if (a() == null){
            throw new NullPointerException("NonNullSupplier can't return null");
        }
        return a();
    }

}
