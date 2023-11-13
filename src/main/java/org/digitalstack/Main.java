package org.digitalstack;

import com.sun.source.tree.Tree;
import org.digitalstack.exception.MyException;
import org.digitalstack.exception.MyThrowable;
import org.digitalstack.shape.Circle;
import org.digitalstack.shape.Shape;
import org.digitalstack.shape.Square;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static final int MAX_BILL_COUNT = 200;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> numbers = new ArrayList<>();

        List<Integer> numbers2 = new LinkedList<>();

        Student student = new Student();
        student.saveData(numbers);
        student.saveData(numbers2);

        int n;
        double d;
        List<Integer> numbers3 = new ArrayList<>();

        Shape shape = new Square();
        shape.draw();

        Shape circle = new Circle();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shape);
        shapes.add(circle);

        for (Shape shape2 : shapes) {
            shape.draw();
        }

        try {
            throw new MyException("test exception");
        } catch (MyException e) {
            System.out.println("exception");
        }

        shape = new Circle();

        try {
            throw new MyThrowable("test throwable");
        } catch (Throwable e) {
            System.out.println("throwable");
        }

        shape.draw();

        WorkingStudent workingStudent = new WorkingStudent();
        workingStudent.saveData(numbers);


        TreeSet<Student> sortedStudents = new TreeSet<>();
        TreeSet<Student> sortedStudents3 = new TreeSet<>(new StudentComparatorByAge());

        TreeSet<Student> sortedStudents2 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return 0;
            }
        });
        TreeSet<Student> sortedStudents22 = new TreeSet<>((s1, s2) -> 0);

        Thread thread1 = new Thread(() -> System.out.println("test"));
        thread1.start();

        sortedStudents.add(new Student());
        sortedStudents.add(new Student());
        sortedStudents.add(new Student());
        sortedStudents.add(new Student());

        sortedStudents.stream()
                .map(Student::getAge)
                .filter(age -> age == 25)
                .forEach(System.out::println);

        student.endlessMethod();

        Map<String, List<Integer>> studentAgesByLastName = new HashMap<>();
        for (Student sortedStudent : sortedStudents) {
            String lastName = sortedStudent.getLastName();
            studentAgesByLastName.computeIfAbsent(lastName, k -> new ArrayList<>())
                    .add(sortedStudent.getAge());
        }

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}