package com.kblyumkin.lecture7.examples.generics;

import com.kblyumkin.lecture7.examples.callcentre.impl.Call;
import com.kblyumkin.lecture7.examples.callcentre.impl.CallCentre;

import java.util.Arrays;
import java.util.List;

public class MyArraysTest {
    public static void main(String[] args) {
        List<Call> list = MyArrays.asList(CallCentre.produceCall(),
                CallCentre.produceCall(),
                CallCentre.produceCall());
        System.out.println(Arrays.toString(list.toArray()));

        for (Call call : list) {
             call.sayHello();
        }
    }
}
