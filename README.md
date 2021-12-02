# REUtils
Simple utils for our projects. They are really usefull!

This is it. A lot of cool utils, like file handling, number operations, string helper, options system (that is very easy-to-use)

Let's start with simple. 

# PrintStream

It will format any output to:
```text
[<thread-name> <level> <class:line>] <output>
```

thread-name - Name of the thread, where printstream used. 

level - can be ERROR or INFO (at this moment). If written in error print stream, `ERROR`, otherwise `INFO`.

class:line - simple class and nime where the method was used. Wraps like Test:20

**Example**:
```text
[main INFO Test:25] Hello everyone!
```

To use it, just call `REPrintStream.setupPrints()` and it's done!


# REUtils class
This section provides information about REUtils class


## Safe casting
`castOrNull(Class;Object)` is a method, that performs simple cast operation. It will return casted value or null if can't.

## Safe equals
`safeEquals(Object;Object)` does null-safe equals action. First object is a priority object.

## Getting method's caller
`getCaller(Integer)` returns stacktrace element, useful when need to get caller's class name

# Simple Start
`simpleStart()` setups our printstream and uses method Time.getTime() to set timeStarted. (About him look at bottom of this file)

# Options system

You don't need any registrations to use my API, its I tried to make it maximum easy-to-use.

## Simple usage

This code shows how to create custom options, get their values, load them from files, and save them, and set values!

**Example**:
```java
    // Creating our options
    public static final StringOption HELLO = new StringOption("hello","not loaded");
    public static final IntegerOption INTEGER_OPTION = new IntegerOption("1",5); // 5 is default value if this option is not loaded from anywhere
    public static final FloatOption FLOAT_OPTION = new FloatOption("2",7f);

    public static void main(String[] args) throws Exception {
        REUtils.simpleStart();
        // Loading them from file
        Options.loadFromFile("src/test/resources/test.options");
        System.out.println(HELLO.get());
        System.out.println(INTEGER_OPTION.get());
        System.out.println(FLOAT_OPTION.get());
        // Setting values
        HELLO.set("hi forest");
        INTEGER_OPTION.set(5);
        FLOAT_OPTION.set(7.5f);
        // And saving our file!
        Options.saveToFile("src/test/resources/test.options");
    }
```

That's it! 

## Creating custom options

To create custom option you need to extend class `Option<T>`, where is T is your option class. (See example below)

```java
/**
 * (C) Copyright REStudios 2021
 *
 * @author SorestForest
 */
public class IntegerOption extends Option<Integer> {
    public IntegerOption(String inFileName, Integer defaultValue) {
        super(inFileName, defaultValue);
    }

    // Load value from string
    @Override
    public void setFromString(String str) {
        set(RENumbers.parseInteger(str));
    }

    // Save value to string!
    @Override
    public String writeInString() {
        return String.valueOf(get());
    }
}
```
# RENumbers

