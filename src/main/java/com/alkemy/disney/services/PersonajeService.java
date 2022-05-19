package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;

import java.util.List;

public interface PersonajeService {

    PersonajeDto save(PersonajeDto personajeDto);

    List<PersonajeBasicDTO> findAll();

    void delete(Long id);
}
