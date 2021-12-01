package ru.REStudios.utils.timers;

import ru.REStudios.utils.Time;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class MillisTimer extends Timer{

    private float timeStarted;
    private float timeElapsed;

    @Override
    public void end() {
        timeElapsed = (float) (Time.getTime() - timeStarted);
    }

    @Override
    public void start() {
        timeStarted = (float) Time.getTime();
    }

    @Override
    public float timeStarted() {
        return timeStarted;
    }

    @Override
    public float elapsedTime() {
        return timeElapsed;
    }
}

