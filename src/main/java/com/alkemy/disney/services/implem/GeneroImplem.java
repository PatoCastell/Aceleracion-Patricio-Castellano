package com.alkemy.disney.services.implem;

import com.alkemy.disney.mapper.GeneroMapper;
import com.alkemy.disney.services.GeneroService;
import com.alkemy.disney.dtos.GeneroDto;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroImplem implements GeneroService {
    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;



    public GeneroDto save(GeneroDto dto) {
        GeneroEntity entity = generoMapper.generoDto2Entity(dto);
        GeneroEntity generoGuardado = generoRepository.save(entity);
        GeneroDto result = generoMapper.generoEntity2Dto(generoGuardado);
        return result;
    }


    public List<GeneroDto> getAll() {
        List<GeneroEntity> entities = generoRepository.findAll();
        List<GeneroDto> dtos = generoMapper.generoEntityList2DTOList(entities);
        return dtos;
    }


    public void delete(Long id) {
        this.generoRepository.deleteById(id);
    }
}
