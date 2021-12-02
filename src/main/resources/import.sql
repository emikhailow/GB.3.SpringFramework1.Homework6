DROP TABLE products IF EXISTS cascade ;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Item 1', 80), ('Item 2', 80), ('Item 3', 80);

DROP TABLE customers IF EXISTS cascade;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Customer 1');

DROP TABLE customers_products IF EXISTS;
CREATE TABLE IF NOT EXISTS customers_products (customer_id bigserial, product_id bigserial, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 1), (1, 2), (1, 3);