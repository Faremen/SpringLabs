create table filler
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
)

create table hookah
(
    id         bigint not null,
    filler_id  bigint not null,
    tobacco_id bigint not null,
    primary key (id)
)

create table hookah_order
(
    id             bigint  not null,
    selected_table integer not null check (selected_table <= 10 AND selected_table >= 1),
    telephone      varchar(255),
    hookah_id      bigint,
    primary key (id)
)

create table tobacco
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
)

create table users
(
    id        binary(255) not null,
    email     varchar(255),
    name      varchar(255),
    password  varchar(255),
    role      varchar(255),
    telephone varchar(255),
    username  varchar(255),
    primary key (id)
)