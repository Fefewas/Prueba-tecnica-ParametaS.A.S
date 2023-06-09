package com.example.demo.services;

import java.util.*;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmployeeModel;
import com.example.demo.repositories.EmployeeRepository;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    
    //This function returns a list of all employees from the employee repository.
    public List<EmployeeModel> getEmployees(){
        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    /*
    This function saves an employee model object to the employee repository and returns the saved
    object.
    */
    public EmployeeModel saveEmployee(EmployeeModel employee){
        return employeeRepository.save(employee);
    }

    public boolean deleteEmployee(Long id){
        try{
            employeeRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    /*
    This function returns an optional EmployeeModel object by searching for an employee with the
    given ID in the employee repository.
    */
    public Optional<EmployeeModel> employeeDetails(Long id){
        return employeeRepository.findById(id);
    }

}