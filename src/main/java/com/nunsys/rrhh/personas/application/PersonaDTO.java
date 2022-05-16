package com.nunsys.rrhh.personas.application;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PersonaDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;
    private String direccion;
    private String ciudad;
    private String provincia;
    private boolean cesionDatos;
    private Integer valoracionServicio;
    private Integer edad;
    private Integer version;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean isCesionDatos() {
        return cesionDatos;
    }

    public void setCesionDatos(boolean cesionDatos) {
        this.cesionDatos = cesionDatos;
    }

    public Integer getValoracionServicio() {
        return valoracionServicio;
    }

    public void setValoracionServicio(Integer valoracionServicio) {
        this.valoracionServicio = valoracionServicio;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
