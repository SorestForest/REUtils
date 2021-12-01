package ru.REStudios.utils.functional;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 * Creates a factory instance that gets some arguments of type A and gives V
 * @param <V> value to return
 * @param <A> value to get as argument
 */
public interface Factory<V,A> {

    /**
     * Works as factory, gets arguments and returns value
     * @param args to parse
     * @return factory parsed value
     */
    V create(A[] args);
}
