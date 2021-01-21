drop table session;

create table session (
	id serial primary key,
	userid bigint not null,
	activityid bigint not null,
	token varchar,
	created_at timestamp default now(),
	foreign key(userid) references movierecom.users(id),
	foreign key(activityid) references movierecom.datadict(id)
);