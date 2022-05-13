package com.nunsys.rrhh.personas.infrastructure.data;

import com.nunsys.rrhh.personas.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaJpaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCase(String nombre, String apellidos);
}
