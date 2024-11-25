package com.example.employee_management.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonApiResponse<T>{
    private int status;
    private String message;
    private T data;

}
