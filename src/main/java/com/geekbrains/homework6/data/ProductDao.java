package com.geekbrains.homework6.data;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {
    Product getByID(Long id);
    List<Product> getProductsList();
    void removeItem(Long id);
    void addItem(String title);
    List<Customer> getCustomers(Long productId);
}
