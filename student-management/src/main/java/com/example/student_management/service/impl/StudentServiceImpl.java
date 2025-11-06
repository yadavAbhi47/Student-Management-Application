package com.example.student_management.service.impl;

import com.example.student_management.dto.AddStudentRequestDto;
import com.example.student_management.dto.StudentDto;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentId(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id: " + id);
        }
        studentRepository.deleteById(id);

    }

    @Override
    public StudentDto updateStudent(long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found wit ID "+id));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }



    @Override
    public StudentDto updatePartialStudent(long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found wit ID "+id));
        updates.forEach((field, value) -> {
            switch(field){
                case "name": student.setName((String) value);
                break;
                case "email" : student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent= studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

}
