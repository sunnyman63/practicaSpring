package com.nunsys.rrhh.personas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "RRHH_PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;
    @Transient
    private Integer edad;

    @Column(nullable = true, length = 10)
    private String telefono;
    private String direccion;
    private String ciudad;
    private String provincia;
    private boolean cesionDatos;
    private Integer valoracionServicio;

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
        this.edad = calculateAge(fechaNacimiento, Calendar.getInstance().getTime());
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.edad = calculateAge(fechaNacimiento, Calendar.getInstance().getTime());
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    private int calculateAge(Date birthDate, Date currentDate) {
        DateFormat formatter = new SimpleDateFormat("yyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        int age = (d2 - d1) / 10000;
        return age;
    }
}
