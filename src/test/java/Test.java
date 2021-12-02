import ru.REStudios.utils.oop.RENumbers;
import ru.REStudios.utils.oop.REUtils;
import ru.REStudios.utils.options.Options;
import ru.REStudios.utils.options.custom.ObjectOption;

import java.awt.*;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class Test {

    public static final ObjectOption<Dimension> test = new ObjectOption<>("test", new Dimension(),
            //
            args -> {
        String[] nums = args[0].split(":");
        int a = RENumbers.parseInteger(nums[0]);
        int b = RENumbers.parseInteger(nums[1]);
        return new Dimension(a,b);
    }, (dimension, s) -> s.append(dimension.width).append(":").append(dimension.height));
    public static void main(String[] args) throws Exception {
        REUtils.simpleStart();
        Options.loadFromFile("src/test/resources/test.options");
        System.out.println(test.get());
        test.get().width = 25;
        test.get().height = 126;
        Options.saveToFile("src/test/resources/test.options");
    }

}
