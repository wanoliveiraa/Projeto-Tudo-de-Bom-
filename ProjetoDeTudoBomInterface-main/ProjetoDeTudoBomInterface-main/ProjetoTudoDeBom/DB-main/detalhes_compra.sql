CREATE TABLE detalhes_compra(
preco_estendido double not null,
quant_compra int not null,
valorTotal double not null,
num_seq int not null auto_increment,
produto_id int,
compra_cod int,
primary key (num_seq),
foreign key (produto_id) references produto (id_produto),
foreign key (compra_cod) references compras (cod_compra)
);


