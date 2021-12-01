package ru.REStudios.utils;

/**
 * (C) Copyright REStudios 2021
 * Time Utils
 * @author REStudios
 */
@SuppressWarnings("unused")
public class Time {

    public static final float timeStarted = System.nanoTime();

    /**
     * Returns time from class/application starts
     * @return time in millis
     */
    @SuppressWarnings("all")
    public static float getTime() { return (float) ((System.nanoTime() - timeStarted) * 1E-9); }

    public static float getTimeNano() { return (System.nanoTime() - timeStarted); }

}
