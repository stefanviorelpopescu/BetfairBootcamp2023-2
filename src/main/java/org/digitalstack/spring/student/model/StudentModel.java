package org.digitalstack.spring.student.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class StudentModel
{
    private Long id;
    private String name;
    private Integer age;
    private Double gpa;
}
