package com.example.demo.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmployeeModel;
import com.example.demo.repositories.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ArrayList<EmployeeModel> getEmployees(){
        // Tomar los datos de todos los empleados en la base de datos
        return (ArrayList<EmployeeModel>) employeeRepository.findAll();
    }

    public EmployeeModel safeEmployee(EmployeeModel employee){
        // Guardar el empleado
        return employeeRepository.save(employee);
    }


    public EmployeeModel getEmployeeDetails(EmployeeModel employee) {
        // Calcular edad actual en años, meses y días
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(employee.getFechaNacimiento(), ahora);
        int edadAnos = periodo.getYears();
        int edadMeses = periodo.getMonths();
        int edadDias = periodo.getDays();

        // Calcular tiempo trabajado en años, meses y días
        periodo = Period.between(employee.getFechaVinculacion(), ahora);
        int tiempoTrabajoAnos = periodo.getYears();
        int tiempoTrabajoMeses = periodo.getMonths();
        int tiempoTrabajoDias = periodo.getDays();

        // Crear objeto JSON con los resultados
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("edadAnos", edadAnos);
        json.put("edadMeses", edadMeses);
        json.put("edadDias", edadDias);
        json.put("tiempoTrabajoAnos", tiempoTrabajoAnos);
        json.put("tiempoTrabajoMeses", tiempoTrabajoMeses);
        json.put("tiempoTrabajoDias", tiempoTrabajoDias);

        // Asignar el objeto JSON al atributo correspondiente de la clase EmployeeModel
        employee.setEmployeeDetails(json);

        return employee;

    }

    public ArrayList<EmployeeModel> getEmployeesDetails() {
        return null;
    }

}
