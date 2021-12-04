DROP TABLE products IF EXISTS cascade ;
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, title VARCHAR(255), PRIMARY KEY (id));
--INSERT INTO products (title, price) VALUES ('Item 1', 80), ('Item 2', 80), ('Item 3', 80);

DROP TABLE customers IF EXISTS cascade;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
--INSERT INTO customers (name) VALUES ('Customer 1');

DROP TABLE orders IF EXISTS;
CREATE TABLE IF NOT EXISTS orders (id bigserial, customer_id bigserial, product_id bigserial, price real);
--INSERT INTO orders (customer_id, product_id, price) VALUES (1, 1, 10.92), (1, 2, 10.93), (1, 3, 10.94);