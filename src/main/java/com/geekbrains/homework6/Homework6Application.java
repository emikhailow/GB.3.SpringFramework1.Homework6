package com.geekbrains.homework6;

import com.geekbrains.homework6.data.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Homework6Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.homework6");

        ProductDao productDao = context.getBean(ProductDao.class);
        productDao.addItem("some");

        CustomerDao customerDao = context.getBean(CustomerDao.class);

        System.out.println(customerDao.getProducts(1L));
        System.out.println(productDao.getCustomers(1L));

    }

}
