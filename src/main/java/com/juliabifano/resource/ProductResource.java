package com.juliabifano.inventory.resource;

import com.juliabifano.inventory.domain.Product;

import jakarta.ws.rs.core.Response;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;

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
        public Response create(Product product) {
    product.persist();
    return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @GET
    @Path("/{id}")
    public Product getById(Long id) {
    Product product = Product.findById(id);

    if (product == null) {
        throw new jakarta.ws.rs.NotFoundException("Product not found");
    }

    return product;
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
    public Response delete(Long id) {
    boolean deleted = Product.deleteById(id);

    if (!deleted) {
        throw new jakarta.ws.rs.NotFoundException("Product not found");
    }

    return Response.noContent().build();
    }

    @GET
    @Path("/search")
    public List<Product> searchByName(@QueryParam("name") String name) {
    return Product.list("name like ?1", "%" + name + "%");
    }
}