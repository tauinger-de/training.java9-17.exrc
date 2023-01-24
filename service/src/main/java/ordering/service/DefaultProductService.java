package ordering.service;

import ordering.model.AlcoholicBeverage;
import ordering.model.Pasta;
import ordering.model.Pizza;
import ordering.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DefaultProductService implements ProductService {

    private Map<Integer, Product> productsById;
    private Map<String, Product> productsByName;

    public DefaultProductService() {
        registerProducts(List.of(
                new Pizza(32, "Pizza Salami"),
                new Pasta(102, "Pasta Milano Speciale Plus"),
                new AlcoholicBeverage(512, "Großes Pils")
        ));
    }

    private void registerProducts(Collection<Product> products) {
        productsById = products
                .stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));
        productsByName = products
                .stream()
                .collect(Collectors.toMap(Product::getName, Function.identity()));
    }

    public Product getProductById(Integer id) {
        return productsById.get(id);
    }

    public Product getProductByName(String name) {
        return productsByName.get(name);
    }
}
