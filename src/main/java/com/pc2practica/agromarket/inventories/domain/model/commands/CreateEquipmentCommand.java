package com.pc2practica.agromarket.inventories.domain.model.commands;

public record CreateEquipmentCommand(String name, Long groupId, String description, String referenceImageUrl) {
    public CreateEquipmentCommand {
        if (name == null || name.isBlank() || name.length() > 80) {
            throw new IllegalArgumentException("Name must not be blank and must be at most 80 characters long.");
        }
        if (groupId == null || groupId <= 0) {
            throw new IllegalArgumentException("Group ID is required and must be a positive number.");
        }
        if (description == null || description.isBlank() || description.length() > 350) {
            throw new IllegalArgumentException("Description must not be blank and must be at most 350 characters long.");
        }
        if (referenceImageUrl == null || referenceImageUrl.isBlank()) {
            throw new IllegalArgumentException("Reference image URL must not be blank.");
        }
    }
}
