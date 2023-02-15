package ru.geekbrains.spring1.lesson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.spring1.lesson2");
        Cart cart = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter product id between 1 and 5");
        System.out.println("press 10 to get all products");
        System.out.println("press 0 to exit");


        while (true) {
            Long id = scanner.nextLong();
            if (id >= 1 && id <= 5) {
                cart.addProduct(id);
            } else if (id == 10) {
                System.out.println(cart.getAllProducts());
            } else if ((id < 1 || id > 5) && id != 10 && id != 0) {
                System.out.println("press product id between 1 and 5 to add product");
                System.out.println("press 10 to get all products");
                System.out.println("press 0 to exit");
            }else if (id == 0){
                break;
            }
        }

    }
}
