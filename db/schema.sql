CREATE TABLE accident
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE rules
(
    id   serial primary key,
    name varchar(2000)
);

CREATE TABLE accidentType
(
    id   serial primary key,
    name varchar(2000)
);