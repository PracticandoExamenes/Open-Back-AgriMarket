package com.pc2practica.agromarket.inventories.interfaces.rest;

import com.pc2practica.agromarket.inventories.domain.services.EquipmentCommandService;
import com.pc2practica.agromarket.inventories.interfaces.rest.resources.CreateEquipmentResource;
import com.pc2practica.agromarket.inventories.interfaces.rest.resources.EquipmentResource;
import com.pc2practica.agromarket.inventories.interfaces.rest.transforms.CreateEquipmentCommandFromResourceAssembler;
import com.pc2practica.agromarket.inventories.interfaces.rest.transforms.EquipmentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "api/v1/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Equipment", description = "Operations related to equipment management")
public class EquipmentController {

    private final EquipmentCommandService equipmentCommandService;

    public EquipmentController(EquipmentCommandService equipmentCommandService) {
        this.equipmentCommandService = equipmentCommandService;
    }

    @Operation(summary = "Create Equipment", description = "Creates a new equipment entry in the system")
    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource){
        try{
            var createEquipmentCommand = CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource);
            var equipmentEntity = equipmentCommandService.handle(createEquipmentCommand);
            if(equipmentEntity.isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            var equipmentResource = EquipmentResourceFromEntityAssembler.toResourceFromEntity(equipmentEntity.get());
            return new ResponseEntity<>(equipmentResource, HttpStatus.CREATED);
        } catch (IllegalArgumentException e){ //404
            return ResponseEntity.badRequest().build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
