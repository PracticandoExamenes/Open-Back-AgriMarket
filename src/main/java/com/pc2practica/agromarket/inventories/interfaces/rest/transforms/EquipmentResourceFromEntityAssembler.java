package com.pc2practica.agromarket.inventories.interfaces.rest.transforms;

import com.pc2practica.agromarket.inventories.domain.model.aggregates.Equipment;
import com.pc2practica.agromarket.inventories.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {

    public static EquipmentResource toResourceFromEntity(Equipment entity){
        return new EquipmentResource(
                entity.getId(),
                entity.getName(),
                entity.getGroupId(),
                entity.getDescription(),
                entity.getReferenceImageUrl()
        );
    }
}
