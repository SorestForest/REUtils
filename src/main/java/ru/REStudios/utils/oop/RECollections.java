package ru.REStudios.utils.oop;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("unused")
public class RECollections {

    private RECollections(){}


    /**
     * Removes T objects from collection
     * @param collection which is going to be clear
     * @param toRemove objects to remove
     * @param <T> parameter for you're everything
     * @return cleaned collection
     */
    @SafeVarargs
    public static <T> Collection<T> removeAll(Collection<T> collection, T... toRemove){
        ArrayList<T> out = new ArrayList<>();
        ArrayList<T> remove = new ArrayList<>(Arrays.asList(toRemove));
        for (T string : collection) {
            if(!remove.contains(string)){
                out.add(string);
            }
        }
        return out;
    }

    /**
     * Reverses given array
     * @param arr to be reverser
     * @param <T> parameter for you're everything
     */
    public static <T> void reverse(T[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // swap arr[start] and arr[end]
            T temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start = start + 1;
            end = end - 1;
        }
    }

    /**
     * Collapses two arrays into one
     * @param a first to be in
     * @param b second to be in
     * @param <T> parameter for you're everything
     * @return collapsed array
     */
    public static <T> T[] collapse(T[] a, T[] b){
        ArrayList<T> output = new ArrayList<>();
        output.addAll(Lists.asList(null,a));
        output.addAll(Lists.asList(null,b));
        output.remove(0);
        output.remove(a.length);
        return output.toArray(a);
    }


    @SafeVarargs
    public static <T> T[] asArray(T... values){
        return values;
    }
}
