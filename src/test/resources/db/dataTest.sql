INSERT INTO authorities (id, authority)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'R'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'W'),
      (X'93de1a919de341269981eec527bb998b', 'I');

INSERT INTO carts (id, price)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', '0.00'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', '25.00'),
      (X'93de1a919de341269981eec527bb998b', '50.00');

INSERT INTO developers (id, name, creation_date)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'CD Project Red', '2002-05-01'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'Rockstar Games', '1998-12-01'),
      (X'93de1a919de341269981eec527bb998b', 'Ubisoft', '1986-03-28');

INSERT INTO games (id, name, overall_rating, price, sales, developer_id)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'Cyberpunk 2077', '4.5', '59.99', '1000000', X'fc698b8cf8354800b6332f7905bfa238'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'Grand Theft Auto V', '4.8', '29.99', '150000000', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
      (X'93de1a919de341269981eec527bb998b', 'Assassins Creed Valhalla', '4.3', '49.99', '5000000', X'93de1a919de341269981eec527bb998b');

INSERT INTO promocodes (id, type, code, discount, quantity)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'DISCOUNT', 'SUMMER25', '25', '1000'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'GIFT_CARD', 'BIRTHDAY2024', '5', '500');

INSERT INTO user_info (id, email, password)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'admin@example.com', 'admin123'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'user@example.com', 'user123'),
      (X'93de1a919de341269981eec527bb998b', 'developer@example.com', 'developer123');

INSERT INTO users (id, nickname, balance, user_info_id, cart_id)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'user1', 100.00, X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'user2', 50.00, X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
      (X'93de1a919de341269981eec527bb998b', 'user3', 75.00, X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO orders (id, price, user_id, promocode_id)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', '59.99', X'fc698b8cf8354800b6332f7905bfa238', NULL),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', '29.99', X'5d747ad18fc0471f8d7854fa98fd5eb6', X'fc698b8cf8354800b6332f7905bfa238'),
      (X'93de1a919de341269981eec527bb998b', '49.99', X'93de1a919de341269981eec527bb998b', NULL);

INSERT INTO reviews (id, comment, stars, game_id, user_id)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'Great game!', 'S5', X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'WOW, BEAUTIFUL', 'S5', X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
      (X'93de1a919de341269981eec527bb998b', 'Enjoyed it!', 'S4', X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO roles (id, name)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'ADMIN'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'USER'),
      (X'93de1a919de341269981eec527bb998b', 'DEVELOPER');

INSERT INTO genres (id, name)
VALUES(X'fc698b8cf8354800b6332f7905bfa238', 'ACTION'),
      (X'5d747ad18fc0471f8d7854fa98fd5eb6', 'SHOOTER'),
      (X'93de1a919de341269981eec527bb998b', 'MULTIPLAYER'),
      (X'0d6cdf0f833441389ebbe4d3e74815f2', 'SINGLEPLAYER'),
      (X'09e76e34c5b548e4853d30181ef0c9d3', 'COOP'),
      (X'3e64d23dc6d9475199ae72cad59e99bb', 'OPEN_WORLD'),
      (X'198194633c344b82b058a40a8b2a78b4', 'INTERACTIVE');
INSERT INTO carts_games (cart_id, game_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO orders_games (order_id, game_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO promocodes_orders (promocode_id, order_id)
VALUES (NULL, X'fc698b8cf8354800b6332f7905bfa238'),
       (X'fc698b8cf8354800b6332f7905bfa238', X'5d747ad18fc0471f8d7854fa98fd5eb6');

INSERT INTO roles_authorities (role_id, authority_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO users_favorite_games (user_id, game_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO users_reviews (user_id, review_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b');

INSERT INTO game_genre (game_id, genre_id)
VALUES
    (X'fc698b8cf8354800b6332f7905bfa238', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'fc698b8cf8354800b6332f7905bfa238', X'5d747ad18fc0471f8d7854fa98fd5eb6'),
    (X'5d747ad18fc0471f8d7854fa98fd5eb6', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'93de1a919de341269981eec527bb998b', X'fc698b8cf8354800b6332f7905bfa238'),
    (X'93de1a919de341269981eec527bb998b', X'93de1a919de341269981eec527bb998b'),
    (X'93de1a919de341269981eec527bb998b', X'0d6cdf0f833441389ebbe4d3e74815f2'),
    (X'93de1a919de341269981eec527bb998b', X'09e76e34c5b548e4853d30181ef0c9d3'),
    (X'93de1a919de341269981eec527bb998b', X'3e64d23dc6d9475199ae72cad59e99bb'),
    (X'93de1a919de341269981eec527bb998b', X'198194633c344b82b058a40a8b2a78b4');

