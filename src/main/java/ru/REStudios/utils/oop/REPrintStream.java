package ru.REStudios.utils.oop;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.PrintStream;

/**
 * (C) Copyright REStudios 2021
 *
 *
 * Simple debug console system
 * @see PrintStream
 */

public class REPrintStream extends PrintStream implements Thread.UncaughtExceptionHandler {

    public boolean isErrorStream = false;
    private final PrintStream original;

    public REPrintStream(PrintStream stream) {
        super(stream);
        original = stream;
    }

    int add = 0;

    @Override
    public void print(@Nullable String s) {
        StackTraceElement el = REUtils.getCaller(2+add);
        String clazz = el.getClassName()+":"+el.getLineNumber();
        original.printf("[%s %s %s] %s", Thread.currentThread().getName(), isErrorStream ? "ERROR" : "INFO", clazz, s);
    }

    @Override
    public void print(int i) {
        add = 1;
        this.print(String.valueOf(i));
        add = 0;
    }

    @Override
    public void print(double d) {
        add = 1;
        this.print(String.valueOf(d));
        add = 0;
    }

    @Override
    public void print(char c) {
        add = 1;
        this.print(String.valueOf(c));
        add = 0;
    }

    @Override
    public void print(long l) {
        add = 1;
        this.print(String.valueOf(l));
        add = 0;
    }

    @Override
    public void print(float f) {
        add = 1;
        this.print(String.valueOf(f));
        add = 0;
    }

    @Override
    public void print(boolean b) {
        add = 1;
        this.print(String.valueOf(b));
        add = 0;
    }

    @Override
    public void print(@Nullable Object obj) {
        add = 1;
        this.print(String.valueOf(obj));
        add = 0;
    }

    @Override
    public void print(char @NotNull [] s) {
        add = 1;
        this.print(String.valueOf(s));
        add = 0;
    }

    /**
     * Default setup
     */
    public static void setupPrints() {
        System.setOut(new REPrintStream(System.out));
        REPrintStream stream = new REPrintStream(System.err);
        stream.isErrorStream = true;
        System.setErr(stream);
        Thread.currentThread().setUncaughtExceptionHandler(stream);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace(original);
    }
}