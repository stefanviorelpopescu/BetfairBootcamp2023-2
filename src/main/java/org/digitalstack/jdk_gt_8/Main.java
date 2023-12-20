package org.digitalstack.jdk_gt_8;

public class Main {
    public static void main(String[] args) {
        Day day = Day.WEDNESDAY;
        int numLetters = 0;
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                numLetters = 6;
                break;
            case TUESDAY:
                numLetters = 7;
                break;
            case THURSDAY:
            case SATURDAY:
                numLetters = 8;
                break;
            case WEDNESDAY:
                numLetters = 9;
                break;
            default:
                throw new
                        IllegalStateException("Invalid day: " + day);
        }

        numLetters = 0;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY -> numLetters = 7;
            case THURSDAY, SATURDAY -> numLetters = 8;
            case WEDNESDAY -> numLetters = 9;
            default -> throw new
                    IllegalStateException("Invalid day: " + day);
        };

        numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new
                    IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        numLetters = switch (day)
        {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                yield 6;
            case TUESDAY:
                System.out.println(7);
                yield 7;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                yield 8;
            case WEDNESDAY:
                System.out.println(9);
                yield 9;
            default:
                throw new
                        IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        Rectangle rectangle = new Rectangle(5.0, 5.0);
        System.out.println(rectangle.width());

        RectangleLombok rectangleLombok = new RectangleLombok(5, 5);
        System.out.println(rectangleLombok.getLength());

        Rectangle rectangle1 = Rectangle.builder()
                .length(52.0)
                .build();
        System.out.println(rectangle1);

        patternMatching();

    }

    private static void patternMatching() {

    }
    public interface Polygon { }
    public class Triangle { }

    public void work(Triangle t) {
        Polygon p = (Polygon) t;
    }

    String name = """
            Pat Q. Smith
            """;
    String html = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;
}
