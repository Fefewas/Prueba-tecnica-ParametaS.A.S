package com.example.demo.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmployeeModel;
import com.example.demo.services.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        if (employee.getNombres().isEmpty() || employee.getApellidos().isEmpty() || 
            employee.getTipoDocumento().isEmpty() || employee.getNumeroDocumento().isEmpty()) {
            throw new IllegalArgumentException("Campos vacíos no permitidos");
        }
        else{
            return this.employeeService.safeEmployee(employee);
        }
    }

    @PostMapping
    public void checkAge(@RequestBody EmployeeModel employee) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String dateString = sdf.format(employee.getFechaNacimiento());
            Date date = new Date(sdf.parse(dateString).getTime());
            Calendar fechaNacimiento = Calendar.getInstance();
            fechaNacimiento.setTime(date);
            Calendar now = Calendar.getInstance();
            
            int diff_years = now.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
            int diff_months = now.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
            int diff_days = now.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);
            
            if (diff_months < 0 || (diff_months == 0 && diff_days < 0)) {
                diff_years--;
            }
            
            if (diff_years < 18) {
                throw new IllegalArgumentException("El empleado debe ser mayor de edad");
            }
        } catch (ParseException ex) {
            // manejar la excepción
        }
    }
}
