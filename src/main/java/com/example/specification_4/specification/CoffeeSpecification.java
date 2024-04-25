package com.example.specification_4.specification;

import java.util.Collection;

import com.example.specification_4.entity.Coffee;
import org.springframework.data.jpa.domain.Specification;


public final class CoffeeSpecification {
    // Lấy ra coffee có CoffeeType chỉ định
    public static Specification<Coffee> hasType(Coffee.CoffeeType type) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    // Lấy ra coffee có ID chỉ định
    public static Specification<Coffee> hasId(long id) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    // Lấy ra coffee nằm trong tập ID chỉ định
    public static Specification<Coffee> hasIdIn(Collection<Long> ids) {
        return (root, criteriaQuery, criteriaBuilder) -> root.get("id").in(ids);
    }
}
