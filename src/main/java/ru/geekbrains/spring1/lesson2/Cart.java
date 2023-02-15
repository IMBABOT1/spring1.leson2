package ru.geekbrains.spring1.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;
    private List<Product> cart;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
       cart = new ArrayList<>();
    }

    public void addProduct(Long id){
        cart.add(productRepository.getProductById(id));
    }

    public List<Product> getAllProducts(){
        return cart;
    }

}
