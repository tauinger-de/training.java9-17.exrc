package ordering.appl;

import ordering.model.Product;
import ordering.service.OrderService;

public class Application {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // example for just one product -- but we will have many orders
        Product product = orderService.placeOrder(32);
        orderService.reportOrderedProduct(product);
    }
}
