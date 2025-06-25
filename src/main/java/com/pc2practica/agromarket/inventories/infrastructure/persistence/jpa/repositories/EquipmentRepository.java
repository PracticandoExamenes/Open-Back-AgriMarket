package com.pc2practica.agromarket.inventories.infrastructure.persistence.jpa.repositories;

import com.pc2practica.agromarket.inventories.domain.model.aggregates.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    boolean existsByName(String name);
}
