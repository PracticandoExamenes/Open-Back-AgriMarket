package com.pc2practica.agromarket.inventories.infrastructure.persistence.jpa.repositories;

import com.pc2practica.agromarket.inventories.domain.model.entities.Category;
import com.pc2practica.agromarket.inventories.domain.model.valueobjects.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(CategoryType name);
}
