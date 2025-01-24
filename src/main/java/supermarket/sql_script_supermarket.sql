-- INSERTS

INSERT INTO Products (name, description, price, quantity, category_id) VALUES ('Milk', 'Fresh Milk', 1.99, 50, 1);
INSERT INTO Products (name, description, price, quantity, category_id) VALUES ('Banana', 'Organic bananas', 0.80, 150, 1);
INSERT INTO Products (name, description, price, quantity, category_id) VALUES ('del1', 'test', 2.00, 150, 2);
INSERT INTO Products (name, description, price, quantity, category_id) VALUES ('del2', 'test', 2.00, 150, 2);
INSERT INTO Products (name, description, price, quantity, category_id) VALUES ('del3', 'test', 2.00, 150, 2);



INSERT INTO Product_categories (name, description) VALUES ('Fruits', 'testval');
INSERT INTO Product_categories  (name, description) VALUES ('Drinks', 'testval');
INSERT INTO Product_categories  (name, description) VALUES ('Dairy','Milk, cheese, and other dairy products.');
INSERT INTO Product_categories  (name, description) VALUES ('Meat', 'testval');
INSERT INTO Product_categories  (name, description) VALUES ('del8', 'testval');
INSERT INTO Product_categories  (name, description) VALUES ('del9', 'testval');
INSERT INTO Product_categories  (name, description) VALUES ('del10', 'testval');



INSERT INTO Store (address, postal_code) VALUES ('123 Main St', '12345');
INSERT INTO Store (address, postal_code) VALUES ('del7', '123');


INSERT INTO Roles (name, description) VALUES ('Manager', 'Manages the store and users.');
INSERT INTO Roles (name, description) VALUES ('Cashier', 'TEST');
INSERT INTO Roles (name, description) VALUES ('Security Guard', 'TEST');
INSERT INTO Roles (name, description) VALUES ('IT Support', 'Manages IT systems and troubleshooting.');
INSERT INTO Roles (name, description) VALUES ('del4', 'test.');
INSERT INTO Roles (name, description) VALUES ('del5', 'test.');
INSERT INTO Roles (name, description) VALUES ('del6', 'test.');



-- UPDATES

UPDATE Store SET postal_code = '123' where address = '123 Main St';
UPDATE Store SET address = 'Poland mountain' WHERE postal_code = '123';

UPDATE Roles SET description = 'Ensures store safety and monitors security.' where name = 'Security Guard';
UPDATE Roles SET description = 'Manages cash registers.' where name = 'Cashier';
UPDATE Roles SET description = 'Manages the entire store.' where name = 'Manager';

UPDATE Products SET description = 'Fresh organic milk' WHERE name = 'Milk';
UPDATE Products SET quantity = 100 WHERE name = 'Milk';
UPDATE Products SET quantity = 130 WHERE name = 'Banana';
UPDATE Products SET quantity = 120 WHERE name = 'Energy Drink';
UPDATE Products SET price = 5 WHERE name = 'Energy Drink';

-- DELETES

DELETE FROM Roles WHERE name = 'IT support';
DELETE FROM Products WHERE name = 'del1';
DELETE FROM Products WHERE name = 'del2';
DELETE FROM Products WHERE name = 'del3';
DELETE FROM Roles WHERE name = 'del4';
DELETE FROM Roles WHERE name = 'del5';
DELETE FROM Roles WHERE name = 'del6';
DELETE FROM Store where address = 'del7';
DELETE FROM Product_categories where name = 'del8';
DELETE FROM Product_categories where name = 'del9';
DELETE FROM Product_categories where name = 'del10';

-- ALTER


ALTER TABLE Product_categories ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Products ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Customers ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE Customers DROP COLUMN email;
ALTER TABLE Store MODIFY COLUMN postal_code VARCHAR(15);

-- JOINS


SELECT 
    Customers.customer_id,
    Customers.first_name AS customer_first_name,
    Customers.last_name AS customer_last_name,
    Customers.contact_number AS customer_contact_number,
    Store.store_id,
    Store.address AS store_address,
    Store.postal_code AS store_postal_code,
    Roles.role_id,
    Roles.name AS role_name,
    Roles.description AS role_description,
    Users.user_id,
    Users.username AS user_username,
    Users.email AS user_email,
    Products.product_id,
    Products.name AS product_name,
    Products.description AS product_description,
    Products.price AS product_price,
    Products.quantity AS product_quantity,
    Product_categories.category_id,
    Product_categories.name AS category_name,
    Product_categories.description AS category_description,
    Suppliers.supplier_id,
    Suppliers.name AS supplier_name,
    Suppliers.contact_number AS supplier_contact_number,
    Suppliers.email AS supplier_email,
    Product_supplier.quantity AS supplier_quantity,
    Payment_method.payment_id,
    Payment_method.name AS payment_method_name,
    Purchase.purchase_id,
    Purchase.created_at AS purchase_date,
    Purchase_item.quantity AS purchase_item_quantity,
    Purchase_item.price_at_purchase AS purchase_item_price,
    Checkout.checkout_id,
    Checkout.is_active AS checkout_active_status
FROM Customers
LEFT JOIN Purchase ON Customers.customer_id = Purchase.customer_id
LEFT JOIN Purchase_item ON Purchase.purchase_id = Purchase_item.purchase_id
LEFT JOIN Products ON Purchase_item.product_id = Products.product_id
LEFT JOIN Product_categories ON Products.category_id = Product_categories.category_id
LEFT JOIN Store ON Purchase.store_id = Store.store_id
LEFT JOIN Checkout ON Purchase.checkout_id = Checkout.checkout_id
LEFT JOIN Users ON Purchase.user_id = Users.user_id
LEFT JOIN Roles ON Users.role_id = Roles.role_id
LEFT JOIN Suppliers ON Suppliers.supplier_id = Products.product_id
LEFT JOIN Product_supplier ON Product_supplier.product_id = Products.product_id
LEFT JOIN Payment_method ON Purchase.payment_method_id = Payment_method.payment_id;


SELECT Products.name, Product_categories.name FROM Products INNER JOIN Product_categories ON Products.category_id = Product_categories.category_id;
SELECT Products.name, Product_categories.name FROM Products LEFT JOIN Product_categories ON Products.category_id = Product_categories.category_id;
SELECT Products.name, Product_categories.name FROM Products RIGHT JOIN Product_categories ON Products.category_id = Product_categories.category_id;

SELECT Customers.first_name, Purchase.purchase_id FROM Customers LEFT JOIN Purchase ON Customers.customer_id = Purchase.customer_id;
SELECT Purchase.purchase_id, Payment_method.name FROM Purchase LEFT JOIN Payment_method ON Purchase.payment_method_id = Payment_method.payment_id;





SELECT Store.store_id, Store.address, Users.username, Roles.name AS role_name FROM Store 
INNER JOIN Users ON Store.store_id = Users.store_id 
INNER JOIN Roles ON Users.role_id = Roles.role_id;


-- AGGREGATE FUNCTIONS

SELECT COUNT(*) AS total_products FROM Products;
SELECT AVG(price) AS average_price FROM Products;
SELECT MIN(price) AS lowest_price FROM Products;
SELECT MAX(price) AS highest_price FROM Products;
SELECT SUM(quantity) AS total_quantity FROM Products;
SELECT category_id, COUNT(*) AS product_count FROM Products GROUP BY category_id;
SELECT category_id, SUM(price * quantity) AS total_sales FROM Products GROUP BY category_id;

-- AGGREGATE FUNCTIONS WITH HAVING

SELECT category_id, COUNT(*) as product_num from Products GROUP BY category_id HAVING COUNT(*) > 0;
SELECT category_id, SUM(quantity) as product_num from Products GROUP BY category_id HAVING SUM(quantity) > 100;
SELECT category_id, AVG(price) AS average_price FROM Products GROUP BY category_id HAVING AVG(price) > 2.00;
SELECT category_id, MAX(price) AS max_price FROM Products GROUP BY category_id HAVING MAX(price) < 50.00;
SELECT category_id, MIN(price) AS min_price FROM Products GROUP BY category_id HAVING MIN(price) > 1.00;
SELECT category_id, AVG(price) AS avg_price FROM Products GROUP BY category_id HAVING AVG(price) BETWEEN 5 AND 15;
SELECT store_id, count(postal_code) AS max_num_store FROM Store GROUP BY postal_code HAVING count(postal_code) > 0;