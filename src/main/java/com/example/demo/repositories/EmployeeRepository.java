package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long>{
    
}
