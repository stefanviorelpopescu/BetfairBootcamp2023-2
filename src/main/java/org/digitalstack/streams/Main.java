package org.digitalstack.streams;

import org.digitalstack.Student;

import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int x = 8;

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        TreeSet<Student> students = new TreeSet<>(Comparator.comparingInt(Student::getAge));

        students.forEach(System.out::println);

        logMessage((message, logLevel) -> System.out.println(message));

        lambdaTest();

        streamsTest();

    }

    private static void streamsTest() {

        List<String> names = List.of("Gigi", "Maria", "Ion", "Gogu", "Mara", "Vasile", "Ion");
        List<String> lines = List.of("Gigi e mare", "Maria e acasa", "Ion are mere", "Gogu doarme", "Mara mananca", "Vasile e la scoala");

        long count = names.stream()
                .distinct()
                .count();
        System.out.println(count);

        names.stream()
                .filter(s -> s.length() == 4)
                .map(s -> s.substring(0,1))
                .distinct()
                .forEach(System.out::println);

        List<String> names2 = names.stream()
                .filter(s -> s.length() > 3)
                .map(s -> s.substring(0, 1))
                .collect(Collectors.toList());

        long sum = names.stream()
                .map(String::length)
                .filter(length -> length > 3)
                .count();

        Integer i = names.stream()
                .map(String::length)
                .reduce((length1, length2) -> Math.min(length1 + length2, 50))
                .get();
        System.out.println(i);

        int sum1 = lines.stream()
                .mapToInt(line -> Stream.of(line.split(" "))
                        .mapToInt(String::length)
                        .sum())
                .sum();

        int sum2 = lines.stream()
                .flatMap(line -> Stream.of(line.split(" ")))
                .mapToInt(String::length)
                .sum();

        List<Student> buget = new ArrayList<>();
        List<Student> taxa = new ArrayList<>();

        OptionalDouble average = Stream.of(buget, taxa)
                .flatMap(Collection::stream)
                .mapToInt(Student::getAge)
                .average();
    }

    private static void lambdaTest() {

        int add = 2;
        List<String> strings = new ArrayList<>();
        strings.forEach(s -> System.out.println(s.length() + add));

        strings.forEach(s -> System.out.println(Integer.valueOf(s)));

    }

    static void logMessage(LoggerInterface loggerInterface) {
        loggerInterface.log("Test", Level.INFO);
    }
}
