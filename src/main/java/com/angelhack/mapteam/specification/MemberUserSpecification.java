package com.angelhack.mapteam.specification;

import com.angelhack.mapteam.model.MemberUser;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MemberUserSpecification implements Specification<MemberUser> {

    private final MemberUser criteria;

    public MemberUserSpecification(MemberUser criteria) {
        this.criteria=criteria;
    }

    public Predicate toPredicate(Root<MemberUser> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        // create query/predicate here.
        return null;
    }
}