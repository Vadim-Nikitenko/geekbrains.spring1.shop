package com.geekbrains.july.market.repositories.specifications;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class ProductSpecifications {

    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> searchLike(String search) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + search.toLowerCase() + "%");
    }

    public static Specification<Product> categoryEqual(int categoryId) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> {
            Join<Category, Product> join = root.join("products", JoinType.INNER);
            return criteriaBuilder.equal(join.get("id"), categoryId);
        };
    }
}
