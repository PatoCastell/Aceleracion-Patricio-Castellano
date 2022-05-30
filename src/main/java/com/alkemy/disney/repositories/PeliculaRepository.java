package com.alkemy.disney.repositories;

import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    public List<PeliculaEntity> findAll(Specification<PeliculaEntity> spe);
}
