create table Customer (
	id integer unique,
	display_name varchar(255),
	name varchar(255),
	image_profile varchar(255),
	primary key(id)
);

create sequence customer_sequence start with 1;

create table Contry (
	id integer unique,
	alpha_code_2 char(2),
	alpha_code_3 char(3),
	short_name varchar(255),
	numeric_code int(3),
	independent int(1),
	
	primary key(id)
);

create sequence country_sequence start with 1;

create table Contry_Subdivision (
	id integer unique,
	province_code int(4),
	province_name varchar(255),
	country_id integer foreign key references Country(id); 
	
	primary key(id)
);

create sequence Contry_Subdivision_sequence start with 1;

create table City (
	id integer unique,
	name varchar(255),
	population integer,
	Contry_Subdivision_id integer foreign key references Contry_Subdivision(id); 
	
	primary key(id)
);

create sequence City_sequence start with 1;

create table Address (
	id integer unique,
	name varchar(255),
	AddressType varchar(255),
	number varchar(20),
	zip_code varchar(50),
	postal_code varchar(50),
	City_id integer foreign key references City(id); 
	Customer_id integer foreign key references Customer(id); 
	
	primary key(id)
);

create sequence City_sequence start with 1;
