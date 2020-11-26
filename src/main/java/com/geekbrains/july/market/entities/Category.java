package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @ManyToMany
    @JoinTable(
            name = "categories_products",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public Category(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Category(Long id) {
        this.id = id;;
    }

}
