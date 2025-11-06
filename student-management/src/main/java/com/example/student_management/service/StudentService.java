package com.example.student_management.service;

import com.example.student_management.dto.AddStudentRequestDto;
import com.example.student_management.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentId(Long id);

    StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(long id, Map<String, Object> updates);
}
