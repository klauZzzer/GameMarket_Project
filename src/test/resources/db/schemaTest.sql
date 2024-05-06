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
                       FOREIGN KEY (developer_id) REFERENCES developers(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS promocodes (
                            id UUID PRIMARY KEY,
                             type VARCHAR(255) NOT NULL,
                             code VARCHAR(255) NOT NULL,
                             discount INT NOT NULL,
                             quantity INT NOT NULL
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

CREATE TABLE IF NOT EXISTS users (
                                id UUID PRIMARY KEY,
                                nickname VARCHAR(255),
                                balance DECIMAL(10,2),
                                user_info_id UUID,
                                cart_id UUID,
                                FOREIGN KEY (user_info_id) REFERENCES user_info(id),
                                FOREIGN KEY (cart_id) REFERENCES carts(id)
);

CREATE TABLE IF NOT EXISTS reviews (
                                        id UUID PRIMARY KEY,
                                       comment TEXT,
                                       stars VARCHAR(255) NOT NULL,
                                       game_id UUID,
                                       user_id UUID,
                                       FOREIGN KEY (game_id) REFERENCES games(id),
                                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS orders (
                                        id UUID PRIMARY KEY,
                                      price DECIMAL(10,2) NOT NULL,
                                      user_id UUID,
                                      promocode_id UUID,
                                      FOREIGN KEY (user_id) REFERENCES users(id),
                                      FOREIGN KEY (promocode_id) REFERENCES promocodes(id)
);

CREATE TABLE IF NOT EXISTS genres (
                        id UUID PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);
