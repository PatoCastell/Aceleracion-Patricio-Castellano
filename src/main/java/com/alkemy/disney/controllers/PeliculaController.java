package com.alkemy.disney.controllers;

import com.alkemy.disney.dtos.PeliculaBasicDTO;
import com.alkemy.disney.dtos.PeliculaDto;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movies")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDto> save (@Valid @RequestBody PeliculaDto dto){
        PeliculaDto peliculaGuardada = peliculaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<PeliculaBasicDTO>> findAll(){
        List<PeliculaBasicDTO> dtos = peliculaService.findAll();
        return ResponseEntity.ok().body(dtos);
    }
}
