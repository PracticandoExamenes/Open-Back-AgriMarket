package com.pc2practica.agromarket.inventories.application.internal.commandservices;

import com.pc2practica.agromarket.inventories.domain.model.aggregates.Equipment;
import com.pc2practica.agromarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.pc2practica.agromarket.inventories.domain.services.EquipmentCommandService;
import com.pc2practica.agromarket.inventories.infrastructure.persistence.jpa.repositories.CategoryRepository;
import com.pc2practica.agromarket.inventories.infrastructure.persistence.jpa.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCommandServiceImpl implements EquipmentCommandService {

    private final EquipmentRepository equipmentRepository;
    private final CategoryRepository categoryRepository;

    public EquipmentCommandServiceImpl(EquipmentRepository equipmentRepository, CategoryRepository categoryRepository) {
        this.equipmentRepository = equipmentRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Equipment> handle(CreateEquipmentCommand command) {
        if(equipmentRepository.existsByName(command.name())){
            throw new IllegalArgumentException("Equipment with name " + command.name() + " already exists.");
        }
        if(!categoryRepository.existsById(command.groupId())) {
            throw new IllegalArgumentException("Category with ID " + command.groupId() + " does not exist.");
        }
        var equipment = new Equipment(command);
        return Optional.of(equipmentRepository.save(equipment));
    }
}
