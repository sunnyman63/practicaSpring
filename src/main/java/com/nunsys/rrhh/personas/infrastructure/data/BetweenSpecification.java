package com.nunsys.rrhh.personas.infrastructure.data;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BetweenSpecification<T> implements Specification<T> {
    private final String name;
    private final Integer min;
    private final Integer max;

    public BetweenSpecification(String name, Integer min, Integer max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate greaterThanOrEqualTo = criteriaBuilder.greaterThanOrEqualTo(root.get(name),min.toString());
        Predicate lessThanOrEqualTo = criteriaBuilder.lessThanOrEqualTo(root.get(name),max.toString());
        return criteriaBuilder.and(greaterThanOrEqualTo,lessThanOrEqualTo);
    }
}
