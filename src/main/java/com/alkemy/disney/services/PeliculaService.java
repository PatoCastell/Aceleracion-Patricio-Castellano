package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PeliculaBasicDTO;
import com.alkemy.disney.dtos.PeliculaDto;

import java.util.List;

public interface PeliculaService {
    PeliculaDto save(PeliculaDto dto);

    void delete(Long id);

    List<PeliculaBasicDTO> findAll();

    List<PeliculaDto> getByFilters(String name, Long idGenero, String order);

    PeliculaDto update(Long id, PeliculaDto dto);

    void savePersonaje(Long id, Long idPersonaje);

    void removePersonaje(Long id, Long idPersonaje);
}
