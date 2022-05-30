package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDto save(PersonajeDto personajeDto);

    List<PersonajeBasicDTO> findAll();

    void delete(Long id);

    List<PersonajeDto> getByFilters(String name, Integer age, Set<Long> idMovies);

    PersonajeDto update(Long id, PersonajeDto dto);
}
