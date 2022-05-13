package com.nunsys.rrhh.personas.application;

public class PersonaCriteria {
    private final String nombre;
    private final String apellidos;
    private final Integer valoracionMinima;
    private final Integer valoracionMaxima;

    private PersonaCriteria(PersonaCriteriaBuilder builder) {
        this.nombre = builder.nombre;
        this.apellidos = builder.apellidos;
        this.valoracionMinima = builder.valoracionMinima;
        this.valoracionMaxima = builder.valoracionMaxima;
    }

    public String getNombre() { return this.nombre; }

    public String getApellidos() { return this.apellidos; }

    public Integer getValoracionMinima() {
        return valoracionMinima;
    }

    public Integer getValoracionMaxima() {
        return valoracionMaxima;
    }

    public static class PersonaCriteriaBuilder {
        private String nombre = "";
        private String apellidos = "";
        private Integer valoracionMinima = 0;
        private Integer valoracionMaxima = 10;

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

        public PersonaCriteriaBuilder setValoracionMinima(Integer valoracionMinima) {
            if(valoracionMinima != null) {
                this.valoracionMinima = valoracionMinima;
            }
            return this;
        }

        public PersonaCriteriaBuilder setValoracionMaxima(Integer valoracionMaxima) {
            if(valoracionMaxima != null) {
                this.valoracionMaxima = valoracionMaxima;
            }
            return this;
        }

        public PersonaCriteria build() {
            return new PersonaCriteria(this);
        }
    }
}
