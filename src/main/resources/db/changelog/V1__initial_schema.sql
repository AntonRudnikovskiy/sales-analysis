CREATE TABLE customers
(
    id           BIGSERIAL PRIMARY KEY,
    address      TEXT,
    network_name VARCHAR(255)
);

CREATE TABLE products
(
    id           BIGSERIAL PRIMARY KEY,
    product_code VARCHAR(50) UNIQUE,
    name         VARCHAR(255),
    category     VARCHAR(255),
    brand        VARCHAR(255)
);

CREATE TABLE price
(
    id            BIGSERIAL PRIMARY KEY,
    network_name  VARCHAR(255),
    product_id    BIGINT REFERENCES products (id),
    regular_price DECIMAL(10, 2)
);

CREATE TABLE actuals
(
    id             BIGSERIAL PRIMARY KEY,
    customer_id    BIGINT REFERENCES customers (id),
    product_id     BIGINT REFERENCES products (id),
    promo_flag VARCHAR(10),
    delivery_date  DATE,
    shipment_price DECIMAL(10, 2)
);