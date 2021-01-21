drop table users;

create table users (
	id serial primary key,
	username varchar not null unique,
	passwd varchar not null,
	created_at timestamp default now()
);