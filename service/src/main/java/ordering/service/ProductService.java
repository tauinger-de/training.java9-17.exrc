package ordering.service;

import ordering.model.Product;

public interface ProductService {

    Product getProductById(Integer id);

    Product getProductByName(String name);

}
