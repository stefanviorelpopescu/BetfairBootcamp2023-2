package org.digitalstack;

import java.util.List;

public class Student implements Comparable<Student>{

    private int age = 25;

    private String lastName;

    public void saveData(List<Integer> grades) {
        try {
            Integer grade = grades.get(0);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        System.out.println(grades.size());
    }


//    public void saveData(List<Double> grades) {
//
//        System.out.println(grades.size());
//    }

    public boolean saveData(List<Integer> grades, boolean stopOnFail) {
        return false;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void endlessMethod() {
        try {
            while (true) {
                this.endlessMethod();
            }
        } catch (Throwable e) {
            System.out.println("this is fine");
//            throw new RuntimeException(e);
        }
    }
}
