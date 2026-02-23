package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue
    public Long id;

    @NotBlank(message = "Name is required")
    public String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    public Double price;
}