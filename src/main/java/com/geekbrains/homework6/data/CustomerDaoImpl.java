package com.geekbrains.homework6.data;

import com.geekbrains.homework6.hibernate.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Customer getByID(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> getCustomerList() {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.createQuery("delete from Customer c where c.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void add(String name) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Customer customer = new Customer(name);
            session.save(customer);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Product> getAllProducts(Long customerId) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("select distinct p from Product p inner join p.orders po where po.customer.id = :id", Product.class)
                    .setParameter("id", customerId)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

   @Override
    public List<Order> getOrders(Long customerId) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Order> orders = session
                    .createNamedQuery("customerWithOrders", Customer.class)
                    .setParameter("id", customerId)
                    .getSingleResult()
                    .getOrders();
            session.getTransaction().commit();
            return  orders;
        }
    }







}
