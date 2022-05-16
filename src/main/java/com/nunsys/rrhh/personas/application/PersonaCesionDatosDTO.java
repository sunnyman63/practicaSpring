package com.nunsys.rrhh.personas.application;

public class PersonaCesionDatosDTO {
    private Integer id;
    private Boolean cesionDatos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCesionDatos() {
        return cesionDatos;
    }

    public void setCesionDatos(Boolean cesionDatos) {
        this.cesionDatos = cesionDatos;
    }
}
