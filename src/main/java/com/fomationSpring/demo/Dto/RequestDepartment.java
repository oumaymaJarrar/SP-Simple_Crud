package com.fomationSpring.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RequestDepartment {
    Long id;
    String name;
    String adresse;
    Boolean status;


}
