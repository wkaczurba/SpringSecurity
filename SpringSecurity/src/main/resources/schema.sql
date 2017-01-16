create table users (
  username varchar(20) unique not null,
  password varchar(80) not null,
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

/*insert into users (username,password,enabled) values ('user', 'password', true);
insert into users (username,password,enabled) values ('admin', 'password', true);
insert into users (username,password,enabled) values ('lolita', '123abc', true);*/


/*
Encoded passwords: using: 
  -> StandardPasswordEncoder encoder = new StandardPasswordEncoder("12d4kv");
  (new StandardPasswordEncoder("12d4kv")).encode("abc123")   -> '65d8bd26468d037f67fefd1ce7c663502888fbeb2305fdf39b7cbfc516a94f220b2b67f15187b203' 
  (new StandardPasswordEncoder("12d4kv")).encode("password") -> '47fce92d5c9735028f9d8226cb30286e898124195dcb74f0bbd166ec5e175b72d7bb006d267deb48'
*/
insert into users (username,password,enabled) values ('user',   '47fce92d5c9735028f9d8226cb30286e898124195dcb74f0bbd166ec5e175b72d7bb006d267deb48', true);
insert into users (username,password,enabled) values ('admin',  '47fce92d5c9735028f9d8226cb30286e898124195dcb74f0bbd166ec5e175b72d7bb006d267deb48', true);
insert into users (username,password,enabled) values ('lolita', '65d8bd26468d037f67fefd1ce7c663502888fbeb2305fdf39b7cbfc516a94f220b2b67f15187b203', true);

insert into authorities (username, authority) values ('user',  'USER');
insert into authorities (username, authority) values ('admin', 'USER');
insert into authorities (username, authority) values ('admin', 'ADMIN');
insert into authorities (username, authority) values ('lolita', 'USER');

