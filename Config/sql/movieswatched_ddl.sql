drop table movierecom.movieswatched;

create table movierecom.movieswatched (
	id serial primary key,
	moviesid bigint not null,
	usersid bigint not null,
	createdat timestamp default now(),
	foreign key(moviesid) references movierecom.movies(id),
	foreign key(usersid) references movierecom.users(id)
);