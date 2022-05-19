package com.alkemy.disney.controllers;

import com.alkemy.disney.dtos.PersonajeBasicDTO;
import com.alkemy.disney.dtos.PersonajeDto;
import com.alkemy.disney.repositories.PersonajeRepository;
import com.alkemy.disney.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDto> save(@RequestBody PersonajeDto personajeDto){
        PersonajeDto dtoSaved = personajeService.save(personajeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSaved);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeBasicDTO>> findAll(){
        List<PersonajeBasicDTO> personajes = personajeService.findAll();
        return  ResponseEntity.ok().body(personajes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
