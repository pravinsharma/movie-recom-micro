drop table movierecom.movies;

create table movierecom.movies (
	id serial primary key,
	name varchar not null unique,
	year char(4) not null,
	genreid bigint not null,
	summary varchar,
	createdat timestamp default now(),
	foreign key(genreid) references movierecom.genre(id)
);