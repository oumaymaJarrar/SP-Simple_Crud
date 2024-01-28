package com.fomationSpring.demo.Dto;

import com.fomationSpring.demo.Entities.Department;
import com.fomationSpring.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseDepartment {
    Long id;
    String adresse;
    Boolean status;
    String name;
    private Instant createdAt;
    private Instant updatedAt;
    private List<ResponseUser> user;
    public static ResponseDepartment makeDepartment(Department department){
        return ResponseDepartment.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();
    }
    public static ResponseDepartment makeDepartmentWithUser(Department department){
        List<User> users = department.getUser();
        List<ResponseUser> userFormated =new ArrayList<>();
        for(User user : users){
            ResponseUser member = ResponseUser.makeUserWithoutDepartment(user);
            userFormated.add(member);
        }
        return ResponseDepartment.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .user(userFormated)
                .build();
    }
}
