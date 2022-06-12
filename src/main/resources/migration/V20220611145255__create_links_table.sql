create table if not exists links(
    id serial,
    full_link varchar,
    short varchar,
    created timestamp,
    user_id int8 references users(id)
)