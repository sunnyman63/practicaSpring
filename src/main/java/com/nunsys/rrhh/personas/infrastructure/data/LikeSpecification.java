package com.nunsys.rrhh.personas.infrastructure.data;

import com.nunsys.rrhh.personas.domain.Persona;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

public class LikeSpecification<T>  implements Specification<T> {
    private String name;
    private String value;

    public LikeSpecification(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.lower(root.get(this.name)),"%" + value.toLowerCase() + "%");
    }
}
