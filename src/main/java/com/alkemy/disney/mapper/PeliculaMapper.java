package com.alkemy.disney.mapper;

import com.alkemy.disney.dtos.PeliculaBasicDTO;
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

    public PeliculaDto peliculaEntity2DTO(PeliculaEntity entity, boolean loadCharacter) {
        PeliculaDto dto = new PeliculaDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setCalificacion(entity.getCalificacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setTitulo(entity.getTitulo());
        dto.setGeneroId(entity.getGeneroId());
        if(loadCharacter) {
            dto.setPersonajes(personajeMapper.personajeEntitySet2DTOSet(entity.getPersonajes(), false));
        }
        return dto;
    }

    public List<PeliculaDto> peliculaEntityList2DTOList(List<PeliculaEntity> peliculas, boolean load) {
        List<PeliculaDto> dtos = new ArrayList<>();
        for(PeliculaEntity entity: peliculas){
            dtos.add(this.peliculaEntity2DTO(entity, load));
        }
        return dtos;
    }

    public List<PeliculaBasicDTO> peliculaEntityList2BasicDTOList(List<PeliculaEntity> entities) {
        List<PeliculaBasicDTO> dtos = new ArrayList<>();
        for(PeliculaEntity entity: entities){
            dtos.add(peliculaEntity2DTOBasic(entity));
        }
        return dtos;
    }

    private PeliculaBasicDTO peliculaEntity2DTOBasic(PeliculaEntity entity) {
        PeliculaBasicDTO dto = new PeliculaBasicDTO();
        dto.setId(entity.getId());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        return dto;
    }

    public void actualizarPelicula(PeliculaDto dto, PeliculaEntity entity) {
        if (dto.getCalificacion()>0 && dto.getCalificacion() <6){
            entity.setCalificacion(dto.getCalificacion());
        }
        if (dto.getImagen()!=null && !dto.getImagen().isBlank()){
            entity.setImagen(dto.getImagen());
        }
        if (dto.getTitulo()!=null && !dto.getTitulo().isBlank()){
            entity.setTitulo(dto.getTitulo());
        }
        if (dto.getGeneroId()!=null && dto.getGeneroId()!=0){
            entity.setGeneroId(dto.getGeneroId());
        }
        if (dto.getFechaCreacion()!=null){
            entity.setFechaCreacion(dto.getFechaCreacion());
        }
    }
}
