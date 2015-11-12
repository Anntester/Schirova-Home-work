package com.kblyumkin.lecture8.examples.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Peter", "Mike");

        for (String name : names) {
            System.out.println(name);
        }

        for (Iterator iter = names.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }

    }
}
