drop table if exists products cascade;
create table products (id bigserial PRIMARY KEY, title varchar(255), description varchar(5000), price int);
insert into products
(title, description, price) values
('Cheese', 'Fresh cheese', 320),
('Milk', 'Fresh milk', 80),
('Apples', 'Fresh apples', 80),
('Bread', 'Fresh bread', 30),
('A1', '', 1),
('A2', '', 2),
('A3', '', 3),
('A4', '', 4),
('A5', '', 5),
('A6', '', 6),
('A7', '', 7),
('A8', '', 8),
('A9', '', 9),
('A10', '', 10),
('A11', '', 11),
('A12', '', 12),
('A13', '', 13),
('A14', '', 14),
('A15', '', 15),
('A16', '', 16),
('A17', '', 17),
('A18', '', 18),
('A19', '', 19),
('A20', '', 20);

drop table if exists categories cascade;
create table categories (id bigserial PRIMARY KEY, name_category varchar(255));
insert into categories
(name_category) values
('Phones'),
('Meal'),
('Fruits'),
('Vegetables'),
('Other');

DROP TABLE IF EXISTS categories_products CASCADE;
CREATE TABLE categories_products (id bigserial PRIMARY KEY, category_id bigint, product_id bigint, FOREIGN KEY (category_id) REFERENCES categories (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO categories_products (category_id, product_id) VALUES
(1, 1),
(1, 24),
(1, 23),
(1, 22),
(1, 21),
(1, 20),
(1, 19),
(1, 18),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(1, 16),
(2, 17),
(3, 18),
(4, 19),
(5, 20),
(1, 21),
(2, 22),
(3, 23),
(4, 24);