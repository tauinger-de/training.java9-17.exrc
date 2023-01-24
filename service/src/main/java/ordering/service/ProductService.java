package ordering.service;

import ordering.model.Product;

public interface ProductService {

    Product getProductById(String id);

    Product getProductByName(String name);

    Iterable<Product> getAllProducts();

}
