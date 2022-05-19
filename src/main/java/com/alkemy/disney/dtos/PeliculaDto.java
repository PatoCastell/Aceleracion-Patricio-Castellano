package com.alkemy.disney.dtos;
import com.alkemy.disney.entities.PersonajeEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PeliculaDto {
    private Long id;
    private String imagen;
    private String titulo;
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;
    @Min(value = 0)
    @Max(value = 5)
    private Integer calificacion;
    private Long generoId;
    private Set<PersonajeDto> personajes = new HashSet<>();
}
