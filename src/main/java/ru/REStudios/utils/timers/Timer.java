package ru.REStudios.utils.timers;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public abstract class Timer {

    public abstract void end();

    public abstract void start();

    public abstract float timeStarted();

    public abstract float elapsedTime();

}
