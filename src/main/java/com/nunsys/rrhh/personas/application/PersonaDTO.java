package com.nunsys.rrhh.personas.application;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PersonaDTO {
    private Integer id;
    private String nombre;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;
    private Integer edad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
