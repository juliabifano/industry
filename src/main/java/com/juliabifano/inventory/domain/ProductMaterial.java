package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductMaterial extends PanacheEntity {

    @ManyToOne
    @NotNull
    public Product product;

    @ManyToOne
    @NotNull
    public RawMaterial rawMaterial;

    @NotNull
    public Double quantityRequired;
}