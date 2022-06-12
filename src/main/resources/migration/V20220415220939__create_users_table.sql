create table if not exists users(
    id serial primary key,
    username varchar unique,
    mail varchar unique,
    password varchar,
    role varchar,
    status varchar,
    birth_date date default now()
);