create database db_tudodebom;

use db_tudodebom;


CREATE TABLE clientes(
id_cliente int not null auto_increment,
nome_cliente varchar(50) not null,
data_nascimento date not null,
cpf_cliente varchar(11) not null,
telefone_cliente char(11) not null,
primary key(id_cliente));

insert into clientes values 
(null, "Osvaldo Silva", "1972-04-23", "22566158045", "13915243626"),
(null, "Ana Oliveira", "2001-12-07", "28031185001", "47912345678"),
(null, "Thiago Santana", "1992-04-17", "60682988090", "12912345648"),
(null, "Rosana Andrade", "1962-02-18", "39357745084", "71985235678");

select * from clientes;

drop table clientes;