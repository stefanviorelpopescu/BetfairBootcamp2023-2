package org.digitalstack.design_patterns.observer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Student {

    String name;

    private void takeNotes(String message) {
        System.out.println(name + " : " + message);
    }

    public void notify(String message) {
        takeNotes(message);
    }

    public void subscribe(Teacher teacher) {
        teacher.subscribe(this);
    }

    public void unsubscribe(Teacher teacher) {
        teacher.unsubscribe(this);
    }
}
