CREATE TABLE IF NOT EXISTS options (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price BIGINT NOT NULL,
    CONSTRAINT UK_options_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS room_categories (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   CONSTRAINT UK_room_categories_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS rooms (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    number INT NOT NULL,
    category_id VARCHAR(50) NOT NULL,
    standard_price BIGINT NOT NULL,
    CONSTRAINT UK_rooms_number UNIQUE (number),
    CONSTRAINT FK_rooms_room FOREIGN KEY (category_id) REFERENCES room_categories(id)
);

CREATE TABLE IF NOT EXISTS room_options (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    option_id BIGINT NOT NULL,
    room_id BIGINT,
    date TIMESTAMP,
    CONSTRAINT FK_room_options_room FOREIGN KEY (room_id) REFERENCES rooms(id),
    CONSTRAINT FK_room_options_option FOREIGN KEY (option_id) REFERENCES options(id)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    room_id BIGINT,
    check_in_date TIMESTAMP,
    check_out_date TIMESTAMP,
    CONSTRAINT UK_users UNIQUE (last_name, first_name, room_id, check_in_date, check_out_date),
    CONSTRAINT FK_users_room FOREIGN KEY (room_id) REFERENCES rooms(id)
);
