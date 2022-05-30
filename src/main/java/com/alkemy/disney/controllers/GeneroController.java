package com.alkemy.disney.controllers;

import com.alkemy.disney.services.GeneroService;
import com.alkemy.disney.dtos.GeneroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroDto dto){
         GeneroDto generoGuardado =  generoService.save(dto);
         return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

}
