package com.fomationSpring.demo.Dto;

import com.fomationSpring.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseUser {
    Long id;
    String firstName;
    String lastName;
    Boolean status;
    int phoneNumber;
    String email;
    String password;
    Long departmentId;
    private Instant createdAt;
    private  Instant updatedAt;
    private ResponseDepartment department;
    public static ResponseUser makeUser(User user){
        return  ResponseUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .status(user.getStatus())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .departmentId(user.getDepartment().getId())
                .department(ResponseDepartment
                        .makeDepartment(user.getDepartment()))
                .build();
    }
    public static ResponseUser makeUserWithoutDepartment(User user){
        return  ResponseUser.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .status(user.getStatus())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
