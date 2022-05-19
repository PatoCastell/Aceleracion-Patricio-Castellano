package com.alkemy.disney.services;

import com.alkemy.disney.dtos.PeliculaDto;

public interface PeliculaService {
    PeliculaDto save(PeliculaDto dto);

    void delete(Long id);
}
