# GameMarket (Backend)
This is a simplified backend implementation of an online game store with basic entities and controllers.

Entities: Authority, Cart, Developer, Game, Genre, Order, Promocode, Review, Role, User, UserInfo

## How can you install my project?

### 1.Clone the repository

```
https://github.com/klauZzzer/GameMarket_Project
```

---

### 2.Write your data into environment variables

##### environment variables are in the file application.yaml, write your data and the program is ready to run.

```
/src/main/resources/application.yaml
```

---

## Technologies:

- Java 17
- MySQL (database)
- JPA
- SpringBoot (starter-web)
- SpringSecurity (security)
- SpringDoc (starter-webmvc)
- LiquidBase (database migration)
- MapStruct (mapper)
- BCrypt (password)
- Jacoco (analysis)
- Swagger (controllers)
- Maven (dependencies)
- Logback (logs)
- Jupiter (tests)

---

## Database

### Table Authorities

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| authority      | varchar(255)  | authority name, not null           | 

### Table Carts 

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| price          | decimal(10,2) | price, default 0.0                 | 

### Table Developers

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| name           | varchar(255)  | name of developer, not null        | 
| creation_date  | data          | creation date of the company       |

### Table Games

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| name           | varchar(255)  | name of game , not null            | 
| overall_rating | decimal(2,1)  | rating of game, default 0.0        |
| price          | decimal(10,2) | price of game, not null            |
| sales          | int           | count of sales, default 0          |
| developer_id   | binary(16)    | id key, foreign key                |

### Table Promocodes

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| type           | varchar(255)  | type of promocode(enum), not null  | 
| code           | varchar(255)  | code for discount, not null        |
| discount       | int           | discount in % or number, not null  |
| quantity       | int           | quantity of promocodes             |

### Table Roles

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                |  
| role_name      | varchar(255)  | name of role(enum), not null       | 

### Table User_Info

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| login          | varchar(255)  | login of user, not null            | 
| email          | varchar(255)  | email of user, not null            |
| password       | varchar(255)  | password of user, not null         |

### Table Users

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| nickname       | varchar(255)  | user nickname, not null            | 
| balance        | decimal(10,2) | balance of user, default 0.0       |
| user_info_id   | binary(16)    | foreign key, not null              |
| cart_id        | binary(16)    | foreign key, not null              |

### Table Reviews

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| comment        | text          | comment for review                 | 
| stars          | varchar(255)  | stars for game, not null           |
| game_id        | binary(16)    | foreign key, not null              |
| user_id        | binary(16)    | foreign key, not null              |

### Table Orders

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| price          | decimal(10,2) | price of all games, not null       | 
| user_id        | binary(16)    | foreign key, not null              |
| promocode_id   | binary(16)    | foreign key, not null              |

### Table Genres

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| id             | binary(16)    | id key, primary key                | 
| name           | varchar(255)  | name of genre, not null            | 

### Table User_Info_Role

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| user_info_id   | binary(16)    | foreign key, not null              | 
| role_id        | binary(16)    | foreign key, not null              | 

### Table Carts_Games

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| cart_id        | binary(16)    | foreign key, not null              | 
| game_id        | binary(16)    | foreign key, not null              | 

### Table Orders_Games

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| order_id       | binary(16)    | foreign key, not null              | 
| game_id        | binary(16)    | foreign key, not null              | 

### Table Promocodes_Orders

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| promocode_id   | binary(16)    | foreign key                        | 
| order_id       | binary(16)    | foreign key, not null              | 

### Table Roles_Authorities

| Column name    | Type          | Description                        |
|----------------|---------------|------------------------------------|
| role_id        | binary(16)    | foreign key, not null              | 
| authority_id   | binary(16)    | foreign key, not null              | 

### Table Users_Favorite_Games

| Column name    | Type          | Description           |
|----------------|---------------|-----------------------|
| user_id        | binary(16)    | foreign key, not null | 
| game_id        | binary(16)    | foreign key, not null | 

### Table Users_Reviews

| Column name    | Type          | Description           |
|----------------|---------------|-----------------------|
| user_id        | binary(16)    | foreign key, not null | 
| review_id      | binary(16)    | foreign key, not null | 

### Table Game_Genre 

| Column name    | Type          | Description           |
|----------------|---------------|-----------------------|
| game_id        | binary(16)    | foreign key, not null | 
| genre_id       | binary(16)    | foreign key, not null | 




 
 







