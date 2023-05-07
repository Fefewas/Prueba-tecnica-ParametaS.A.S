package com.example.demo.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmployeeModel;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<EmployeeModel> getEmployees(){
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel safeEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }
    public EmployeeModel getEmployeeDetails(LocalDate fechaVinculacion){
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaVinculacion, fechaActual);
    }
}
