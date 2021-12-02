package com.geekbrains.homework6.data;

import org.hibernate.loader.custom.CustomQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
    Customer getByID(Long id);
    List<Customer> getCustomerList();
    void remove(Long id);
    void add(String title);
    List<Product> getProducts(Long customerId);

}
