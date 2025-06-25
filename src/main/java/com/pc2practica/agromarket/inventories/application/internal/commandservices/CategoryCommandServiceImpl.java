package com.pc2practica.agromarket.inventories.application.internal.commandservices;

import com.pc2practica.agromarket.inventories.domain.model.commands.SeedCategoryCommand;
import com.pc2practica.agromarket.inventories.domain.model.entities.Category;
import com.pc2practica.agromarket.inventories.domain.model.valueobjects.CategoryType;
import com.pc2practica.agromarket.inventories.domain.services.CategoryCommandService;
import com.pc2practica.agromarket.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    private final CategoryRepository categoryRepository;

    public CategoryCommandServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void handle(SeedCategoryCommand command) {
        Arrays.stream(CategoryType.values()).forEach(name->{
            if(!categoryRepository.existsByName(name)) {
                categoryRepository.save(new Category(name));
            }
        });
    }
}
