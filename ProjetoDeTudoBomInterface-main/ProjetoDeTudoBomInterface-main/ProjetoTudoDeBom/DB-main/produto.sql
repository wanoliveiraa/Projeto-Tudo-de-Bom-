CREATE TABLE produto(
id_produto int not null auto_increment,
nome_produto varchar(50) not null,
qtd_produto int not null,
tipo_medicamento boolean,
tipo_generico boolean,
preco double not null,
primary key(id_produto));


insert into produto values 
(null, "Losartana Potassica", 12, true,true, 53.00),
(null, "Nimesulida ", 18, true,true, 59.00),
(null, "Dipirona", 13, true, true, 6.57),
(null, "Maleato de Enalapril", 05, true, true, 13.39),
(null, "Clopidogrel ", 12, true, true, 41.33),
(null, "Buscopan", 15, true, false, 25.00),
(null, "Dorflex ", 25, true, false, 22.69),
(null, "Allegra", 06, true, false, 31.79),
(null, "Salompas G - 04 und", 15,true, false, 14.69),
(null, "MultiGripe 400mg ", 30, true, false, 20.19),
(null, "Koleston", 15, false, false, 18.99),
(null, "Colgate", 10, false, false, 2.99);

describe produto;
select * from produto;
select * from produto where tipo_medicamento = true;
select * from produto where tipo_generico != true;

