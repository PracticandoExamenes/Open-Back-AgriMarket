package com.pc2practica.agromarket.inventories.domain.services;

import com.pc2practica.agromarket.inventories.domain.model.commands.SeedCategoryCommand;

public interface CategoryCommandService {
    void handle (SeedCategoryCommand command);
}
