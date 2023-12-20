package org.digitalstack.jdk_gt_8.shape;

import lombok.Data;

@Data
public sealed class Rectangle implements Shape permits FilledRectangle {
    public double length, width;
}
