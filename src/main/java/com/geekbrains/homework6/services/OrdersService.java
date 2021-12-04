package com.geekbrains.homework6.services;

import com.geekbrains.homework6.data.Customer;
import com.geekbrains.homework6.data.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    List<Product> getProductsByCustomerId(Long customerId);
    List<Customer> getCustomersByProductId(Long productId);
}
