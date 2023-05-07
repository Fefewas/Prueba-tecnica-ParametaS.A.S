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
    public EmployeeModel getEmployeeDetails(EmployeeModel employee){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaVinculacion = employee.getFechaVinculacion();
        LocalDate fechaNacimiento = employee.getFechaNacimiento();
        int ageYears = Period.between(fechaNacimiento, fechaActual).getYears();
        int longevityYears = Period.between(fechaVinculacion, fechaActual).getYears();
        employee.setAge(ageYears);
        employee.setLongevity(longevityYears);
        return employee;
    }
}
