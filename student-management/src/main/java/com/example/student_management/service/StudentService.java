package com.example.student_management.service;

import com.example.student_management.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
