package com.nunsys.rrhh.personas.application;

import com.nunsys.rrhh.personas.domain.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDTO personaToPersonaDto(Persona persona);
    Persona personaDtoToPersona(PersonaDTO persona);
}
