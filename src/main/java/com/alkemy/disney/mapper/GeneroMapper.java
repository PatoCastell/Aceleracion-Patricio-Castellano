package com.alkemy.disney.mapper;

import com.alkemy.disney.dtos.GeneroDto;
import com.alkemy.disney.entities.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {
    public GeneroEntity generoDto2Entity(GeneroDto dto) {
        GeneroEntity entity = new GeneroEntity();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public GeneroDto generoEntity2Dto(GeneroEntity entity) {
        GeneroDto dto = new GeneroDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;
    }

    public List<GeneroDto> generoEntityList2DTOList(List<GeneroEntity> entities) {
        List<GeneroDto> dtos = new ArrayList<>();
        for(GeneroEntity entity : entities){
            dtos.add(generoEntity2Dto(entity));
        }
        return dtos;
    }
}
