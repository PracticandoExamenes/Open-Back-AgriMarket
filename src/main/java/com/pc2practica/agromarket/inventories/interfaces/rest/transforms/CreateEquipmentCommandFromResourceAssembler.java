package com.pc2practica.agromarket.inventories.interfaces.rest.transforms;

import com.pc2practica.agromarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.pc2practica.agromarket.inventories.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {

    public static CreateEquipmentCommand toCommandFromResource(CreateEquipmentResource resource){
        return new CreateEquipmentCommand(
                resource.name(),
                resource.groupId(),
                resource.description(),
                resource.referenceImageUrl()
        );
    }
}
