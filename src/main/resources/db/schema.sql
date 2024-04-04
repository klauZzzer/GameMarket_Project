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
                             id UUID PRIMARY KEY,
                             authority VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts (
                       id UUID PRIMARY KEY,
                       price DECIMAL(10,2) DEFAULT 0.0
);

CREATE TABLE IF NOT EXISTS developers (
                            id UUID PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            creation_date DATE
);

CREATE TABLE IF NOT EXISTS games (
                       id UUID PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       overall_rating DECIMAL(2,1) DEFAULT 0.0,
                       price DECIMAL(10,2) NOT NULL,
                       sales INT DEFAULT 0,
                       developer_id UUID,
                       FOREIGN KEY (developer_id) REFERENCES developers(id)
);

CREATE TABLE IF NOT EXISTS orders (
                        id UUID PRIMARY KEY,
                        price DECIMAL(10,2) NOT NULL,
                        user_id UUID,
                        promocode_id UUID,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (promocode_id) REFERENCES promocodes(id)
);

CREATE TABLE IF NOT EXISTS promocodes (
                             id UUID PRIMARY KEY,
                             type VARCHAR(255) NOT NULL,
                             code VARCHAR(255) NOT NULL,
                             discount INT NOT NULL,
                             quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS reviews (
                         id UUID PRIMARY KEY,
                         comment TEXT DEFAULT 'no comments',
                         stars VARCHAR(255) NOT NULL,
                         game_id UUID,
                         user_id UUID,
                         FOREIGN KEY (game_id) REFERENCES games(id),
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS roles (
                       id UUID PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_info (
                           id UUID PRIMARY KEY,
                           email VARCHAR(255) NOT NULL,
                           password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts_games (
                             cart_id UUID NOT NULL,
                             game_id UUID NOT NULL,
                             PRIMARY KEY (cart_id, game_id),
                             FOREIGN KEY (cart_id) REFERENCES carts(id),
                             FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS games_genres (
                              game_id UUID NOT NULL,
                              genre VARCHAR(255) NOT NULL,
                              PRIMARY KEY (game_id, genre),
                              FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS orders_games (
                              order_id UUID NOT NULL,
                              game_id UUID NOT NULL,
                              PRIMARY KEY (order_id, game_id),
                              FOREIGN KEY (order_id) REFERENCES orders(id),
                              FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS promocodes_orders (
                                   promocode_id UUID NOT NULL,
                                   order_id UUID NOT NULL,
                                   PRIMARY KEY (promocode_id, order_id),
                                   FOREIGN KEY (promocode_id) REFERENCES promocodes(id),
                                   FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE IF NOT EXISTS roles_authorities (
                                   role_id UUID NOT NULL,
                                   authority_id UUID NOT NULL,
                                   PRIMARY KEY (role_id, authority_id),
                                   FOREIGN KEY (role_id) REFERENCES roles(id),
                                   FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

CREATE TABLE IF NOT EXISTS users_favorite_games (
                                      user_id UUID NOT NULL,
                                      game_id UUID NOT NULL,
                                      PRIMARY KEY (user_id, game_id),
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS users_reviews (
                               user_id UUID NOT NULL,
                               review_id UUID NOT NULL,
                               PRIMARY KEY (user_id, review_id),
                               FOREIGN KEY (user_id) REFERENCES users(id),
                               FOREIGN KEY (review_id) REFERENCES reviews(id)
);