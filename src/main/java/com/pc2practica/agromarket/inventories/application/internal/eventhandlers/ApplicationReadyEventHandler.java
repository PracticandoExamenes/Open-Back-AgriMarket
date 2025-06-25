package com.pc2practica.agromarket.inventories.application.internal.eventhandlers;

import com.pc2practica.agromarket.inventories.domain.model.commands.SeedCategoryCommand;
import com.pc2practica.agromarket.inventories.domain.services.CategoryCommandService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ApplicationReadyEventHandler {
    private final CategoryCommandService categoryCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(CategoryCommandService categoryCommandService) {
        this.categoryCommandService = categoryCommandService;
    }

    @EventListener
    public void on (ApplicationReadyEvent event){
        var applicationName = event.getApplicationContext().getApplicationName();
        LOGGER.info("Application {} is ready, starting to verify if categories seeding is needed.", applicationName);
        var seedCommand = new SeedCategoryCommand();
        categoryCommandService.handle(seedCommand);
        LOGGER.info("Categories seeding is done.");
    }
}
