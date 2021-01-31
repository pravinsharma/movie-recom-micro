drop table movierecom.users;

create table movierecom.users (
	id serial primary key,
	username varchar not null unique,
	passwd varchar not null,
	createdat timestamp default now()
);