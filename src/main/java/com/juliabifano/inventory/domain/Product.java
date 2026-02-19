package com.juliabifano.inventory.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

public class Product extends PanacheEntity {

    public String code;
    public String name;
    public BigDecimal price;

}