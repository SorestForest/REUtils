package ru.REStudios.utils;

/**
 * (C) Copyright REStudios 2021
 * Simple thread builder
 */
public class ThreadBuilder {

    private final Thread thread;

    /**
     * Creates instance
     * @param task to be run on thread
     */
    public ThreadBuilder(Runnable task){
        thread = new Thread(task);

    }

    /**
     * Sets priority
     * @param priority to be set
     * @return this
     */
    public ThreadBuilder setPriority(int priority){
        this.thread.setPriority(priority);
        return this;
    }

    /**
     * Sets name
     * @param name to be set
     * @return this
     */
    public ThreadBuilder setName(String name){
        this.thread.setName(name);
        return this;
    }

    /**
     * @return ready thread
     */
    public Thread build(){
        return thread;
    }

    /**
     * Sets handler
     * @param handler to be set
     * @return this
     */
    public ThreadBuilder setHandler(Thread.UncaughtExceptionHandler handler){
        this.thread.setUncaughtExceptionHandler(handler);
        return this;
    }

}