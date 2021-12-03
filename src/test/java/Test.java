import ru.REStudios.utils.oop.REUtils;
import ru.REStudios.utils.options.OptionGroup;
import ru.REStudios.utils.options.Options;
import ru.REStudios.utils.options.custom.IntegerOption;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class Test {

    public static final String path = "src/test/resources/";

    public static final OptionGroup ints = new OptionGroup(path+"integers");
    public static final OptionGroup other = new OptionGroup(path+"another");
    public static final IntegerOption first = (IntegerOption) new IntegerOption("first",5).addGroup(ints);
    public static final IntegerOption third = (IntegerOption) new IntegerOption("third",25).addGroup(ints);
    public static final IntegerOption second = (IntegerOption) new IntegerOption("second",7).addGroup(other);

    public static void main(String[] args) throws Exception {
        REUtils.simpleStart();
        Options.loadFromFile(path+"another.options");
        Options.loadFromFile(path+"integers.options");

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);

        System.out.println(first.isBelongs(ints));
        System.out.println(second.isBelongs(ints));
        System.out.println(third.isBelongs(ints));

        System.out.println(first.isBelongs(other));
        System.out.println(second.isBelongs(other));
        System.out.println(third.isBelongs(other));

        Options.saveToFile(ints);
        Options.saveToFile(other); 
    }

}
