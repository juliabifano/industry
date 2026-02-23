package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductMaterial extends PanacheEntity {

    @ManyToOne
    public Product product;

    @ManyToOne
    public RawMaterial rawMaterial;

    public Double quantityNeeded;
}