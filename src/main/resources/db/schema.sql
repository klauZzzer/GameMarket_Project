ALTER TABLE roles_authorities DROP FOREIGN KEY roles_authorities_ibfk_1;
ALTER TABLE roles_authorities DROP FOREIGN KEY roles_authorities_ibfk_2;
ALTER TABLE orders DROP FOREIGN KEY orders_ibfk_1;
ALTER TABLE orders DROP FOREIGN KEY orders_ibfk_2;
ALTER TABLE carts_games DROP FOREIGN KEY carts_games_ibfk_1;
ALTER TABLE carts_games DROP FOREIGN KEY carts_games_ibfk_2;
ALTER TABLE users_favorite_games DROP FOREIGN KEY users_favorite_games_ibfk_1;
ALTER TABLE users_favorite_games DROP FOREIGN KEY users_favorite_games_ibfk_2;
ALTER TABLE games DROP FOREIGN KEY games_ibfk_1;
ALTER TABLE users DROP FOREIGN KEY users_ibfk_2;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS carts;
DROP TABLE IF EXISTS developers;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS promocodes;
DROP TABLE IF EXISTS reveiws;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS users_info;
DROP TABLE IF EXISTS roles_authorities;
DROP TABLE IF EXISTS carts_games;
DROP TABLE IF EXISTS game_genres;
DROP TABLE IF EXISTS order_games;
DROP TABLE IF EXISTS users_favorite_games;
DROP TABLE IF EXISTS users_roles;

CREATE TABLE IF NOT EXISTS authorities (
                             id VARCHAR(36) PRIMARY KEY,
                             authority VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts (
                       id VARCHAR(36) PRIMARY KEY,
                       price DECIMAL(10,2) DEFAULT 0.0
);

CREATE TABLE IF NOT EXISTS developers (
                            id VARCHAR(36) PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            creation_date DATE
);

CREATE TABLE IF NOT EXISTS games (
                       id VARCHAR(36) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       overall_rating DECIMAL(2,1) DEFAULT 0.0,
                       price DECIMAL(10,2) NOT NULL,
                       sales INT DEFAULT 0,
                       developer_id VARCHAR(36),
                       FOREIGN KEY (developer_id) REFERENCES developers(id)
);

CREATE TABLE IF NOT EXISTS promocodes (
                             id VARCHAR(36) PRIMARY KEY,
                             type VARCHAR(255) NOT NULL,
                             code VARCHAR(255) NOT NULL,
                             discount INT NOT NULL,
                             quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
                         id VARCHAR(36) PRIMARY KEY,
                         comment TEXT,
                         stars VARCHAR(255) NOT NULL,
                         game_id VARCHAR(36),
                         user_id VARCHAR(36),
                         FOREIGN KEY (game_id) REFERENCES games(id),
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS roles (
                       id VARCHAR(36) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_info (
                           id VARCHAR(36) PRIMARY KEY,
                           email VARCHAR(255) NOT NULL,
                           password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                id VARCHAR(36) PRIMARY KEY,
                                nickname VARCHAR(255),
                                balance DECIMAL(10,2),
                                user_info_id VARCHAR(36),
                                cart_id VARCHAR(36),
                                FOREIGN KEY (user_info_id) REFERENCES user_info(id),
                                FOREIGN KEY (cart_id) REFERENCES carts(id)
);

CREATE TABLE IF NOT EXISTS orders (
                                      id VARCHAR(36) PRIMARY KEY,
                                      price DECIMAL(10,2) NOT NULL,
                                      user_id VARCHAR(36),
                                      promocode_id VARCHAR(36),
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (promocode_id) REFERENCES promocodes(id)
);

CREATE TABLE IF NOT EXISTS carts_games (
                             cart_id VARCHAR(36) NOT NULL,
                             game_id VARCHAR(36) NOT NULL,
                             PRIMARY KEY (cart_id, game_id),
                             FOREIGN KEY (cart_id) REFERENCES carts(id),
                             FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS games_genres (
                              game_id VARCHAR(36) NOT NULL,
                              genre VARCHAR(255) NOT NULL,
                              PRIMARY KEY (game_id, genre),
                              FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS orders_games (
                              order_id VARCHAR(36) NOT NULL,
                              game_id VARCHAR(36) NOT NULL,
                              PRIMARY KEY (order_id, game_id),
                              FOREIGN KEY (order_id) REFERENCES orders(id),
                              FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS promocodes_orders (
                                   promocode_id VARCHAR(36) NOT NULL,
                                   order_id VARCHAR(36) NOT NULL,
                                   PRIMARY KEY (promocode_id, order_id),
                                   FOREIGN KEY (promocode_id) REFERENCES promocodes(id),
                                   FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE IF NOT EXISTS roles_authorities (
                                   role_id VARCHAR(36) NOT NULL,
                                   authority_id VARCHAR(36) NOT NULL,
                                   PRIMARY KEY (role_id, authority_id),
                                   FOREIGN KEY (role_id) REFERENCES roles(id),
                                   FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

CREATE TABLE IF NOT EXISTS users_favorite_games (
                                      user_id VARCHAR(36) NOT NULL,
                                      game_id VARCHAR(36) NOT NULL,
                                      PRIMARY KEY (user_id, game_id),
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS users_reviews (
                               user_id VARCHAR(36) NOT NULL,
                               review_id VARCHAR(36) NOT NULL,
                               PRIMARY KEY (user_id, review_id),
                               FOREIGN KEY (user_id) REFERENCES users(id),
                               FOREIGN KEY (review_id) REFERENCES reviews(id)
);