package ordering.appl;

import ordering.model.Product;
import ordering.service.DefaultProductService;
import ordering.service.OrderService;
import ordering.service.ProductService;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ProductService productService = new DefaultProductService();
        OrderService orderService = new OrderService(productService);

        List.of(32, "Großes Pils")
                .forEach(identifier -> {
                            Product product = orderService.placeOrder(identifier);
                            orderService.reportOrderedProduct(product);
                        }
                );
    }
}
