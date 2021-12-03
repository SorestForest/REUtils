package ru.REStudios.utils.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class EventManager {

    private static final ArrayList<Method> listeners = new ArrayList<>();
    private static final HashMap<Method,Listener> instances = new HashMap<>();

    /**
     * Registers provided handler for event listening.
     * @param listener is an object to register.
     */
    public static void registerHandler(Listener listener){
        Class<? extends Listener> clazz = listener.getClass();
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            if (declaredMethod.getParameterTypes().length != 1){ continue; }
            if (declaredMethod.isAnnotationPresent(EventListener.class)){
                listeners.add(declaredMethod);
                instances.put(declaredMethod,listener);
            }
        }
    }

    /**
     * Parses event to every single listener
     * @param event to be parsed
     */
    public static void parseEvent(Event event){
        for (Method listener : listeners) {
            if (listener.getParameterTypes()[0].isInstance(event)){
                try {
                    listener.invoke(instances.get(listener),event);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
