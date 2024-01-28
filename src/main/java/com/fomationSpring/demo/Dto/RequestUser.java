package com.fomationSpring.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestUser {
    Long id;
    String firstName;
    String lastName;
    Boolean status;
    @Max(value = 99999999, message = "phone number invalid")
    @Min(value = 10000000, message = "phone number invalid")
    int phoneNumber;
    @NotBlank(message = "email is required")
    @Email
    String email;
    @NotBlank(message = "password is required")
    String password;
    @Min(value = 1, message = "departmentId is required")
    Long departmentId;


}
