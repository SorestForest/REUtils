package ru.REStudios.utils.oop;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
@SuppressWarnings("unused")
public class REStrings {

    private REStrings(){}

    public static final char[] RUSSIA_ALPHABET =
            {'А','а','Б','б','В','в','Г','г','Д','д','Е','е','Ё','ё','Ж','ж','З','з','И','и','Й','й','К','к','Л','л','М','м','Н','н','О','о',
                    'П','п','Р','р','С','с','Т','т','У','у','Ф','ф','Х','х','Ц','ц','Ч','ч','Ш','ш','Щ','щ','Ъ','ъ','Ы','ы','Ь','ь','Э','э','Ю','ю','Я','я'};
    public static final char[] ENGLISH_ALPHABET =
            {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p',
                    'Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};

    /**
     * Reverses string as it says
     * abc -> cba
     * @param s to be reversed
     * @return reversed string
     */
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Sets char X in string to upper
     * @param index to be upper
     * @param s src string
     * @return string with X upper
     */
    public static String characterUp(int index,String s){
        if (index < 0 || index >= s.length()) {
            throw new StringIndexOutOfBoundsException("index " + index +
                    ",length " + s.length()+", string:"+s);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index,Character.toUpperCase(s.charAt(index)));
        return sb.toString();
    }

    /**
     * Sets X chars in string to upper
     * @param s src
     * @param ints indexes to set
     * @return upper string
     */
    public static String charsUp(String s, int... ints){
        for (int anInt : ints) {
            s = characterUp(anInt,s);
        }
        return s;
    }

    /**
     * Sets first char to upper
     * @param s src
     * @return abc -> Abc
     */
    public static String firstCharUp(String s){
        return characterUp(0,s);
    }
}
