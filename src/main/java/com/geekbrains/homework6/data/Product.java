package com.geekbrains.homework6.data;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "productWithOrders", query = "SELECT p FROM Product p JOIN FETCH p.orders WHERE p.id = :id")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @Transient
    private final Random random = new Random();
    @Transient
    private static final int MIN_PRICE = 1;
    @Transient
    private static final int MAX_PRICE = 1000;

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
        generateRandomPrice();
    }

    public Product(String title) {
        this.title = title;
        generateRandomPrice();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Product(Long id) {
        this.id = id;
        this.title = String.format("Item %011d", id);
        generateRandomPrice();
    }

    private void generateRandomPrice() {
        this.price = Math.floor(100 * (MIN_PRICE + (MAX_PRICE - MIN_PRICE) * random.nextDouble())) / 100;
    }

    public Product() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
