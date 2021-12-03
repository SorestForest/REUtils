import ru.REStudios.utils.event.Event;
import ru.REStudios.utils.event.EventListener;
import ru.REStudios.utils.event.EventManager;
import ru.REStudios.utils.event.Listener;
import ru.REStudios.utils.oop.REUtils;
import ru.REStudios.utils.options.OptionGroup;
import ru.REStudios.utils.options.custom.IntegerOption;

/**
 * (C) Copyright REStudios 2021
 *
 * @author REStudios
 */
public class Test {

    public static final String path = "src/test/resources/";

    public static final OptionGroup GROUP = new OptionGroup("ints");
    public static final IntegerOption OPTION = (IntegerOption) new IntegerOption("option",5).addGroup(GROUP);

    public static void main(String[] args) throws Exception {
        REUtils.simpleStart();
        TestEvent event = new TestEvent("hello forest");
        AnotherEvent a = new AnotherEvent(14);
        TestHandler handler = new TestHandler();
        EventManager.registerHandler(handler);
        EventManager.parseEvent(event);
        EventManager.parseEvent(a);


    }

    public static class TestEvent extends Event {

        public String s;

        public TestEvent(String s){
            this.s = s;
        }

    }

    public static class AnotherEvent extends Event {

        public int a;

        public AnotherEvent(int a) {
            this.a = a;
        }
    }

    public static class TestHandler implements Listener {

        // And marking methods to our system. If this annotation is not present, handler won't work.
        @EventListener
        public void onTestEvent(TestEvent event){
            print(event.s);
        }

        // You can make even two!
        @EventListener
        public void onOtherEvent(AnotherEvent event){
            print(event.a);
        }

        @EventListener
        public void onOtherEventAgain(AnotherEvent event){
            print(event.a+" again!");
        }

        public void print(Object o){
            System.out.println(o);
        }
    }

}
