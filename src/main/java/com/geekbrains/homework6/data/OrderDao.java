package com.geekbrains.homework6.data;

import org.springframework.stereotype.Component;

@Component
public interface OrderDao {
    void createOrder(Customer customer, Product product);
}
