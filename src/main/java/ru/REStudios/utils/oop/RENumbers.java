package ru.REStudios.utils.oop;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("unused")
public class RENumbers {

    /**
     * Safe-parsing to int
     * @param s to be parsed
     * @return parse result or 0 if error happens
     */
    public static int parseInteger(String s){
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    /**
     * Safe-parsing to double
     * @param s to be parsed
     * @return parse result or 0 if error happens
     */
    public static double parseDouble(String s){
        try{
            return Double.parseDouble(s);
        } catch (NumberFormatException ignored){
            return 0d;
        }
    }

    public static float parseFloat(String s){
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException ignored){
            return 0f;
        }
    }

    /**
     * Returns all numbers from [x;y)
     * @param from start value
     * @param to end value
     * @return array with numbers
     */
    public static Integer[] getFrom(int from,int to){
        if (from > to) { throw new IllegalArgumentException("From is bigger than to. From: "+from+", To: "+to); }
        Integer[] array = new Integer[to - from];
        for (int i = 1; i < array.length+1; i++) {
            array[i-1] = to-i;
        }
        RECollections.reverse(array);
        return array;
    }

    /**
     * Simple clamp functions. Keeps value in range [min;max]
     * @param value to keep in
     * @param minimal max value to be
     * @param maximal min value to be
     * @return clamped value
     */
    public static int keepInRange(int value,int minimal,int maximal){
        if (value >= maximal){ return maximal; }
        return Math.max(value, minimal);
    }

    /**
     * Simple clamp functions. Keeps value in range [min;max]
     * @param value to keep in
     * @param minimal max value to be
     * @param maximal min value to be
     * @return clamped value
     */
    public static float keepInRange(float value,float minimal,float maximal){
        if (value >= maximal){ return maximal; }
        return Math.max(value, minimal);
    }

    /**
     * Simple clamp functions. Keeps value in range [min;max]
     * @param value to keep in
     * @param minimal max value to be
     * @param maximal min value to be
     * @return clamped value
     */
    public static double keepInRange(double value,double minimal,double maximal){
        if (value >= maximal){ return maximal; }
        return Math.max(value, minimal);
    }

    /**
     * Simple clamp functions. Keeps value in range [min;max]
     * @param value to keep in
     * @param minimal max value to be
     * @param maximal min value to be
     * @return clamped value
     */
    public static long keepInRange(long value,long minimal,long maximal){
        if (value >= maximal){ return maximal; }
        return Math.max(value, minimal);
    }

    /**
     * Checks for float dot. Like: 5.9 -> true ; 5.0 -> false
     * @param value to look
     * @return result
     */
    public static boolean containsFloatDot(float value){
        if (numbersFromDot(value) > 1){ return true;}
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        int afterDot = parseInteger(num.substring(dot+1));
        return afterDot > 0;
    }

    /**
     * Checks for float dot. Like: 5.9 -> true ; 5.0 -> false
     * @param value to look
     * @return result
     */
    public static boolean containsFloatDot(double value){
        if (numbersFromDot(value) > 1){ return true;}
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        int afterDot = parseInteger(num.substring(dot+1));
        return afterDot > 0;
    }

    /**
     * Counts how many numbers in float zone is
     * @param value to be in
     * @return how many numbers (always >= 1)
     */
    public static int numbersFromDot(float value){
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        String sequenceAfter = num.substring(dot+1);
        return sequenceAfter.length();
    }

    /**
     * Counts how many numbers in float zone is
     * @param value to be in
     * @return how many numbers (always >= 1)
     */
    public static int numbersFromDot(double value){
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        String sequenceAfter = num.substring(dot+1);
        return sequenceAfter.length();
    }

    /**
     * Rounds number's float zone to a X. like 5.9 -> 6.0 ; 6.54 -> 6.5
     * @param value to be rounded
     * @param to round
     * @return rounded value
     */
    public static float roundTo(float value,int to){
        if (!containsFloatDot(value)){ return value; }
        if (to < 0){ throw new IllegalArgumentException("to < 0");}
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        String afterDot = num.substring(dot+1);
        String beforeDot = num.substring(0,dot);
        if (to == 0){
            int after = parseInteger(afterDot);
            int before = parseInteger(beforeDot);
            if (after >= 5){
                before += 1;
            }
            return before;
        }
        to -= 1;
        int validatingNumber = parseInteger(String.valueOf(afterDot.charAt(to)));
        int nextNumber = 0;
        try {
            nextNumber = parseInteger(String.valueOf(afterDot.charAt(to+1)));
        } catch (StringIndexOutOfBoundsException ignored) {}
        if (nextNumber >= 5){ validatingNumber += 1;}
        String newAfterDot = afterDot.substring(0,to);
        newAfterDot = newAfterDot + validatingNumber;
        return parseFloat(beforeDot+"."+newAfterDot);
    }

    /**
     * Rounds number's float zone to a X. like 5.9 -> 6.0 ; 6.54 -> 6.5
     * @param value to be rounded
     * @param to round
     * @return rounded value
     */
    public static double roundTo(double value,int to){
        if (!containsFloatDot(value)){ return value; }
        if (to < 0){ throw new IllegalArgumentException("to < 0");}
        String num = String.valueOf(value);
        int dot = num.indexOf(".");
        String afterDot = num.substring(dot+1);
        String beforeDot = num.substring(0,dot);
        if (to == 0){
            int after = parseInteger(afterDot);
            int before = parseInteger(beforeDot);
            if (after >= 5){
                before += 1;
            }
            return before;
        }
        to -= 1;
        int validatingNumber = parseInteger(String.valueOf(afterDot.charAt(to)));
        int nextNumber = 0;
        try {
            nextNumber = parseInteger(String.valueOf(afterDot.charAt(to+1)));
        } catch (StringIndexOutOfBoundsException ignored) {}
        if (nextNumber >= 5){ validatingNumber += 1;}
        String newAfterDot = afterDot.substring(0,to);
        newAfterDot = newAfterDot + validatingNumber;
        return parseDouble(beforeDot+"."+newAfterDot);
    }

}
