package com.nunsys.rrhh.personas.infrastructure.data;

import com.nunsys.rrhh.personas.application.PageInfo;
import com.nunsys.rrhh.personas.application.PersonaCriteria;
import com.nunsys.rrhh.personas.domain.Persona;
import com.nunsys.rrhh.personas.domain.PersonaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
    private final PersonaJpaRepository personaJpaRepository;

    PersonaRepositoryImpl(PersonaJpaRepository personaJpaRepository) {
        this.personaJpaRepository = personaJpaRepository;
    }

    @Override
    public List<Persona> findByCriteria(PersonaCriteria personaCriteria, Optional<PageInfo> pageInfo){
        LikeSpecification<Persona> predicatedByNombre = new LikeSpecification<>(
                "nombre",
                personaCriteria.getNombre()
        );
        LikeSpecification<Persona> predicatedByApellidos = new LikeSpecification<>(
                "apellidos",
                personaCriteria.getApellidos()
        );
        BetweenSpecification<Persona> predicatedBetweenValoracion = new BetweenSpecification<>(
                "valoracionServicio",
                personaCriteria.getValoracionMinima(),
                personaCriteria.getValoracionMaxima()
        );
        Specification<Persona> specification = Specification
                .where(predicatedByNombre)
                .and(predicatedByApellidos)
                .and(predicatedBetweenValoracion);
        if(pageInfo.isPresent()) {
            Pageable pageable = PageRequest.of(pageInfo.get().getPage(),pageInfo.get().getPageSize(), Sort.by("apellidos"));
            return personaJpaRepository.findAll(specification,pageable).getContent();
        }
        return personaJpaRepository.findAll(specification);
    };

    @Override
    public Iterable<Persona> findAll() {
        return personaJpaRepository.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return personaJpaRepository.save(persona);
    }

    @Override
    public void deleteById(Integer id) {
        personaJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> findById(Integer id) {
        return personaJpaRepository.findById(id);
    }
}
