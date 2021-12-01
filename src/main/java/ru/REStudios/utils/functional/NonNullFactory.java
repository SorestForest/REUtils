package ru.REStudios.utils.functional;

import org.jetbrains.annotations.NotNull;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 * Non-null factory instance. Will produce NullPointerException if returns null
 * @param <V> value to return
 * @param <A> value to get as argument
 */
@SuppressWarnings("unused")
public interface NonNullFactory<V,A> extends Factory<V,A> {

    /**
     * New factory function, use this not to get NullPointerException
     * @param args to get
     * @return value
     */
    @NotNull
    default V get(A[] args){
        V value = create(args);
        if (value == null){
            throw new NullPointerException("Non-null factory can't return null");
        }
        return value;
    }
}
