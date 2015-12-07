package com.kblyumkin.lecture8.examples.streams;

import java.io.*;
import java.net.URL;


/* Not correct example - streams haven't been closed */
public class ReadByByteExample {
    public static void main(String[] args)/* throws IOException */{
        InputStream fromFile = null;
        try {
            fromFile = new FileInputStream(
                    new File("/Users/kblyumkin/Projects/SourceIt/resources/fadeToBlack.txt"));
            readByByte(fromFile);

            InputStream fromUrl = new URL("http://www.google.com").openStream();
            readByByte(fromUrl);

            InputStream fromByteArray = new ByteArrayInputStream(
                    new byte[]{65, 12, 39, 64, 75, 86, 97});
            readByByte(fromByteArray);
        } catch (IOException e) {
            throw new RuntimeException("Error opening or reading stream", e);
        } finally {
            if (fromFile != null) {
                try {
                    fromFile.close();
                } catch (IOException ignore){
                    /*NOP*/
                }
            }
        }
    }

    private static void readByByte(InputStream is) throws IOException{
        int oneByte;
        while (true) {
            oneByte = is.read();
            if (oneByte != -1) {
                System.out.print((char) oneByte);
            } else {
                System.out.println("\n" + "The end!" + "\n");
                break; //while
            }
        }
    }
}
