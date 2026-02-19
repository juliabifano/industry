package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

public class ProductMaterial extends PanacheEntity {

    @ManyToOne
    public Product product;

    @ManyToOne
    public RawMaterial rawMaterial;

    public BigDecimal requiredQuantity;
}