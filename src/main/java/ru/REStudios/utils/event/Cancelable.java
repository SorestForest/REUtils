package ru.REStudios.utils.event;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public interface Cancelable {

    void setCanceled(boolean v);

    boolean isCanceled();
}
