package org.digitalstack.shape;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a circle");
    }

    @Override
    public int getSides() {
        throw new RuntimeException();
    }
}
