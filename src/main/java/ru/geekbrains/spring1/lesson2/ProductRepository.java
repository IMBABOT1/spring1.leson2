package ru.geekbrains.spring1.lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Bread", 10),
                new Product(2l, "Milk", 10),
                new Product(3l, "Apples", 10),
                new Product(4l, "Cheese", 10),
                new Product(5l, "Oranges", 10)

        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
