package com.example.student_management.service.impl;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
        return studentDtoList;
    }

    ;
}
