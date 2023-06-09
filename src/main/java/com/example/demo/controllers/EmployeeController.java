package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmployeeModel;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeModel> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("/employee/{id}")
    public Optional<EmployeeModel> getEmployeeDetails(@PathVariable("id") Long id) {
        return this.employeeService.employeeDetails(id);
    }
    @PostMapping("/saveEmployee")
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee) {
        
        return employeeService.saveEmployee(employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        boolean ok = this.employeeService.deleteEmployee(id);
        if(ok){
            return "Se eliminó el empleado con el id: " + id;
        }
        else{
            return "No se encontró el empleado con el id: " + id;
        }
    }
}