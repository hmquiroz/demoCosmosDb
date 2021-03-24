package com.bcp.democosmosdb.core.service;

import com.bcp.democosmosdb.core.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDto dto);
    void deleteStudent(StudentDto dto);
    List<StudentDto> getStudents();
    StudentDto getStudent(String id);
}
