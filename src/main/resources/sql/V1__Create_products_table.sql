DROP TABLE IF EXISTS products;

CREATE TABLE products (
    id        SERIAL PRIMARY KEY,
    name      varchar(20) NOT NULL,
    value     money NOT NULL,
    inventory integer NOT NULL
);

INSERT INTO products (name, value, inventory) VALUES (
    'Dr. Pepper', 1.00, 5
);
