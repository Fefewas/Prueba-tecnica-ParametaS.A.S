package com.example.demo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.*;

@Entity
@Table(name="Employee")
public class EmployeeModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(length = 60, nullable = false)
    private String nombres;
    @Column(length = 60, nullable = false)
    private String apellidos;
    @Column(length = 60, nullable = false)
    private String tipoDocumento;
    @Column(length = 60, nullable = false)
    private String numeroDocumento;
    @Column(length = 60, nullable = false)
    public LocalDate fechaNacimiento;
    @Column(length = 60, nullable = false)
    private LocalDate fechaVinculacion;
    @Column(length = 60, nullable = false)
    private String cargo;
    @Column(length = 60, nullable = false)
    private double salario;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }
    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    //Este modelo de encarga de la creación de los getters y setters, además de la creación de las respectivas tablas que irán en la base de datos mysql

}
