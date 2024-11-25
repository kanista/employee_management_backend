package com.example.employee_management.services;

import com.example.employee_management.DTOs.CreateDepartmentDto;
import com.example.employee_management.DTOs.DepartmentResponseDto;
import com.example.employee_management.entities.Department;
import com.example.employee_management.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentResponseDto createDepartment(CreateDepartmentDto dto) {
        Department department = new Department();
        department.setDepartmentCode(dto.getDepartmentCode());
        department.setDepartmentName(dto.getDepartmentName());

        Department savedDepartment = departmentRepository.save(department);

        return new DepartmentResponseDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentCode(),
                savedDepartment.getDepartmentName()
        );
    }

    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(department -> new DepartmentResponseDto(
                        department.getId(),
                        department.getDepartmentCode(),
                        department.getDepartmentName()
                ))
                .collect(Collectors.toList());
    }
}
