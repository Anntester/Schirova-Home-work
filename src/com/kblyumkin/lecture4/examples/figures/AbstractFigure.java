package com.kblyumkin.lecture4.examples.figures;

public abstract class AbstractFigure implements Figure {

    @Override
    public abstract double getSquare();

    @Override
    public void introduce() {
        System.out.println("Hello, I'm a " + this.getClass().getSimpleName());
    }
}
