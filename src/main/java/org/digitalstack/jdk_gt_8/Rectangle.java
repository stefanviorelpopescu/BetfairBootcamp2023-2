package org.digitalstack.jdk_gt_8;

import lombok.Builder;

@Builder
public record Rectangle(Double length, Double width) {
    public Rectangle {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Invalid dimensions");
        }
    }
    // Public accessor method
    public Double length() {
        System.out.println("Length is " + length);
        return length;
    }

}
