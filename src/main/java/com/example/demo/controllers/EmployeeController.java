package com.example.demo.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EmployeeModel;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController<fecha, Employee> {

    private static final String STRING = "";
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

    @PostMapping("/employees")
    public ResponseEntity<Employee> Employeemodel(@Validated @RequestBody Employee employee) {
        // Código para guardar el empleado en la base de datos
        // ...
    }
    
    /**
     *
     */
    SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
    try {
        String fechaString;
        Date fecha = (Date) sdf.parse(fechaString);
    } catch (ParseException e) {
         // Fecha inválida, manejo del error
    }

    Calendar fechaNacimiento = Calendar.getInstance();
    fechaNacimiento.setTime(employee.getFechaNacimiento());
    Calendar ahora = Calendar.getInstance();
    
    int diff_anios = ahora.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
    int diff_meses = ahora.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
    int diff_dias = ahora.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.get(Calendar.DAY_OF_MONTH);
    
    // Ajustar el cálculo de la edad si el mes y el día actual son menores que el mes y el día de nacimiento
    if (diff_meses < 0 || (diff_meses == 0 && diff_dias < 0)) {
        diff_anios--;
    }
    
    if (diff_anios < 18); {
     // El empleado no es mayor de edad, manejo del error

    }
}
}