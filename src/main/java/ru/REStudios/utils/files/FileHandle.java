package ru.REStudios.utils.files;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * (C) Copyright REStudios 2021
 *  Simple file operator
 * @author SorestForest
 */
@SuppressWarnings("unused")
public class FileHandle {

    /**
     * Fields
     * relativePath - path from working directory
     * fullPath - path in OS
     * file - file instance
     * needReload - does need reload before next reading
     * content - pre-saved content
     * alwaysUpdate - do we need always reload this file
     */
    public final String relativePath;
    public final String fullPath;
    private final File file;
    private boolean needReload = true;
    private byte[] content;
    private boolean alwaysUpdate = false;

    private static final String appender = System.getProperty("user.dir")+File.separator;

    /**
     * Simple setup
     * @param path to file. relative or full
     */
    public FileHandle(String path){
        this.file = new File(path.replace("/","\\"));
        this.relativePath = asRelative(path.replace("/","\\"));
        this.fullPath = asFull(path.replace("/","\\"));
    }


    public static String[] getPaths(String unknownPath){
        String relativePath;
        String fullPath;
        File file = new File(unknownPath);
        if (!file.exists()){
            try {
                System.err.println(unknownPath);
                throw new FileNotFoundException("We can't do anything with unknown file!");
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
        if (file.isAbsolute()){
            fullPath = unknownPath;
        } else {
            fullPath = appender+unknownPath;
        }
        relativePath = unknownPath;
        return new String[]{fullPath,relativePath};
    }

    /**
     * Returns this path as relative or full in OS (depends on what you provide)
     * @param path relative or full
     * @return relative or full path in OS (depends on what path you give)
     */
    public static String asRelative(String path){
        return getPaths(path)[1];
    }

    /**
     * Returns this path as full in OS
     * @param path relative or full
     * @return full path
     */
    public static String asFull(String path){
        return getPaths(path)[0];
    }

    /**
     * Reads file
     * @return byte array from file
     * @throws IOException if occurs
     */
    public byte[] readAllBytes() throws IOException {
        if (needReload || alwaysUpdate){
            FileInputStream stream = new FileInputStream(file);
            content = stream.readAllBytes();
            needReload = false;

            stream.close();
        }
        return content;
    }

    /**
     * Reads this file as string
     * @return string value in file
     * @throws IOException if occurs
     */
    public String readAsString(Charset charset) throws IOException {
        return new String(readAllBytes(),charset);
    }

    /**
     * Reads this file as UTF-8 String
     * @return string in file
     * @throws IOException if occurs
     */
    public String readUTF8() throws IOException {
        return new String(readAllBytes(), StandardCharsets.UTF_8);
    }

    /**
     * Reads this file as string, and splits it by lines
     * @return lines from file
     * @throws IOException if occurs
     */
    public String[] readAllLines(Charset charset) throws IOException {
        return readAsString(charset).split("\n");
    }

    /**
     * Reads this file as string and splits it by lines.
     * @return lines from file.
     * @throws IOException - if occurs
     */
    public String[] readAllLinesUTF8() throws IOException {
        return readAllLines(StandardCharsets.UTF_8);
    }

    /**
     * Streams file
     * @return stream
     */
    public FileInputStream fileStream(){
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads this file as image
     * @return image in this file
     * @throws IOException if occurs
     */
    public BufferedImage readAsImage() throws IOException {
        return ImageIO.read(new ByteArrayInputStream(readAllBytes()));
    }

    /**
     * Sets bytes to this file
     * @param bytes to set
     * @throws IOException if occurs
     */
    public void writeBytes(byte[] bytes) throws IOException {
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(bytes);
        stream.close();
    }

    /**
     * Sets content to this string
     * @param s to set
     * @throws IOException if occurs
     */
    public void writeString(String s) throws IOException {
        FileWriter writer = new FileWriter(file,false);
        writer.write(s);
        writer.flush();
        writer.close();
    }

    /**
     * Appends string to file
     * @param s to append
     * @throws IOException if occurs
     */
    public void appendString(String s) throws IOException {
        FileWriter writer = new FileWriter(file,true);
        writer.write(s);
        writer.flush();
        writer.close();
    }

    /**
     * Appends byte array to file
     * @param bytes to append
     * @throws IOException if occurs
     */
    public void appendBytes(byte[] bytes) throws IOException {
        FileOutputStream stream = new FileOutputStream(file,true);
        stream.write(bytes);
        stream.flush();
        stream.close();
    }

    /**
     * Returns relative path in working directory
     * @return relative path in working directory
     */
    public String getRelativePath() {
        return relativePath;
    }

    /**
     * Returns full path of object
     * @return full path in OS
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * Sets alwaysUpdate mode
     * @return this
     */
    public FileHandle alwaysUpdate(){
        alwaysUpdate = true;
        return this;
    }

    /**
     * Request reload content
     * @return this
     */
    public FileHandle reloadContent(){
        needReload = true;
        return this;
    }



}
