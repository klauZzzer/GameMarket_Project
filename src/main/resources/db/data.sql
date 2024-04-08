INSERT INTO authorities (id, authority)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'ROLE_ADMIN'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'ROLE_USER'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'ROLE_DEVELOPER');

INSERT INTO carts (id, price)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', '0.00'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '25.00'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '50.00');

INSERT INTO developers (id, name, creation_date)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'CD Project Red', '2002-05-01'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'Rockstar Games', '1998-12-01'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'Ubisoft', '1986-03-28');

INSERT INTO games (id, name, overall_rating, price, sales, developer_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'Cyberpunk 2077', '4.5', '59.99', '1000000', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'Grand Theft Auto V', '4.8', '29.99', '150000000', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'Assassins Creed Valhalla', '4.3', '49.99', '5000000', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO promocodes (id, type, code, discount, quantity)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'DISCOUNT', 'SUMMER25', '25', '1000'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'GIFT_CARD', 'BIRTHDAY2024', '5', '500');

INSERT INTO user_info (id, email, password)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'admin@example.com', 'admin123'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'user@example.com', 'user123'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'developer@example.com', 'developer123');

INSERT INTO users (id, nickname, balance, user_info_id, cart_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'user1', 100.00, 'fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'user2', 50.00, '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'user3', 75.00, '93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO orders (id, price, user_id, promocode_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', '59.99', 'fc698b8c-f835-4800-b633-2f7905bfa238', NULL),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '29.99', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '49.99', '93de1a91-9de3-4126-9981-eec527bb998b', NULL);

INSERT INTO reviews (id, comment, stars, game_id, user_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'Great game!', 'S5', 'fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'WOW, BEAUTIFUL','S5', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'Enjoyed it!', 'S4', '93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO roles (id, name)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'ADMIN'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'USER'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'DEVELOPER');

INSERT INTO carts_games (cart_id, game_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO games_genres (game_id, genre)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'Action'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', 'Open world'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', 'Adventure');

INSERT INTO orders_games (order_id, game_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO promocodes_orders (promocode_id, order_id)
VALUES (NULL, 'fc698b8c-f835-4800-b633-2f7905bfa238'),
       ('fc698b8c-f835-4800-b633-2f7905bfa238', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
       (NULL, '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO roles_authorities (role_id, authority_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO users_favorite_games (user_id, game_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

INSERT INTO users_reviews (user_id, review_id)
VALUES
    ('fc698b8c-f835-4800-b633-2f7905bfa238', 'fc698b8c-f835-4800-b633-2f7905bfa238'),
    ('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6', '5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'),
    ('93de1a91-9de3-4126-9981-eec527bb998b', '93de1a91-9de3-4126-9981-eec527bb998b');

