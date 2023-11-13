package org.digitalstack.shape;

import java.util.ArrayList;
import java.util.List;

public interface Shape {
    static  final int sides = 3;

    default void draw() {
        List<Integer> sidesSizes = new ArrayList<>();
        for (int i = 0; i < sides; i++) {
            System.out.println(sidesSizes.get(i));
        }
        System.out.println("this is a shape");
    }

    int getSides();
}
