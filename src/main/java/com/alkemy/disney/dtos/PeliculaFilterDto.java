package com.alkemy.disney.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaFilterDto {
    private String name;
    private Long idGenero;
    private String order;

    public PeliculaFilterDto(String name, Long idGenero, String order) {
        this.name = name;
        this.idGenero = idGenero;
        this.order = order;
    }

    public boolean isAsc(){
        return this.order.compareToIgnoreCase("ASC") ==0;
    }
    public boolean isDesc(){
        return this.order.compareToIgnoreCase("Desc") ==0;
    }
}
