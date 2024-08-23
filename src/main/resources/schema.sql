DROP TABLE IF EXISTS inventories;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR NOT NULL DEFAULT 'USER'
);


CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE items (
    item_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    price DECIMAL(10, 2),
    category_id INTEGER REFERENCES categories(category_id)
);


CREATE TABLE locations (
    location_id SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL
);


CREATE TABLE inventories (
    item_id INTEGER REFERENCES items(item_id) ON DELETE CASCADE,
    location_id INTEGER REFERENCES locations(location_id) ON DELETE CASCADE,
    quantity INTEGER NOT NULL CHECK (quantity >= 0),
    PRIMARY KEY (item_id, location_id)
);