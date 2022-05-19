package com.alkemy.disney.services.implem;

import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repositories.PeliculaRepository;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaImplem implements PeliculaService {
    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaDto save(PeliculaDto dto) {
        PeliculaEntity entity = peliculaMapper.peliculaDTO2Entity(dto);
        PeliculaEntity peliculaSaved = peliculaRepository.save(entity);
        PeliculaDto result = peliculaMapper.peliculaEntity2DTO(peliculaSaved, true);
        return result;
    }

    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }
}
