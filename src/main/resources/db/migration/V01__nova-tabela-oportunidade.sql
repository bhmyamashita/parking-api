create table parking (
	id bigint auto_increment not null,
	car_owner varchar(200) not null,
	payer varchar(200) not null,
	date varchar(200) not null,
		
	primary key (id)
);