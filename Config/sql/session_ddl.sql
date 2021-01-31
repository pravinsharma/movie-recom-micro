drop table movierecom.session;

create table movierecom.session (
	id serial primary key,
	userid bigint not null,
	activityid bigint not null,
	token varchar,
	startedat timestamp default now(),
	endedat timestamp,
	foreign key(userid) references movierecom.users(id),
	foreign key(activityid) references movierecom.datadict(id)
);