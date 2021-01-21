drop table datadict;

create table datadict (
	id serial primary key,
	name varchar not null,
	description varchar not null,
	created_at timestamp default now()
);