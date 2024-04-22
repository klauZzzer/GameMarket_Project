
CREATE TABLE IF NOT EXISTS authorities (
                             id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                             authority VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts (
                       id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                       price DECIMAL(10,2) DEFAULT 0.0
);

CREATE TABLE IF NOT EXISTS developers (
                            id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                            name VARCHAR(255) NOT NULL,
                            creation_date DATE
);

CREATE TABLE IF NOT EXISTS games (
                       id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                       name VARCHAR(255) NOT NULL,
                       overall_rating DECIMAL(2,1) DEFAULT 0.0,
                       price DECIMAL(10,2) NOT NULL,
                       sales INT DEFAULT 0,
                       developer_id BINARY(16),
                       FOREIGN KEY (developer_id) REFERENCES developers(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS promocodes (
                             id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                             type VARCHAR(255) NOT NULL,
                             code VARCHAR(255) NOT NULL,
                             discount INT NOT NULL,
                             quantity INT NOT NULL
);



CREATE TABLE IF NOT EXISTS roles (
                       id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_info (
                           id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                           email VARCHAR(255) NOT NULL,
                           password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
                                id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                                nickname VARCHAR(255),
                                balance DECIMAL(10,2),
                                user_info_id BINARY(16),
                                cart_id BINARY(16),
                                FOREIGN KEY (user_info_id) REFERENCES user_info(id),
                                FOREIGN KEY (cart_id) REFERENCES carts(id)
);

CREATE TABLE IF NOT EXISTS reviews (
                                       id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                                       comment TEXT,
                                       stars VARCHAR(255) NOT NULL,
                                       game_id BINARY(16),
                                       user_id BINARY(16),
                                       FOREIGN KEY (game_id) REFERENCES games(id),
                                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS orders (
                                      id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                                      price DECIMAL(10,2) NOT NULL,
                                      user_id BINARY(16),
                                      promocode_id BINARY(16),
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (promocode_id) REFERENCES promocodes(id)
);

CREATE TABLE genres (
                        id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carts_games (
                                            cart_id BINARY(16) NOT NULL,
                                            game_id BINARY(16) NOT NULL,
                                            PRIMARY KEY (cart_id, game_id),
                                            FOREIGN KEY (cart_id) REFERENCES carts(id) ON DELETE CASCADE,
                                            FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS orders_games (
                              order_id BINARY(16) NOT NULL,
                              game_id BINARY(16) NOT NULL,
                              PRIMARY KEY (order_id, game_id),
                              FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
                              FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS promocodes_orders (
                                                 promocode_id BINARY(16),
                                                 order_id BINARY(16) NOT NULL,
                                                 PRIMARY KEY (order_id),
                                                 UNIQUE INDEX idx_promocode_order (promocode_id, order_id),
                                                 FOREIGN KEY (promocode_id) REFERENCES promocodes(id),
                                                 FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE IF NOT EXISTS roles_authorities (
                                   role_id BINARY(16) NOT NULL,
                                   authority_id BINARY(16) NOT NULL,
                                   PRIMARY KEY (role_id, authority_id),
                                   FOREIGN KEY (role_id) REFERENCES roles(id),
                                   FOREIGN KEY (authority_id) REFERENCES authorities(id)
);

CREATE TABLE IF NOT EXISTS users_favorite_games (
                                      user_id BINARY(16) NOT NULL,
                                      game_id BINARY(16) NOT NULL,
                                      PRIMARY KEY (user_id, game_id),
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users_reviews (
                               user_id BINARY(16) NOT NULL,
                               review_id BINARY(16) NOT NULL,
                               PRIMARY KEY (user_id, review_id),
                               FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                               FOREIGN KEY (review_id) REFERENCES reviews(id) ON DELETE CASCADE
);

CREATE TABLE game_genre (
                            game_id BINARY(16),
                            genre_id BINARY(16),
                            PRIMARY KEY (game_id, genre_id),
                            FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
                            FOREIGN KEY (genre_id) REFERENCES genres(id)
);