package com.nunsys.rrhh.personas.application;

import com.nunsys.rrhh.personas.domain.Persona;
import com.nunsys.rrhh.personas.domain.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper mapper;

    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper mapper) {
        this.personaRepository = personaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonaDTO> getAllPersons() {
        List<PersonaDTO> personas = new ArrayList<>();
        personaRepository.findAll().forEach(
                persona -> personas.add(this.mapper.personaToPersonaDto(persona))
        );
        return personas;
    }

    public PersonaDTO crearPersona(PersonaDTO personaDto) {
        Persona persona = this.mapper.personaDtoToPersona(personaDto);
        persona = personaRepository.save(persona);
        return this.mapper.personaToPersonaDto(persona);
    }

    @Override
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<PersonaDTO> getPersona(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);
        return this.mapper.personaToPersonaDto(persona);
    }

    @Override
    public List<PersonaDTO> getPersonsByCriteria(PersonaCriteria personaCriteria, Optional<PageInfo> pageInfo) {
        List<PersonaDTO> personas = new ArrayList<>();
        personaRepository.findByCriteria(personaCriteria,pageInfo).forEach(
                persona -> personas.add(this.mapper.personaToPersonaDto(persona))
        );
        return personas;
    }

    @Override
    @Transactional
    public void updateCesionDatos(List<PersonaCesionDatosDTO> listaPersonas) {
        List<Persona> personas = getPersonas(listaPersonas);
        //Escritura en base de datos
        saveCesionDatos(personas);
    }

    private void saveCesionDatos(List<Persona> personas) {
        for(Persona persona: personas) {
            personaRepository.save(persona);
        }
    }

    private List<Persona> getPersonas(List<PersonaCesionDatosDTO> listaPersonas) {
        List<Persona> personas = new ArrayList<>();
        // Lectura y procesamineto de la información
        for(PersonaCesionDatosDTO personaCesionDatosDto: listaPersonas) {
            Optional<Persona> result = personaRepository.findById(personaCesionDatosDto.getId());
            if(result.isPresent()) {
                Persona persona = result.get();
                persona.setCesionDatos(personaCesionDatosDto.getCesionDatos());
                personas.add(persona);
            }
        }
        return personas;
    }

}
