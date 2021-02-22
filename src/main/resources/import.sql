insert into cozinha(id,nome) values (1,'Tailandesa');
insert into cozinha(id,nome) values (2,'Indiana');

insert into estado(id, nome) VALUES (1,'Minas Gerais'),(2,'Sao Paulo'),(3,'Ceara');

insert into cidade(id, nome, estado_id) VALUES (1,'Uberlandia',1),(2,'Belo Horizonte',1),(3,'Sao Paulo',2),(4,'Campinas',2),(5,'Fortaleza',3);

insert into restaurante(nome, taxa_frete,cozinha_id, endereco_cidade_id,endereco_cep,endereco_logradouro,endereco_numero,endereco_bairro, data_cadastro,data_actualizacao) VALUES ('Thai Gourmet',10,1,1,'38400-999','Rua Joao Pinheiro',1000,'Centro',utc_timestamp,utc_timestamp);
insert into restaurante(nome, taxa_frete,cozinha_id, data_cadastro,data_actualizacao) VALUES ('Thai Delivery',9.50,1,utc_timestamp,utc_timestamp);
insert into restaurante(nome, taxa_frete,cozinha_id, data_cadastro,data_actualizacao) VALUES ('Tuk Tuk Comida Indiana',15,2,utc_timestamp,utc_timestamp);

insert into forma_pagamento(descricao) values ('TPA'),('Transferencia'), ('CX Express'),('Dinheiro');

insert into permissao(nome,descricao) values ('Admin','Administracao');

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1,1),(1,2),(1,3),(2,3),(3,2),(3,3);