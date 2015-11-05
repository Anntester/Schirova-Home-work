package com.kblyumkin.lecture7.examples.callcentre;

import com.kblyumkin.lecture7.examples.callcentre.impl.Call;
import com.kblyumkin.lecture7.examples.callcentre.impl.CallCentre;

import java.util.Arrays;

public class CallCentreTest1 {
    public static void main(String[] args) {
        Call[] calls = new Call[10];
        for (Call call : calls) {
            call = CallCentre.produceCall();
        }
        System.out.println(Arrays.toString(calls));
    }
}
