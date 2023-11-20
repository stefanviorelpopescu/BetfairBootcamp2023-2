package org.digitalstack.design_patterns;

import org.digitalstack.design_patterns.atm.Atm;
import org.digitalstack.design_patterns.observer.Student;
import org.digitalstack.design_patterns.observer.Teacher;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee.EmployeeBuilder("Gigi", 25)
                .withHasChildren(true)
                .withIsMarried(false)
                .withDrivingLicense(true)
                .build();

        Employee employee2 = new Employee.EmployeeBuilder("Gogu", 30)
                .withDrivingLicense(true)
                .withDriversLicenseExpirationDate(2134656L)
                .build();

//        LombokEmployee employee3 = LombokEmployee.builder()
//                .withHasDrivingLicence(true)
//                .withIsMarried(false)
//                .build();

        Atm atm = new Atm();
        atm.withdraw(480);
        atm.withdraw(1800);
        atm.withdraw(4200);
        atm.withdraw(90);
        atm.withdraw(90);

        Student student1 = new Student("Gigi");
        Student student2 = new Student("Gelu");
        Teacher teacher = new Teacher();
        teacher.speak("Message for nobody");
        student1.subscribe(teacher);
        teacher.speak("Message for Gigi");
        student2.subscribe(teacher);
        teacher.speak("Message for everyone");
        student1.unsubscribe(teacher);
        teacher.speak("Message for Gelu");
    }
}
