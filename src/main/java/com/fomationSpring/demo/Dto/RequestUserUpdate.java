package com.fomationSpring.demo.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestUserUpdate {
    Long id;
    String firstName;
    String lastName;
    Boolean status;
    int phoneNumber;
    @NotNull(message = "email is required")
    @Email
    String email;
    Long departmentId;
}
