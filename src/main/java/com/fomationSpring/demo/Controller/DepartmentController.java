package com.fomationSpring.demo.Controller;

import com.fomationSpring.demo.Dto.RequestDepartment;
import com.fomationSpring.demo.Dto.ResponseDepartment;
import com.fomationSpring.demo.Entities.Department;
import com.fomationSpring.demo.Service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("")
    public ResponseEntity<List<ResponseDepartment>> getAllDepartment(){
        List<ResponseDepartment> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }
    @PostMapping("")
    public ResponseEntity<Object> addDepartment(@RequestBody @Valid RequestDepartment request){
        departmentService.createDepartment(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !")
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseDepartment> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateDepartment(
            @PathVariable(name="id") Long id,
            @RequestBody @Valid RequestDepartment request ){
        departmentService.updateDepartment(id, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping(value = "{id}")
    public  ResponseEntity<Object> deleteDepartment (@PathVariable Long id){
        boolean deleteDepartment = departmentService.deleteDepartment(id);
        if (deleteDepartment){
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "deleted success !!")
            );
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "department not exist ")
            );

    }
}
