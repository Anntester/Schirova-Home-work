package com.kblyumkin.lecture7.examples.generics;

import java.util.LinkedList;
import java.util.List;

public class MyArrays {
    private MyArrays() {}

    public static <T> List<T> asList(T...args) {
        List<T> result =  new LinkedList();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }
}
