package com.alkemy.disney.services.implem;

import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeImplem implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDto save(PersonajeDto dto) {
        PersonajeEntity entity = personajeMapper.personajeDto2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.personajeEntity2DTO(entitySaved, true);
        return result;
    }

    public List<PersonajeBasicDTO> findAll(){
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeBasicDTO> dtos = personajeMapper.personajeEntityList2BasicDTOList(entities);
        return dtos;
    }

    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }
}
