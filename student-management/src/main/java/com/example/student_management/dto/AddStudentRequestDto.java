package com.example.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data

public class AddStudentRequestDto {
    private String name;
    @Email
    @NotBlank(message = "Email required")
    private String email;
}
