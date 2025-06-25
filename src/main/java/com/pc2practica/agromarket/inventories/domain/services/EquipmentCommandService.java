package com.pc2practica.agromarket.inventories.domain.services;

import com.pc2practica.agromarket.inventories.domain.model.aggregates.Equipment;
import com.pc2practica.agromarket.inventories.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

public interface EquipmentCommandService {
    Optional<Equipment> handle (CreateEquipmentCommand command);
}
