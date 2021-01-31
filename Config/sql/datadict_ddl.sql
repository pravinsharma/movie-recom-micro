drop table movierecom.datadict;

create table movierecom.datadict (
	id serial primary key,
	name varchar not null,
	description varchar not null,
	createdat timestamp default now()
);