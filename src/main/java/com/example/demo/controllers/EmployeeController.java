package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmployeeModel;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ArrayList<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeModel safetEmployee(@RequestBody EmployeeModel employee){
        return this.employeeService.safeEmployee(employee);
    }

    public EmployeeResponse getEmployeeInfo(@RequestBody Employee employee) {
        if (employee.getNombres().isEmpty() || employee.getApellidos().isEmpty() || 
            employee.getTipoDocumento().isEmpty() || employee.getNumeroDocumento().isEmpty()) {
            throw new IllegalArgumentException("Campos vacíos no permitidos");
        }
    }

}
