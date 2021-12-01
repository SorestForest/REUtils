package ru.REStudios.utils.oop;

import org.jetbrains.annotations.Nullable;
import ru.REStudios.utils.Time;


/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 *
 * Simple object utils, or utils that can't be classified
 */
@SuppressWarnings("unused")
public class REUtils {

    private REUtils(){}

    /**
     * Casts an object to class, if it can. otherwise, returns null
     * @param clazz is the class to cast
     * @param object is the object to cast to clazz
     * @param <T> parameter for you're everything
     * @return cast object or null
     */
    @Nullable
    public static <T> T castOrNull(Class<T> clazz,Object object){
        if (clazz.isAssignableFrom(object.getClass())){
            return clazz.cast(object);
        }
        return null;
    }

    /**
     * Returns method's caller stacktrace to get class or everything else
     * @param depth to go into system
     * @return stack trace to this
     */
    public static StackTraceElement getCaller(int depth){
        Throwable t = new Throwable();
        int actualDepth = Math.min(depth+1,t.getStackTrace().length);
        return t.getStackTrace()[actualDepth];
    }

    /**
     * Performs safe null/non-null equals check
     * @param a to be checked
     * @param b to be checked
     * @return equality
     */
    public static boolean safeEquals(Object a,Object b){
        if (a == null && b == null){ return true;}
        if (a == null){ return false; }
        else { return a.equals(b); }
    }

    /**
     * Does simple API setup for next usage
     */
    public static void simpleStart(){
        REPrintStream.setupPrints();
        Time.getTime();
    }
}
