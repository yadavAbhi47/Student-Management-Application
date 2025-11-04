package com.example.student_management.service.impl;

import com.example.student_management.dto.StudentDto;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found wit ID "+id));
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }

}
