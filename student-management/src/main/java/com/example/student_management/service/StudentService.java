package com.example.student_management.service;

import com.example.student_management.dto.AddStudentRequestDto;
import com.example.student_management.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
}
