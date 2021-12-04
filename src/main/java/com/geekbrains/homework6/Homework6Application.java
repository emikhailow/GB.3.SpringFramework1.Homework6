package com.geekbrains.homework6;

import com.geekbrains.homework6.data.*;
import com.geekbrains.homework6.services.OrdersService;
import com.geekbrains.homework6.services.OrdersServiceViaDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Random;

public class Homework6Application {

    public static final int ITEMS_COUNT = 3;
    public static final int CUSTOMERS_COUNT = 3;
    public static final Random random  = new Random();

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains.homework6");

        ProductDao productDao   = context.getBean(ProductDao.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        OrderDao orderDao       = context.getBean(OrderDao.class);

        OrdersService ordersService = new OrdersServiceViaDao(customerDao, productDao, orderDao);

        for (int i = 0; i < ITEMS_COUNT; i++) {
            productDao.addItem(String.format("Item %d", i + 1));
        }

        for (int i = 0; i < CUSTOMERS_COUNT; i++) {
            customerDao.add(String.format("Customer %d", i + 1));
        }

        for (int i = 0; i < CUSTOMERS_COUNT; i++) {
            Customer customer = customerDao.getByID((long) i + 1);

            for (int j = 0; j < ITEMS_COUNT; j++) {
                //if(random.nextBoolean()){
                //    Product product = productDao.getByID((long) j + 1);
                //    orderDao.createOrder(customer, product);
                //    orderDao.createOrder(customer, product);
                //}
            }

        }

        for (int i = 0; i < CUSTOMERS_COUNT; i++) {
            Customer customer = customerDao.getByID((long) i + 1);
            System.out.println(customerDao.getOrders(customer.getId()));
            System.out.println(ordersService.getProductsByCustomerId(customer.getId()));
        }

        for (int i = 0; i < ITEMS_COUNT; i++) {
            Product product = productDao.getByID((long) i + 1);
            System.out.println(productDao.getOrders(product.getId()));
            System.out.println(ordersService.getCustomersByProductId(product.getId()));
        }

    }

}
