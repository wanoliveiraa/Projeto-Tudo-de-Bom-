use db_tudodebom;

CREATE TABLE compras(
cliente_id int,
cod_compra int not null auto_increment,
data_compra date not null,
primary key (cod_compra),
foreign key (cliente_id) references clientes (id_cliente)
);

drop table compras;
