package com.alkemy.disney.services.implem;

import com.alkemy.disney.dtos.PeliculaBasicDTO;
import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.dtos.PeliculaFilterDto;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repositories.PeliculaRepository;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.repositories.specification.PeliculaSpecification;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaImplem implements PeliculaService {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaSpecification peliculaSpecification;
    @Autowired
    private PersonajeRepository personajeRepository;

    public PeliculaDto save(PeliculaDto dto) {
        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity peliculaSaved = peliculaRepository.save(entity);
        PeliculaDto result = peliculaMapper.peliculaEntity2DTO(peliculaSaved, true);
        return result;
    }

    public void delete(Long id) {
        PeliculaEntity pelicula = peliculaRepository.findById(id).orElse(null);
        if(pelicula == null){
            throw new ParamNotFound("id de pelicula no valido");
        }
        peliculaRepository.delete(pelicula);
    }

    @Override
    public List<PeliculaBasicDTO> findAll() {
        List<PeliculaEntity> entities = peliculaRepository.findAll();
        List<PeliculaBasicDTO> dtos = peliculaMapper.peliculaEntityList2BasicDTOList(entities);
        return dtos;
    }

    public List<PeliculaDto> getByFilters(String name, Long idGenero, String order) {
    PeliculaFilterDto filterDto = new PeliculaFilterDto(name, idGenero, order);
    List<PeliculaEntity> entities = peliculaRepository.findAll(this.peliculaSpecification.getByFilter(filterDto));
    List<PeliculaDto> dtos = peliculaMapper.peliculaEntityList2DTOList(entities, true);
        return dtos;
    }

    public PeliculaDto update(Long id, PeliculaDto dto) {
        PeliculaEntity entity = peliculaRepository.findById(id).orElse(null);
        if(entity==null){
            throw new ParamNotFound("id de pelicula no valido");
        }
        peliculaMapper.actualizarPelicula(dto,entity);
        PeliculaEntity entitySaved = peliculaRepository.save(entity);
        PeliculaDto result = peliculaMapper.peliculaEntity2DTO(entitySaved, true);
        return result;
    }

    public void savePersonaje(Long id, Long idPersonaje) {
        PeliculaEntity pelicula = peliculaRepository.findById(id).orElse(null);
        if(pelicula == null){
            throw new ParamNotFound("id de pelicula no valido");
        }
        PersonajeEntity personaje = personajeRepository.findById(idPersonaje).orElse(null);
        if(personaje == null){
            throw new ParamNotFound("id de personaje no valido");
        }
        pelicula.getPersonajes().add(personaje);
        peliculaRepository.save(pelicula);
    }

    public void removePersonaje(Long id, Long idPersonaje) {
        PeliculaEntity pelicula = peliculaRepository.findById(id).orElse(null);
        if(pelicula == null){
            throw new ParamNotFound("id de pelicula no valido");
        }

        PersonajeEntity personaje = personajeRepository.findById(idPersonaje).orElse(null);
        if(personaje == null){
            throw new ParamNotFound("id de personaje no valido");
        }
        pelicula.getPersonajes().remove(personaje);
    }
}
