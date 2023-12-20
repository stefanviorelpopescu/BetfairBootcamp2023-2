package org.digitalstack.jdk_gt_8.shape;

public sealed interface Shape permits Circle, Square, Rectangle {
    static double getPerimeter(Shape s) throws
            IllegalArgumentException {
        if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            return 2 * r.getLength() + 2 * r.getWidth();
        } else if (s instanceof Circle) {
            Circle c = (Circle) s;
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }
    static double getPerimeterPattern(Shape s) throws
            IllegalArgumentException {
        if (s instanceof Rectangle r) {
            return 2 * r.getLength() + 2 * r.getWidth();
        } else if (s instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }

    static double getPerimeterSwitchPattern(Shape s) throws
            IllegalArgumentException {
        return switch(s) {
            case Rectangle r -> 2 * r.getLength() + 2 * r.getWidth();
            case Circle c -> 2 * c.radius() * Math.PI;
            default -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }

    static double getPerimeterSwitchStatement(Shape s) throws
            IllegalArgumentException {
        switch (s) {
            case Rectangle r:
                return 2 * r.getLength() + 2 * r.getWidth();
            case Circle c:
                return 2 * c.radius() * Math.PI;
            default:
                throw new IllegalArgumentException
                        ("Unrecognized shape");
        }
    }

    record Point(double x, double y) {}

    static void printAngleFromXAxisTypePattern(Object obj) {
        if (obj instanceof Point p) {
            System.out.println(Math.toDegrees(Math.atan2(p.y(), p.x())));
        }
    }

    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Point(double x, double y)) {
            System.out.println(Math.toDegrees(Math.atan2(y, x)));
        }
    }
}
