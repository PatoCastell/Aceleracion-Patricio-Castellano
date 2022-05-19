package com.alkemy.disney.mapper;

import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.dtos.PersonajeDto;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonajeMapper {
    private PeliculaMapper peliculaMapper;
    public Set<PersonajeEntity> personajeDtoSet2EntitySet(Set<PersonajeDto> personajes) {
        Set<PersonajeEntity> personajeEntities = new HashSet<>();
        for(PersonajeDto dto: personajes){
            personajeEntities.add(personajeDto2Entity(dto));
        }
        return personajeEntities;
    }

    private PersonajeEntity personajeDto2Entity(PersonajeDto dto) {
        PersonajeEntity entity = new PersonajeEntity();
        entity.setEdad(dto.getEdad());
        entity.setHistoria(dto.getHistoria());
        entity.setImagen(dto.getImagen());
        entity.setPeso(dto.getPeso());
        entity.setPeliculas(peliculaMapper.peliculaDtoList2EntityList(dto.getPeliculas()));
        return entity;
    }


    public Set<PersonajeDto> personajeEntitySet2DTOSet(Set<PersonajeEntity> personajes) {
        Set<PersonajeDto> personajes2 = new HashSet<>();
        return personajes2;
    }
}
