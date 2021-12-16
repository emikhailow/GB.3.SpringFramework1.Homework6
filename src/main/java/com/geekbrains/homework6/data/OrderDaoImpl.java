package com.geekbrains.homework6.data;

import com.geekbrains.homework6.hibernate.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl implements OrderDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public OrderDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public void createOrder(Customer customer, Product product) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Order order = new Order(customer, product);
            session.save(order);
            session.getTransaction().commit();
        }
    }

}
