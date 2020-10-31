insert into cozinha(id,nome) values (1,'Tailandesa');
insert into cozinha(id,nome) values (2,'Indiana');

insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Thai Gourmet',10,1);
insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Thai Delivery',9.50,1);
insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Tuk Tuk Comida Indiana',15,2);

insert into forma_pagamento(descricao) values ('TPA');
insert into forma_pagamento(descricao) values ('Transferencia');

insert into permissao(nome,descricao) values ('Admin','Administracao');