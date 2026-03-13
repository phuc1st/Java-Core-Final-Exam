package pattern.prototype_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop"));
        products.add(new Product("Phone"));

        Order oldOrder = new Order(products);
        Order newOrder = (Order) oldOrder.clone(); // Prototype

        // Kiểm tra
        System.out.println("Old order size: " + oldOrder.getProducts().size());
        System.out.println("New order size: " + newOrder.getProducts().size());

        // Xóa sản phẩm khỏi newOrder
        newOrder.getProducts().remove(0);

        System.out.println("Old order size after remove: " + oldOrder.getProducts().size());
        System.out.println("New order size after remove: " + newOrder.getProducts().size());

    }
}
