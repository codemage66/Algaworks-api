insert into cozinha(id,nome) values (1,'Tailandesa');
insert into cozinha(id,nome) values (2,'Indiana');

insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Thai Gourmet',10,1);
insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Thai Delivery',9.50,1);
insert into restaurante(nome, taxa_frete,cozinha_id) VALUES ('Tuk Tuk Comida Indiana',15,2);

insert into forma_pagamento(descricao) values ('TPA'),('Transferencia'), ('CX Express'),('Dinheiro');

insert into permissao(nome,descricao) values ('Admin','Administracao');

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) VALUES (1,1),(1,2),(1,3),(2,3),(3,2),(3,3);