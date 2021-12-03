package ru.REStudios.utils.oop;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("unused")
public class RECollections {

    private RECollections(){}


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
}
