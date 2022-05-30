package com.alkemy.disney.dtos;

import com.alkemy.disney.entities.PeliculaEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonajeDto {
    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;
    private List<PeliculaDto> peliculas = new ArrayList<>();
}
