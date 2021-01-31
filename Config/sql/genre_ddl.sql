drop table movierecom.genre;

create table movierecom.genre (
	id serial primary key,
	name varchar not null unique,
	createdat timestamp default now()
);