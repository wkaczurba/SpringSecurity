create table users (
  username varchar(20) unique not null,
  password varchar(20) not null,
  enabled boolean
);

create table authorities (
  username varchar(20) not null,
  authority varchar(20) not null
);

create table groups (
  id integer unique,
  group_name varchar(20) unique not null
);

create table group_memembers (
  username varchar(20) not null,
  group_id integer
);

create table group_authorities (
  group_id integer,
  authority varchar(20) not null
);

insert into users (username,password,enabled) values ('user', 'password', true);
insert into users (username,password,enabled) values ('admin', 'password', true);
insert into users (username,password,enabled) values ('lolita', '123abc', true);

insert into authorities (username, authority) values ('user', 'USER');
insert into authorities (username, authority) values ('admin', 'USER');
insert into authorities (username, authority) values ('admin', 'ADMIN');
insert into authorities (username, authority) values ('lolita', 'USER');

