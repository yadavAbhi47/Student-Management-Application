package com.example.student_management.controller;


import com.example.student_management.dto.StudentDto;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public List<StudentDto> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable Long id){
        return "Path variable " + id;
    }
}
