import ru.REStudios.utils.oop.REUtils;
import ru.REStudios.utils.options.Options;
import ru.REStudios.utils.options.custom.FloatOption;
import ru.REStudios.utils.options.custom.IntegerOption;
import ru.REStudios.utils.options.custom.StringOption;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class Test {

    public static final StringOption HELLO = new StringOption("hello");
    public static final IntegerOption INTEGER_OPTION = new IntegerOption("1",5);
    public static final FloatOption FLOAT_OPTION = new FloatOption("2",7f);

    public static void main(String[] args) throws Exception {
        REUtils.simpleStart();
        Options.loadFromFile("src/test/resources/test.options");
        System.out.println(HELLO.get());
        System.out.println(INTEGER_OPTION.get());
        System.out.println(FLOAT_OPTION.get());
        HELLO.set("hi forest");
        INTEGER_OPTION.set(5);
        FLOAT_OPTION.set(7.5f);
        Options.saveToFile("src/test/resources/test.options");
    }

}
