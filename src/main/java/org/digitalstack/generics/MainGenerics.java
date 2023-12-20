package org.digitalstack.generics;

import org.digitalstack.DayOfWeek;
import org.digitalstack.RemoteControl;
import org.digitalstack.Student;
import org.digitalstack.StudentComparatorByAge;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainGenerics {

    public static void main(String[] args) {
        List objects = new ArrayList();

        objects.add(45);
        objects.add("test");
        objects.add(false);

        for (Object object : objects) {
            if (object instanceof Integer) {
                Integer number = (Integer) object;
                System.out.println(number);
            }
        }

        List<String> strings = new ArrayList<>();
        for (String string : strings) {
            System.out.println(string);
        }
        var myInts = new ArrayList<>();
        addNumbers(myInts);

        Integer [] numbers = new Integer[25];

        Integer number = 6;
        Integer number2 = 6;
        System.out.println(number == number2);

        String s1 = "test";
        String s2 = "test test";
        String s3 = "test";

        System.out.println(s1 == s3);

        var list = new ArrayList<>(Arrays.asList(numbers));
        list.add(5);

        iteratorTests();

        var workingDays = EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);

        mapTests();
    }

    private static void mapTests() {
        var numberMap = new HashMap<Integer, Integer>();
        numberMap.put(1, 2);
        numberMap.putIfAbsent(2, 3);

        var allStudents = new ArrayList<Student>();

        var studentsByAge = new HashMap<Integer, List<Student>>();
        for (var student : allStudents) {
            if (!studentsByAge.containsKey(student.getAge())) {
                studentsByAge.put(student.getAge(), new ArrayList<>());
            }
            studentsByAge.get(student.getAge()).add(student);

            studentsByAge.computeIfAbsent(student.getAge(), i -> new ArrayList<>())
                    .add(student);
        }
        studentsByAge.clear();

        var studentsMapByAge = allStudents.stream()
                .collect(Collectors.groupingBy(Student::getAge));


        int ageSum = 0;
        allStudents.forEach(student -> System.out.println(ageSum));

    }

    private static void iteratorTests() {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();
            if (number % 2 == 1) {
                iterator.remove();
            }
        }

        numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> toDelete = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                toDelete.add(number);
            }
        }
        numbers.removeAll(toDelete);
        System.out.println(numbers.size());

        System.out.println("---------");
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 2);
        map.put(2, 4);
        for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            Integer integerIntegerEntry = iterator.next();
            System.out.println(integerIntegerEntry);
            map.remove(2);
        }

        List<Integer> numbers3 = List.of(1,2,3,4,5,6,7,8,9,10,11);
        Spliterator<Integer> spliterator = numbers3.spliterator();
        System.out.println(spliterator.getExactSizeIfKnown());
        Spliterator<Integer> spliterator1 = spliterator.trySplit();
        System.out.println(spliterator.getExactSizeIfKnown());
        System.out.println(spliterator1.getExactSizeIfKnown());

        spliterator.forEachRemaining(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        spliterator1.forEachRemaining(System.out::println);

        numbers3.parallelStream()
                .forEach(x -> System.out.println(Thread.currentThread().getName() + " : " + x));

    }

    public static void addNumbers(List<? super Integer> numbers) {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        System.out.println(numbers.get(2));
    }

}
