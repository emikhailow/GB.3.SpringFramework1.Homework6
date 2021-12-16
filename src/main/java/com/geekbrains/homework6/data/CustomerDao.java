package com.geekbrains.homework6.data;

import org.hibernate.loader.custom.CustomQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
    Customer getByID(Long id);
    List<Customer> getCustomerList();
    List<Order> getOrders(Long customerId);
    void remove(Long id);
    void add(String title);
    List<Product> getAllProducts(Long customerId);

}
