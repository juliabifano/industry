package com.juliabifano.inventory.resource;

import com.juliabifano.inventory.resource.dto.ProductionSuggestion;
import com.juliabifano.inventory.service.ProductionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/production")
public class ProductionResource {

    @Inject
    ProductionService service;

    @GET
    @Path("/suggestion")
    public List<ProductionSuggestion> suggest() {
        return service.calculate();
    }
}