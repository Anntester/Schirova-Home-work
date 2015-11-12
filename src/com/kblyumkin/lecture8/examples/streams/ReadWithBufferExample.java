package com.kblyumkin.lecture8.examples.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadWithBufferExample {
    public static final String FILE_NAME = "/Users/kblyumkin/Projects/SourceIt/resources/fadeToBlack.txt";
    public static final int BUFFER_SIZE  = 10;

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_NAME);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            readWithBuffer(is);
        } catch (IOException e) {
            throw new IOException("Error opening or reading file " + FILE_NAME, e);
        } finally {
            closeSilently(is);
        }
    }

    private static void closeSilently(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException ignore){
                /*NOP*/
            }
        }
    }

    private static void readWithBuffer(InputStream is) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int count;
        while ((count = is.read(buffer)) != -1) {
            System.out.println("Read " + count
                    + " bytes - " + Arrays.toString(buffer)
                    + new String(buffer, 0, count));
        }
        System.out.println("\n" + "The end!\n");
    }
}
