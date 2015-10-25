package com.kblyumkin.lecture4.examples.figures;

public class Circle extends AbstractFigure {
    private int x;
    private int y;
    private float radius;

    public Circle(int x, int y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return (Math.PI * Math.pow(radius, 2));
    }
}
