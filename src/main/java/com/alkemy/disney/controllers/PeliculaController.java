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
import java.util.ArrayList;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<PeliculaBasicDTO>> findAll(){
        int num = 1;
        List<PeliculaBasicDTO> dtos = peliculaService.findAll();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long idGenero,
            @RequestParam(required = false, defaultValue = "ASC") String order
            ){
        List<PeliculaDto> peliculasFiltradas = peliculaService.getByFilters(name, idGenero, order);
        return ResponseEntity.ok(peliculasFiltradas);

    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDto> update(@RequestBody PeliculaDto dto, @PathVariable Long id){
        PeliculaDto updated = peliculaService.update(id, dto);
        return ResponseEntity.ok().body(updated);
    }

    @PostMapping("/{id}/characters/{idPersonaje}")
    public ResponseEntity<PeliculaDto> addPersonaje(@PathVariable Long id, @PathVariable Long idPersonaje){
        peliculaService.savePersonaje(id, idPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/characters/{idPersonaje}")
    public ResponseEntity<PeliculaDto> removePersonaje(@PathVariable Long id, @PathVariable Long idPersonaje){
        peliculaService.removePersonaje(id, idPersonaje);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
