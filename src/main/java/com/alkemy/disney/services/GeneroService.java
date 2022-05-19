package com.alkemy.disney.services;

import com.alkemy.disney.dtos.GeneroDto;

import java.util.List;


public interface GeneroService {
    GeneroDto save(GeneroDto dto);

    List<GeneroDto> getAll();
}
