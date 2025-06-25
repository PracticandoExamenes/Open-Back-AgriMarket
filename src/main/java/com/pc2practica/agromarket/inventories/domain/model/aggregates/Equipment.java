package com.pc2practica.agromarket.inventories.domain.model.aggregates;

import com.pc2practica.agromarket.inventories.domain.model.commands.CreateEquipmentCommand;
import com.pc2practica.agromarket.inventories.domain.model.entities.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Equipment extends AbstractAggregateRoot<Equipment> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    //@NotBlank
    @Size(max = 80)
    @Column(length = 80, nullable = false)
    private String name;

    @Getter
    @ManyToOne
    //@NotBlank
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;

    @Getter
    //@NotBlank
    @Column(nullable = false)
    private Long groupId;

    @Getter
    //@NotBlank
    @Size(max = 350)
    @Column(length = 350, nullable = false)
    private String description;

    @Getter
    //@NotBlank
    @Column(nullable = false)
    private String referenceImageUrl;


    public Equipment(String name, Category category, Long groupId, String description, String referenceImageUrl) {
        this.name = name;
        this.category = category;
        this.groupId = groupId;
        this.description = description;
        this.referenceImageUrl = referenceImageUrl;
    }

    public Equipment(CreateEquipmentCommand command) {
        this.name = command.name();
        this.groupId = command.groupId();
        this.description = command.description();
        this.referenceImageUrl = command.referenceImageUrl();
    }

    public Equipment() {
        // Default constructor for JPA
    }
}
