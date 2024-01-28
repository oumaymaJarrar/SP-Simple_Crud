package com.fomationSpring.demo.Service;

import com.fomationSpring.demo.Dto.RequestDepartment;
import com.fomationSpring.demo.Dto.ResponseDepartment;
import com.fomationSpring.demo.Entities.Department;

import java.util.List;

public interface DepartmentService {
    List<ResponseDepartment> getAllDepartment();
    boolean deleteDepartment(Long id);
    void createDepartment( RequestDepartment departmentRequest);
    Department updateDepartment(Long id, RequestDepartment departmentRequest);
    ResponseDepartment getDepartmentById(Long id);

}
