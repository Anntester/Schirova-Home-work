package com.kblyumkin.lecture4.examples.figures;

public class FiguresTest {
    public static void main(String[] args) {
        Figure figure = new Circle(0, 0, 1);
        figure.introduce();
        System.out.println("Circles square is " + figure.getSquare());

        Figure square = new Square(0, 0, 1, 1);
        square.introduce();
        System.out.println("Square's square is " + square.getSquare());
    }
}
