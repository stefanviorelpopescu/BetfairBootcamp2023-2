package org.digitalstack.shape;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("this is a square");
    }

    @Override
    public int getSides() {
        return 4;
    }
}
