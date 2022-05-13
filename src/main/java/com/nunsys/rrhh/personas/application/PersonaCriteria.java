package com.nunsys.rrhh.personas.application;

public class PersonaCriteria {
    private final String nombre;
    private final String apellidos;

    private PersonaCriteria(PersonaCriteriaBuilder builder) {
        this.nombre = builder.nombre;
        this.apellidos = builder.apellidos;
    }

    public String getNombre() { return this.nombre; }

    public String getApellidos() { return this.apellidos; }

    public static class PersonaCriteriaBuilder {
        private String nombre = "";
        private String apellidos = "";

        public PersonaCriteriaBuilder setNombre(String nombre) {
            if(nombre != null) {
                this.nombre = nombre;
            }
            return this;
        }

        public PersonaCriteriaBuilder setApellidos(String apellidos) {
            if(apellidos != null) {
                this.apellidos = apellidos;
            }
            return this;
        }

        public PersonaCriteria build() {
            return new PersonaCriteria(this);
        }
    }
}
