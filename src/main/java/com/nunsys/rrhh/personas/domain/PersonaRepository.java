package com.nunsys.rrhh.personas.domain;

import com.nunsys.rrhh.personas.application.PageInfo;
import com.nunsys.rrhh.personas.application.PersonaCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    List<Persona> findByCriteria(PersonaCriteria personaCriteria, Optional<PageInfo> pageInfo);
    Iterable<Persona> findAll();
    Persona save(Persona persona);
    void deleteById(Integer id);
    Optional<Persona> findById(Integer id);
}
