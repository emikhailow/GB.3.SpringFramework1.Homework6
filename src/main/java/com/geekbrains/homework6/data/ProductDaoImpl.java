package com.geekbrains.homework6.data;

import com.geekbrains.homework6.hibernate.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements ProductDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product getByID(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> getProductsList() {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void removeItem(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.createQuery("delete from Product p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void addItem(String title) {

        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = new Product(title);
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Customer> getAllCustomers(Long productId) {

        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Customer> customers = session
                    .createQuery("select distinct o.customer from Order o where o.product.id = :id", Customer.class)
                    .setParameter("id", productId)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public List<Order> getOrders(Long productId) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();

            Optional<Product> product = session
                    .createNamedQuery("productWithOrders", Product.class)
                    .setParameter("id", productId)
                    .getResultList()
                    .stream()
                    .findFirst();
            List<Order> orders = product.isEmpty() ? Collections.emptyList() : product.get().getOrders();
            return orders;
        }
    }

}
