INSERT INTO authorities (id, authority)
VALUES
    ('1', 'ROLE_ADMIN'),
    ('2', 'ROLE_USER'),
    ('3', 'ROLE_DEVELOPER');

INSERT INTO carts (id, price)
VALUES
    ('1', '0.00'),
    ('2', '25.00'),
    ('3', '50.00');

INSERT INTO developers (id, name, creation_date)
VALUES
    ('1', 'CD Project Red', '2002-05-01'),
    ('2', 'Rockstar Games', '1998-12-01'),
    ('3', 'Ubisoft', '1986-03-28');

INSERT INTO games (id, name, overall_rating, price, sales, developer_id)
VALUES
    ('1', 'Cyberpunk 2077', '4.5', '59.99', '1000000', '1'),
    ('2', 'Grand Theft Auto V', '4.8', '29.99', '150000000', '2'),
    ('3', 'Assassins Creed Valhalla', '4.3', '49.99', '5000000', '3');

INSERT INTO orders (id, price, user_id, promocode_id)
VALUES
    ('1', '59.99', '1', NULL),
    ('2', '29.99', '2', '1'),
    ('3', '49.99', '3', NULL);

INSERT INTO promocodes (id, type, code, discount, quantity)
VALUES
    ('1', 'DISCOUNT', 'SUMMER25', '25', '1000'),
    ('2', 'GIFT_CARD', 'BIRTHDAY2024', '5', '500');

INSERT INTO reviews (id, comment, stars, game_id, user_id)
VALUES
    ('1', 'Great game!', 'S5', '1', '1'),
    ('2', 'S5', '2', '2'),
    ('3', 'Enjoyed it!', 'S4', '3', '3');

INSERT INTO roles (id, name)
VALUES
    ('1', 'ADMIN'),
    ('2', 'USER'),
    ('3', 'DEVELOPER');

INSERT INTO user_info (id, email, password)
VALUES
    ('1', 'admin@example.com', 'admin123'),
    ('2', 'user@example.com', 'user123'),
    ('3', 'developer@example.com', 'developer123');