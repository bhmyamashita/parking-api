create table parking (
	id bigint auto_increment not null,
	car_owner varchar(200) not null,
	payer varchar(200) not null,
	date varchar(200) not null,
	
	primary key (id)
);

create table login (
	id bigint auto_increment not null,
	username varchar(200) not null,
	password varchar(200) not null,
	
	primary key (id)
);