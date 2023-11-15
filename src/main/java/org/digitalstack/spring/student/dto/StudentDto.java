package org.digitalstack.spring.student.dto;

import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "with")
@Data
public class StudentDto
{
    private Long id;
    private String name;
    private Integer age;
    private Double gpa;
}
