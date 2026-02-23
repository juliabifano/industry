package com.juliabifano.inventory.resource;

import com.juliabifano.inventory.domain.ProductMaterial;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/product-materials")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductMaterialResource {

    @GET
    public List<ProductMaterial> list() {
        return ProductMaterial.listAll();
    }

    @POST
    @Transactional
    public ProductMaterial create(ProductMaterial pm) {
        pm.persist();
        return pm;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        ProductMaterial.deleteById(id);
    }
}