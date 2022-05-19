package com.alkemy.disney.mapper;

import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {
    @Autowired
    private PersonajeMapper personajeMapper;
    public PeliculaEntity peliculaDTO2Entity(PeliculaDto dto) {
        PeliculaEntity entity = new PeliculaEntity();
        entity.setCalificacion(dto.getCalificacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setGeneroId(dto.getGeneroId());
        entity.setTitulo(dto.getTitulo());
        entity.setImagen(dto.getImagen());
        entity.setPersonajes(personajeMapper.personajeDtoSet2EntitySet(dto.getPersonajes()));
        return entity;
    }

    public List<PeliculaEntity> peliculaDtoList2EntityList(List<PeliculaDto> peliculas) {
        List<PeliculaEntity> entities = new ArrayList<>();
        for(PeliculaDto dto : peliculas){
            entities.add(peliculaDTO2Entity(dto));
        }
        return entities;
    }

    public PeliculaDto peliculaEntity2DTO(PeliculaEntity entity) {
        PeliculaDto dto = new PeliculaDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setCalificacion(entity.getCalificacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setTitulo(entity.getTitulo());
        dto.setGeneroId(entity.getGeneroId());
        dto.setPersonajes(personajeMapper.personajeEntitySet2DTOSet(entity.getPersonajes()));
        return dto;
    }
}
