INSERT INTO authorities (id, authority)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'READ'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'UPDATE'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'CREATE'),
    (UUID_TO_BIN('0d6cdf0f-8334-4138-9ebb-e4d3e74815f2'), 'DELETE');
INSERT INTO carts (id, price)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), '0.00'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), '25.00'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), '50.00');
INSERT INTO developers (id, name, creation_date)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'CD Project Red', '2002-05-01'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'Rockstar Games', '1998-12-01'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'Ubisoft', '1986-03-28');

INSERT INTO games (id, name, overall_rating, price, sales, developer_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'Cyberpunk 2077', '4.5', '59.99', '1000000', UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'Grand Theft Auto V', '4.8', '29.99', '150000000', UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'Assassins Creed Valhalla', '4.3', '49.99', '5000000', UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO promocodes (id, type, code, discount, quantity)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'DISCOUNT', 'SUMMER25', '25', '1000'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'GIFT_CARD', 'BIRTHDAY2024', '5', '500');
INSERT INTO user_info (id, email, login, password)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'admin@example.com', 'adminLogin', '$2a$10$yHSiJaorTVnDtMa.OZbkquORqKOKNU8pAuKFggIb1rmGTBVlhXjE6'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'user@example.com', 'userLogin', '$2a$10$fpkpmgFpiTHNW4SFBezqneqfgEBprl8hF9XEuJi6XI5ysPzUuOd56'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'developer@example.com', 'developerLogin', '$2a$10$7dj60lz2zP/bwNjFrxNKj.mCd91MyrCoQwZT5obOB46wlKjXHS9Sa');
INSERT INTO users (id, nickname, balance, user_info_id, cart_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'user1', 100.00, UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'user2', 50.00, UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'user3', 75.00, UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO orders (id, price, user_id, promocode_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), '59.99', UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), NULL),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), '29.99', UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), '49.99', UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), NULL);
INSERT INTO reviews (id, comment, stars, game_id, user_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'Great game!', 'S5', UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'WOW, BEAUTIFUL', 'S5', UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'Enjoyed it!', 'S4', UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO roles (id, role_name)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'ADMIN'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'USER'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'DEVELOPER');
INSERT INTO genres (id, name)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), 'ACTION'),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), 'SHOOTER'),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), 'MULTIPLAYER'),
    (UUID_TO_BIN('0d6cdf0f-8334-4138-9ebb-e4d3e74815f2'), 'SINGLEPLAYER'),
    (UUID_TO_BIN('09e76e34-c5b5-48e4-853d-30181ef0c9d3'), 'COOP'),
    (UUID_TO_BIN('3e64d23d-c6d9-4751-99ae-72cad59e99bb'), 'OPEN_WORLD'),
    (UUID_TO_BIN('19819463-3c34-4b82-b058-a40a8b2a78b4'), 'INTERACTIVE');
INSERT INTO users_roles (user_info_id, role_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO carts_games (cart_id, game_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO orders_games (order_id, game_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO promocodes_orders (promocode_id, order_id)
VALUES (NULL, UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
       (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'));
INSERT INTO roles_authorities (role_id, authority_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO users_favorite_games (user_id, game_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO users_reviews (user_id, review_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'));
INSERT INTO game_genre (game_id, genre_id)
VALUES
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238'), UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6')),
    (UUID_TO_BIN('5d747ad1-8fc0-471f-8d78-54fa98fd5eb6'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('fc698b8c-f835-4800-b633-2f7905bfa238')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('0d6cdf0f-8334-4138-9ebb-e4d3e74815f2')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('09e76e34-c5b5-48e4-853d-30181ef0c9d3')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('3e64d23d-c6d9-4751-99ae-72cad59e99bb')),
    (UUID_TO_BIN('93de1a91-9de3-4126-9981-eec527bb998b'), UUID_TO_BIN('19819463-3c34-4b82-b058-a40a8b2a78b4'));
