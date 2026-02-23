package com.juliabifano.inventory.service;

import com.juliabifano.inventory.domain.Product;
import com.juliabifano.inventory.domain.ProductMaterial;
import com.juliabifano.inventory.resource.dto.ProductionSuggestion;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class ProductionService {

    public List<ProductionSuggestion> calculate() {

        List<Product> products = Product.listAll();
        List<ProductionSuggestion> suggestions = new ArrayList<>();

        for (Product product : products) {

            List<ProductMaterial> materials =
                    ProductMaterial.list("product", product);

            long possible = Long.MAX_VALUE;

            for (ProductMaterial pm : materials) {

                long canProduce =
                        (long)(pm.rawMaterial.stockQuantity / pm.quantityNeeded);

                if (canProduce < possible) {
                    possible = canProduce;
                }
            }

            if (possible > 0 && possible != Long.MAX_VALUE) {

                ProductionSuggestion s = new ProductionSuggestion();
                s.productName = product.name;
                s.productValue = product.price;
                s.quantityPossible = possible;
                s.totalValue = possible * product.price;

                suggestions.add(s);
            }
        }

        suggestions.sort(Comparator.comparing(
                (ProductionSuggestion s) -> s.productValue).reversed());

        return suggestions;
    }
}