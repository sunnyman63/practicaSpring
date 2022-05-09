package com.nunsys.rrhh.personas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> getAllPersons() {
        List<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(employee -> personas.add(employee));
        return personas;
    }

    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> getPersona(Integer id) {
        return personaRepository.findById(id);
    }

}
