package com.alkemy.disney.repositories.specification;

import com.alkemy.disney.dtos.PeliculaFilterDto;
import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpecification {

    public Specification<PeliculaEntity> getByFilter(PeliculaFilterDto filtersDTO) {

            return (root, query, criteriaBuilder) -> {
                List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();


                if (StringUtils.hasLength(filtersDTO.getName())) {
                    predicates.add(criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("titulo")),
                                    "%" + filtersDTO.getName().toLowerCase() + "%"
                            )
                    );
                }

                if (filtersDTO.getIdGenero()!=null) {
                    predicates.add(criteriaBuilder.equal(root.get("generoId"),filtersDTO.getIdGenero()

                    ));
                }

                String orderByField="fechaCreacion";
                query.orderBy(
                        filtersDTO.isAsc()?
                                criteriaBuilder.asc(root.get(orderByField)):
                                criteriaBuilder.desc((root.get(orderByField)))
                );


                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };}}

