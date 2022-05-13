package com.nunsys.rrhh.personas.infrastructure.data;

import com.nunsys.rrhh.personas.domain.Persona;
import com.nunsys.rrhh.personas.domain.PersonaRepository;
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
    public List<Persona> findByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCase(String nombre, String apellidos){
        return personaJpaRepository.findByNombreContainsIgnoreCaseAndApellidosContainsIgnoreCase(nombre, apellidos);
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
