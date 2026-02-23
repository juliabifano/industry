package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
public class Product extends PanacheEntity {

    @NotBlank
    public String name;

    @Positive
    public double price;

    @PositiveOrZero
    public int quantity;

    public LocalDateTime createdAt;
}