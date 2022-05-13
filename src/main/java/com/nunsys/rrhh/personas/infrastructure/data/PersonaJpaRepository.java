package com.nunsys.rrhh.personas.infrastructure.data;

import com.nunsys.rrhh.personas.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PersonaJpaRepository extends JpaRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {

}
