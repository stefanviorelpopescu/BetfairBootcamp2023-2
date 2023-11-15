package org.digitalstack.spring.student.controller;

import org.digitalstack.spring.student.dto.StudentDto;
import org.digitalstack.spring.student.service.StudentService;

public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    public boolean createStudent(StudentDto requestBody) {
        return studentService.createStudent(requestBody);
    }

    public boolean updateStudent(StudentDto requestBody) {
        return studentService.updateStudent(requestBody);
    }
}
