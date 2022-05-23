package com.alkemy.disney.mapper;

import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonajeMapper {
    @Autowired
    private PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDto2Entity(PersonajeDto dto) {
        PersonajeEntity entity= new PersonajeEntity();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setPeliculas(peliculaMapper.peliculaDtoList2EntityList(dto.getPeliculas()));
        entity.setHistoria(dto.getHistoria());
        entity.setPeso(dto.getPeso());
        return entity;
    }

    public PersonajeDto personajeEntity2DTO(PersonajeEntity entitySaved,boolean loadMovies) {
        PersonajeDto dto = new PersonajeDto();
        dto.setId(entitySaved.getId());
        dto.setImagen(entitySaved.getImagen());
        dto.setEdad(entitySaved.getEdad());
        dto.setPeso(entitySaved.getPeso());
        dto.setHistoria(entitySaved.getHistoria());
        dto.setNombre(entitySaved.getNombre());
        if(loadMovies) {
            dto.setPeliculas(peliculaMapper.peliculaEntityList2DTOList(entitySaved.getPeliculas(), false));
        }
        return dto;

    }

    public Set<PersonajeEntity> personajeDtoSet2EntitySet(Set<PersonajeDto> personajes) {
        Set<PersonajeEntity> personajeEntities = new HashSet<>();
        for(PersonajeDto dto: personajes){
            personajeEntities.add(personajeDto2Entity(dto));
        }
        return personajeEntities;
    }


    public Set<PersonajeDto> personajeEntitySet2DTOSet(Set<PersonajeEntity> personajes, boolean loadMovies) {
        Set<PersonajeDto> dtos = new HashSet<>();
        for (PersonajeEntity entity : personajes) {
            dtos.add(personajeEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }

    public List<PersonajeBasicDTO> personajeEntityList2BasicDTOList(List<PersonajeEntity> entities) {
        List<PersonajeBasicDTO> dtos = new ArrayList<>();
        for (PersonajeEntity entity: entities){
            dtos.add(personajeEntity2BasicDTO(entity));
        }
        return dtos;
    }

    private PersonajeBasicDTO personajeEntity2BasicDTO(PersonajeEntity entity) {
        PersonajeBasicDTO dto = new PersonajeBasicDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;
    }

    public List<PersonajeDto> personajeEntityList2DTOList(List<PersonajeEntity> entities, boolean b) {
        List<PersonajeDto> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities){
            dtos.add(personajeEntity2DTO(entity, b));
        }
        return dtos;
    }

    public void actualizarPersonaje(PersonajeDto dto, PersonajeEntity entity) {
        if(dto.getEdad()>0){
            entity.setEdad(dto.getEdad());
        }
        if (dto.getHistoria()!=null && !dto.getHistoria().isEmpty()){
            entity.setHistoria(dto.getHistoria());
        }
        if(dto.getImagen()!=null && !dto.getImagen().isEmpty()){
            entity.setImagen(dto.getImagen());
        }
        if(dto.getNombre()!=null && !dto.getNombre().isEmpty()){
            entity.setNombre(dto.getNombre());
        }
        if (dto.getPeso()>0){
            entity.setPeso(dto.getPeso());
        }
    }
}
