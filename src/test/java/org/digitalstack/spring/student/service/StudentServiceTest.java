package org.digitalstack.spring.student.service;

import org.digitalstack.spring.student.dao.StudentDao;
import org.digitalstack.spring.student.dto.StudentDto;
import org.digitalstack.spring.student.model.StudentModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDao studentDao;

    @InjectMocks
    StudentService studentService;

//    @BeforeAll
//    public static void setup() {
//        studentDao = mock(StudentDao.class);
//        studentService = new StudentService(studentDao);
//    }

    @Test
    public void whenCreatePayloadWithId_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(123L)
                .withAge(45)
                .withName("Gigi")
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(studentDto));

        //then
        assertEquals("ID should not be present", ex.getMessage());
    }

    @Test
    public void whenCreatePayloadMissingName_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withAge(45)
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(studentDto));

        //then
        assertEquals("Missing name", ex.getMessage());
    }

    @Test
    public void whenCreatePayloadMissingAge_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withName("Gigi")
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(studentDto));

        //then
        assertEquals("Invalid age", ex.getMessage());
    }

    @Test
    public void whenCreatePayloadHasLowAge_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withName("Gigi")
                .withAge(12)
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.createStudent(studentDto));

        //then
        assertEquals("Invalid age", ex.getMessage());
    }

    @Test
    public void whenCreatePayloadIsValid_returnTrue() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withName("Gigi")
                .withAge(45)
                .build();
        when(studentDao.createStudent(any())).thenReturn(true);

        //when
        boolean result = studentService.createStudent(studentDto);

        //then
        assertTrue(result);
    }

    @Test
    public void whenUpdatePayloadIsValid_returnTrue() {
        //given
        long studentId = 123L;
        StudentDto studentDto = StudentDto.builder()
                .withId(studentId)
                .withName("Gigi")
                .withAge(45)
                .withGpa(9.50)
                .build();
        StudentModel dbModel = StudentModel.builder()
                .withId(studentId)
                .build();
        when(studentDao.getStudentById(eq(123L), anyBoolean())).thenReturn(Optional.of(dbModel));
        when(studentDao.updateStudent(any(StudentModel.class))).thenReturn(true);

        //when
        boolean result = studentService.updateStudent(studentDto);

        //then
        assertTrue(result);
    }

    @Test
    public void whenUpdatePayloadIdNotFound_throwException() {
        //given
        long studentId = 123L;
        StudentDto studentDto = StudentDto.builder()
                .withId(studentId)
                .withName("Gigi")
                .withAge(45)
                .withGpa(9.50)
                .build();
        when(studentDao.getStudentById(eq(123L), anyBoolean())).thenReturn(Optional.empty());

        //when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> studentService.updateStudent(studentDto));

        //then
        assertEquals("ID not found", exception.getMessage());
    }

    @Test
    public void whenUpdatePayloadMissingId_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withAge(45)
                .withName("Gigi")
                .withGpa(9.50)
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(studentDto));

        //then
        assertEquals("no ID", ex.getMessage());
    }

    @Test
    public void whenUpdatePayloadMissingName_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(123L)
                .withAge(45)
                .withGpa(9.50)
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(studentDto));

        //then
        assertEquals("no name", ex.getMessage());
    }

    @Test
    public void whenUpdatePayloadMissingAge_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(123L)
                .withName("Gigi")
                .withGpa(9.50)
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(studentDto));

        //then
        assertEquals("no age", ex.getMessage());
    }

    @Test
    public void whenUpdatePayloadMissingGpa_throwIllegalArgumentException() {
        //given
        StudentDto studentDto = StudentDto.builder()
                .withId(123L)
                .withAge(45)
                .withName("Gigi")
                .build();

        //when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(studentDto));

        //then
        assertEquals("no gpa", ex.getMessage());
    }

}