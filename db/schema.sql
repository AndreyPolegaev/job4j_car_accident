CREATE TABLE accidentType
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE accident
(
    id      serial primary key,
    name    varchar(2000),
    text    varchar(2000),
    address    varchar(2000),
    type_id int references accidenttype (id)
);

CREATE TABLE rules
(
    id          serial primary key,
    name        varchar(2000)
);

create table accident_rules (
    id serial primary key,
    accident_id int references accident(id),
    rules_id int references rules(id)
);

insert into accidentType (name) values
 ('две машины'),
 ('Машина и человек'),
 ('Машина и велосипед');

insert into accident (name, text, address, type_id) values
('Авария', 'desc1', 'Ленинский пр-т д.1', 1),
('Нарушение ПДД', 'desc2', 'ул. Зорге д.5', 3),
('Авария', 'desc1', 'Ленинский пр-т д.1', 2);

insert into rules (name) values
('Статья. 1'),
('Статья. 2'),
('Статья. 3');

insert into accident_rules (accident_id, rules_id) values
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);





drop table rules;
drop table accident;
drop table accidenttype;
drop table accident_rules;
