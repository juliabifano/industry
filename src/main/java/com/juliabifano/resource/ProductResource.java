package com.juliabifano.inventory.resource;

import com.juliabifano.inventory.domain.Product;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> list() {
        return Product.listAll();
    }

    @POST
    @Transactional
    public Product create(@Valid Product product) {
        product.persist();
        return product;
    }

    @GET
    @Path("/{id}")
    public Product get(@PathParam("id") Long id) {
        return Product.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Product update(@PathParam("id") Long id, Product data) {
        Product product = Product.findById(id);

        product.name = data.name;
        product.price = data.price;
        product.quantity = data.quantity;

        return product;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Product.deleteById(id);
    }
}