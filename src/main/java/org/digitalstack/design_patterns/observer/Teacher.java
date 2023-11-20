package org.digitalstack.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    List<Student> students = new ArrayList<>();

    public void subscribe(Student student) {
        students.add(student);
    }

    public void unsubscribe(Student student) {
        students.remove(student);
    }

    public void speak(String message) {
        notifySubscribers(message);
    }

    private void notifySubscribers(String message) {
        for (Student student : students) {
            student.notify(message);
        }
    }

}
