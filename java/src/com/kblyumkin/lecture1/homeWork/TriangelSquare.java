package com.kblyumkin.lecture1.homeWork;

public class TriangelSquare {
    public static void main(String[] args) {
        int x1 = 1, y1 = 1;
        int x2 = 10, y2 = 7;
        int x3 = -3, y3 = 4;

        double x1x2 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double x2x3 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double x3x1 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));

        double p = (x1x2 + x2x3 + x3x1) / 2;

        double square = Math.sqrt(p*(p-x1x2) * (p-x2x3)*(p-x3x1));

        double length = x1x2 + x2x3 + x3x1;
        System.out.println("Length of all sides is " + length);
        System.out.println("Square is " + square);
    }
}
