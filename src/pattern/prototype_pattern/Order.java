package pattern.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = (Order) super.clone();
            List<Product> clonedProducts = new ArrayList<>();
            products.forEach(product -> clonedProducts.add((Product) product.clone()));
            ((Order) clone).products = clonedProducts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }
}

