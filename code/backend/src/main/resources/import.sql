insert into Users (id, firstname, lastname, street, houseno, zip, city)
values (1000, 'Max', 'Muster', 'Testweg', '123', '4020', 'Linz');
insert into Users (id, firstname, lastname, street, houseno, zip, city)
values (1001, 'Susi', 'Sonne', 'Sonnenweg', '234', '5020', 'Salzburg');
insert into Users (id, firstname, lastname, street, houseno, zip, city)
values (1002, 'Hans', 'Huber', 'Hagelweg', '34/5', '1010', 'Wien');


insert into Product (id, name, description)
values (1000, 'Raspberry PI 4, 4MB', 'Raspberry mit 4 MB RAM, ohne Gehäuse, ohne Netzteil');
insert into Product (id, name, description)
values (1001, 'Wireless Keyboard, Logitech', 'Wireless Keyboard, Kompatibel mit PC und Raspberry PI');


insert into Auction (id, start_ts, end_ts, start_price, product_id, users_id)
values (2000, '2020-12-06 08:00:00', '2021-04-06 12:00:00', 1.00, 1000, 1002);
insert into Auction (id, start_ts, end_ts, start_price, product_id, users_id)
values (2001, '2021-12-07 08:00:00', '2022-12-10 12:00:00', 1.00, 1000, 1002);
insert into Auction (id, start_ts, end_ts, start_price, product_id, users_id)
values (2002, '2021-12-09 08:00:00', '2022-12-20 12:00:00', 1.00, 1001, 1002);


insert into Bid (id, amount, timestamp, auction_id, users_id)
values (10001, 3, '2021-12-07 09:00:00', 2001, 1000);
insert into Bid (id, amount, timestamp, auction_id, users_id)
values (10002, 27, '2021-12-07 09:10:00', 2001, 1001);