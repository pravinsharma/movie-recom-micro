create user movierecom;

alter user movierecom createdb;

alter user movierecom with encrypted password 'taHR41yl234';

drop database movierecom;

create database movierecom
	with owner = movierecom encoding = 'UTF8';
	
grant all privileges on database movierecom to movierecom;

create schema movierecom authorization movierecom;