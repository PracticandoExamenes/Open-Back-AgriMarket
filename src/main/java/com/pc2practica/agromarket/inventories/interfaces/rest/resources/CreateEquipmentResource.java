package com.pc2practica.agromarket.inventories.interfaces.rest.resources;

public record CreateEquipmentResource(String name, Long groupId,
                                      String description, String referenceImageUrl) {
}
