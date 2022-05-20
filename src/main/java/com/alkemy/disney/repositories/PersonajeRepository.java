package com.alkemy.disney.repositories;

import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity,Long> {

    List<PersonajeEntity> findAll(Specification<PersonajeEntity> spec);
}
