INSERT INTO options (id, name, price)
VALUES (2001, 'breakfast', 20),
      (2002, 'cleaning', 15);

INSERT INTO room_categories (id, name)
VALUES (4001, 'Single'),
      (4002, 'Double'),
      (4003, 'Triple'),
      (4004, 'Quad');

INSERT INTO rooms (id, number, category_id, standard_price)
VALUES (5001, 1, 4001, 100),
      (5002, 2, 4001, 100),
      (5003, 3, 4001, 100),
      (5004, 4, 4002, 110),
      (5005, 5, 4002, 110),
      (5006, 6, 4003, 130),
      (5007, 7, 4003, 130),
      (5008, 8, 4004, 180);

INSERT INTO room_options (id, option_id, room_id, date)
VALUES (3001, 2001, 5001, now()),
       (3002, 2002, 5001, now()),
       (3003, 2001, 5005, now());

INSERT INTO users (id, last_name, first_name, room_id, check_in_date, check_out_date)
VALUES (1001, 'Ivanov', 'Ivan', 5001, now(), now()),
      (1002, 'Petrov', 'Petr', 5005, now(), now()),
      (1003, 'Sydorov', 'Sydor', 5006, now(), now());
