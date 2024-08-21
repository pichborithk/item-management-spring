INSERT INTO users (username, password)
    VALUES ('nick', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2'),
           ('will', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2'),
           ('david', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2');


INSERT INTO users (username, password, role)
    VALUES ('bo', '$2a$10$PohqQMKNuWD1/WBAX36IZODzC8ao4B42ee8fyLJNTrJAU6.6vwMo2', 'ADMIN');


INSERT INTO categories (name)
    VALUES ('Fresh Produce'), ('Dairy'), ('Bakery'), ('Frozen Foods'), ('Snacks'), ('Beverages'),
           ('Canned Goods'), ('Condiments'), ('Household'), ('Personal Care');


INSERT INTO items (name, price, category_id)
    VALUES ('Apples', 1.50, 1), ('Milk', 0.99, 2), ('Bread', 2.49, 3), ('Cheese', 4.99, 2),
           ('Frozen Pizza', 5.99, 4), ('Chips', 1.89, 5), ('Orange Juice', 2.49, 6), ('Canned Beans', 1.29, 7),
           ('Ketchup', 2.79, 8), ('Paper Towels', 3.49, 9), ('Shampoo', 4.49, 10), ('Bananas', 1.20, 1),
           ('Yogurt', 1.49, 2), ('Croissants', 3.99, 3), ('Chicken Nuggets', 6.49, 4), ('Granola Bars', 3.29, 5),
           ('Bottled Water', 4.99, 6), ('Tuna Fish', 1.79, 7), ('Mustard', 1.99, 8), ('Toilet Paper', 5.99, 9),
           ('Body Wash', 5.49, 10);


INSERT INTO locations (type)
    VALUES ('Store'), ('Warehouse'), ('Store'), ('Store'), ('Warehouse'), ('Warehouse'),
           ('Warehouse'), ('Warehouse'), ('Store'), ('Store');


INSERT INTO inventories (item_id, location_id, quantity) VALUES
-- Apples
(1, 1, 50), -- 50 apples on display
(1, 2, 200), -- 200 apples in warehouse
(1, 3, 30), -- 30 apples in backroom
-- Milk
(2, 1, 30), -- 30 bottles of milk on display
(2, 2, 100), -- 100 bottles of milk in warehouse
(2, 4, 20), -- 20 bottles of milk in refrigerated
-- Bread
(3, 1, 20), -- 20 loaves of bread on display
(3, 2, 80), -- 80 loaves of bread in warehouse
(3, 4, 10), -- 10 loaves of bread in refrigerated
-- Cheese
(4, 1, 10), -- 10 packs of cheese on display
(4, 2, 40), -- 40 packs of cheese in warehouse
(4, 4, 15), -- 15 packs of cheese in refrigerated
-- Frozen Pizza
(5, 4, 50), -- 50 frozen pizzas in frozen storage
(5, 6, 25), -- 25 frozen pizzas in stockroom
-- Chips
(6, 1, 40), -- 40 bags of chips on display
(6, 2, 120), -- 120 bags of chips in warehouse
(6, 7, 15), -- 15 bags of chips on promo shelf
-- Orange Juice
(7, 1, 15), -- 15 bottles of orange juice on display
(7, 2, 60), -- 60 bottles of orange juice in warehouse
(7, 4, 25), -- 25 bottles of orange juice in refrigerated
-- Canned Beans
(8, 1, 25), -- 25 cans of beans on display
(8, 2, 100), -- 100 cans of beans in warehouse
(8, 7, 10), -- 10 cans of beans on promo shelf
-- Ketchup
(9, 1, 20), -- 20 bottles of ketchup on display
(9, 2, 80), -- 80 bottles of ketchup in warehouse
(9, 7, 5), -- 5 bottles of ketchup on promo shelf
-- Paper Towels
(10, 1, 15), -- 15 packs of paper towels on display
(10, 2, 50), -- 50 packs of paper towels in warehouse
(10, 8, 10), -- 10 packs of paper towels in overflow
-- Shampoo
(11, 1, 25), -- 25 bottles of shampoo on display
(11, 2, 75), -- 75 bottles of shampoo in warehouse
(11, 9, 10), -- 10 bottles of shampoo in manager’s office
-- Bananas
(12, 1, 60), -- 60 bananas on display
(12, 2, 150), -- 150 bananas in warehouse
(12, 3, 40), -- 40 bananas in backroom
-- Yogurt
(13, 1, 20), -- 20 yogurts on display
(13, 2, 80), -- 80 yogurts in warehouse
(13, 4, 15), -- 15 yogurts in refrigerated
-- Croissants
(14, 1, 15), -- 15 croissants on display
(14, 2, 50), -- 50 croissants in warehouse
(14, 4, 10), -- 10 croissants in refrigerated
-- Chicken Nuggets
(15, 4, 40), -- 40 packs of nuggets in frozen storage
(15, 6, 20), -- 20 packs of nuggets in stockroom
-- Granola Bars
(16, 1, 30), -- 30 granola bars on display
(16, 2, 100), -- 100 granola bars in warehouse
(16, 7, 20), -- 20 granola bars on promo shelf
-- Bottled Water
(17, 1, 40), -- 40 bottles of water on display
(17, 2, 150), -- 150 bottles of water in warehouse
(17, 7, 30), -- 30 bottles of water on promo shelf
-- Tuna Fish
(18, 1, 20), -- 20 cans of tuna on display
(18, 2, 70), -- 70 cans of tuna in warehouse
(18, 8, 15), -- 15 cans of tuna in overflow
-- Mustard
(19, 1, 15), -- 15 bottles of mustard on display
(19, 2, 50), -- 50 bottles of mustard in warehouse
(19, 7, 10), -- 10 bottles of mustard on promo shelf
-- Toilet Paper
(20, 1, 10), -- 10 packs of toilet paper on display
(20, 2, 60), -- 60 packs of toilet paper in warehouse
(20, 8, 20), -- 20 packs of toilet paper in overflow
-- Body Wash
(21, 1, 15), -- 15 bottles of body wash on display
(21, 2, 50), -- 50 bottles of body wash in warehouse
(21, 9, 5); -- 5 bottles of body wash in manager’s office