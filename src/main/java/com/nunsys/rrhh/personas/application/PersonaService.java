package com.nunsys.rrhh.personas.application;

import com.nunsys.rrhh.personas.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<PersonaDTO> getAllPersons();
    PersonaDTO crearPersona(PersonaDTO persona);
    void deletePersona(Integer id);
    Optional<PersonaDTO> getPersona(Integer id);
    List<PersonaDTO> getPersonsByCriteria(PersonaCriteria personaCriteria, Optional<PageInfo> pageInfo);
    void updateCesionDatos(List<PersonaCesionDatosDTO> listaPersonas);
    PersonaDTO updatePersona(PersonaDTO personaDTO);
}
