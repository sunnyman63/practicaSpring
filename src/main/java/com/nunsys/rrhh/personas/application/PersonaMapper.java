package com.nunsys.rrhh.personas.application;

import com.nunsys.rrhh.personas.domain.Persona;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/*@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO personaToPersonaDto(Persona persona);
    Persona personaDtoToPersona(PersonaDTO persona);
}*/

@Mapper(componentModel = "spring")
public abstract class PersonaMapper {

    public abstract PersonaDTO personaToPersonaDto(Persona persona);
    public abstract Persona personaDtoToPersona(PersonaDTO persona);
    public Optional<PersonaDTO> personaToPersonaDto(Optional<Persona> persona) {
        if (persona.isPresent()) {
            return Optional.of(this.personaToPersonaDto(persona.get()));
        } else {
            return Optional.empty();
        }
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget PersonaDTO personaDTO) {
        personaDTO.setNombre(personaDTO.getNombre().toUpperCase());
    }
}
