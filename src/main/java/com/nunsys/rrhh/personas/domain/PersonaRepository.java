package com.nunsys.rrhh.personas.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    List<Persona> findByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCase(String nombre, String apellidos);
    Iterable<Persona> findAll();
    Persona save(Persona persona);
    void deleteById(Integer id);
    Optional<Persona> findById(Integer id);
}
