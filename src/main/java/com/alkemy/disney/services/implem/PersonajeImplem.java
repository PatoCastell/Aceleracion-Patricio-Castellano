package com.alkemy.disney.services.implem;

import com.alkemy.disney.dtos.PersonajeFilterDto;
import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.repositories.specification.PersonajeSpecification;
import com.alkemy.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonajeImplem implements PersonajeService {
    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeSpecification personajeSpecification;

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
        PersonajeEntity personaje = personajeRepository.findById(id).orElse(null);
        if(personaje == null){
            throw new ParamNotFound("id de personaje no valido");
        }
        personajeRepository.deleteById(id);
    }

    public List<PersonajeDto> getByFilters(String name, Integer age, Set<Long> idMovies) {
        PersonajeFilterDto personajeFilterDto = new PersonajeFilterDto(name, age, idMovies);
        List<PersonajeEntity> entities = this.personajeRepository.findAll(this.personajeSpecification.getByFilter(personajeFilterDto));
        List<PersonajeDto> dtos = this.personajeMapper.personajeEntityList2DTOList(entities, true);
        return dtos;
    }

    public PersonajeDto update(Long id, PersonajeDto dto) {
        PersonajeEntity entity = personajeRepository.findById(id).orElse(null);
        if (entity == null){
                throw new ParamNotFound("id de personaje no valido");
        }


        personajeMapper.actualizarPersonaje(dto, entity);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.personajeEntity2DTO(entitySaved, true);
        return result;
    }
}
