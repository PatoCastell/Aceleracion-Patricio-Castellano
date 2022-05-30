package com.alkemy.disney.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFilterDto {
    private String name;
    private Integer age;
    private Set<Long> idMovies;

    public PersonajeFilterDto(String name, Integer age, Set<Long> idMovies) {
        this.name = name;
        this.age = age;
        this.idMovies = idMovies;
    }
}
