package com.pc2practica.agromarket.inventories.domain.model.entities;

import com.pc2practica.agromarket.inventories.domain.model.valueobjects.CategoryType;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Category {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryType name;

    public Category() {
        // Default constructor for JPA
    }

    public Category(CategoryType name) {
        this.name = name;
    }
}
