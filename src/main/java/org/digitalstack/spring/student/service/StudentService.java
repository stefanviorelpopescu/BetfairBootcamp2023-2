package org.digitalstack.spring.student.service;

import org.digitalstack.spring.student.converter.StudentConverter;
import org.digitalstack.spring.student.dao.StudentDao;
import org.digitalstack.spring.student.dto.StudentDto;
import org.digitalstack.spring.student.model.StudentModel;

import java.util.Optional;

public class StudentService
{
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    public boolean createStudent(StudentDto studentDto)
    {
        validateCreatePayload(studentDto);

        StudentModel studentModel = StudentConverter.convertDtoToModel(studentDto);

        return studentDao.createStudent(studentModel);
    }

    public boolean updateStudent(StudentDto studentDto)
    {
        validateUpdatePayload(studentDto);

        Optional<StudentModel> studentFromDb = studentDao.getStudentById(studentDto.getId(), false);
        if (studentFromDb.isEmpty()) {
            throw new UnsupportedOperationException("ID not found");
        }

        StudentModel studentModel = StudentConverter.convertDtoToModel(studentDto);
        return studentDao.updateStudent(studentModel);
    }

    private void validateUpdatePayload(StudentDto studentDto)
    {
        if (studentDto.getId() == null) {
            throw new IllegalArgumentException("no ID");
        }
        if (studentDto.getName() == null || studentDto.getName().isEmpty()) {
            throw new IllegalArgumentException("no name");
        }
        if (studentDto.getAge() == null || studentDto.getAge() < 14) {
            throw new IllegalArgumentException("no age");
        }
        if (studentDto.getGpa() == null) {
            throw new IllegalArgumentException("no gpa");
        }
    }

    private void validateCreatePayload(StudentDto studentDto)
    {
        if (studentDto.getId() != null) {
            throw new IllegalArgumentException("ID should not be present");
        }
        if (studentDto.getName() == null || studentDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Missing name");
        }
        if (studentDto.getAge() == null || studentDto.getAge() < 14) {
            throw new IllegalArgumentException("Invalid age");
        }
    }
}
