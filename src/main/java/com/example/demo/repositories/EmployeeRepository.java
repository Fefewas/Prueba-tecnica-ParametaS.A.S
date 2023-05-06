package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Long>{
    public abstract ArrayList<EmployeeModel> findBy()
}
