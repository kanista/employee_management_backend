package com.example.employee_management.controller;

import com.example.employee_management.DTOs.CommonApiResponse;
import com.example.employee_management.DTOs.CreateDepartmentDto;
import com.example.employee_management.DTOs.DepartmentResponseDto;
import com.example.employee_management.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping

    public ResponseEntity<CommonApiResponse<DepartmentResponseDto>> createDepartment(@RequestBody @Valid CreateDepartmentDto dto) {
        DepartmentResponseDto department = departmentService.createDepartment(dto);
        return ResponseEntity.ok(
                new CommonApiResponse<>(200, "Department created successfully", department)
        );
    }

    @GetMapping
    public ResponseEntity<CommonApiResponse<List<DepartmentResponseDto>>> getAllDepartments() {
        List<DepartmentResponseDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(
                new CommonApiResponse<>(200, "Departments fetched successfully", departments)
        );
    }

}
