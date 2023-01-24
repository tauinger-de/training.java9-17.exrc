package ordering.service;

import ordering.model.Product;

public class OrderService {

    private final ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Product placeOrder(Object idOrNameOrProduct) {
        Product prd = switch (idOrNameOrProduct) {
            case Integer i -> productService.getProductById(i);
            case String s -> productService.getProductByName(s);
            case Product p -> p;
            default -> throw new IllegalArgumentException("Unsupported identifier!");
        };
        if (prd == null) {
            throw new IllegalArgumentException("No product found for identifier " + idOrNameOrProduct);
        }
        return prd;
    }

    public void reportOrderedProduct(Product product) {
        var report = """
                Dear Sir Or Madam,
                
                you ordered a %s with id %d named %s.
                                
                Please enjoy.
                                
                ------------------------------------------
                """.formatted(
                product.getClass().getSimpleName(),
                product.getId(),
                product.getName());
        System.out.println(report);
    }

}
