package com.geekbrains.homework6.services;

import com.geekbrains.homework6.data.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceViaDao implements OrdersService{
    private CustomerDao customerDao;
    private ProductDao productDao;
    private OrderDao orderDao;

    public OrdersServiceViaDao(CustomerDao customerDao, ProductDao productDao, OrderDao orderDao) {
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    @Override
    public List<Product> getProductsByCustomerId(Long customerId) {
        return customerDao.getAllProducts(customerId);
    }

    @Override
    public List<Customer> getCustomersByProductId(Long productId) {
        return productDao.getAllCustomers(productId);
    }
}
