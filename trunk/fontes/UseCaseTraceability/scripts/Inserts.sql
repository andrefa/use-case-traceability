INSERT INTO project(id, name, path_project)
values(NEXT VALUE FOR s_project_01, 'VideoStore', '/home/marcos/projects/UCT/fontes/VideoStore');

INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF01', 'Cadastro de Filmes', 'O sistema deve permitir o cadastro de filmes.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF02', 'Classificação de Filmes em Gêneros', 'O sistema deve permitir a classificação do filme em diferentes gêneros.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF03', 'Tempo de Locação', 'O sistema deve permitir definir o tempo de locação por filme.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF04', 'Preço de Locação', 'O sistema deve permitir definir o preço da locação por filme.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF05', 'Cadastro de Clientes', 'O sistema deve permitir cadastrar clientes.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF06', 'Associar Dependentes', 'O sistema deve permitir associar dependentes a um cliente.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF07', 'Locação de Filmes', 'O sistema deve permitir o cliente locar filmes.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF08', 'Reservas de Filmes', 'O sistema deve permitir o cliente reservar filmes.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF09', 'Relatório de Clientes', 'O sistema deverá possuir um relatório de clientes.', (SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF10', 'Relatório de Filmes por Cliente', 'O sistema deverá possuir um relatório de filmes locados por cliente.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO functional_requisite(id, name, description, project_id)
VALUES('RF11', 'Relatório de Filmes', 'O sistema deverá possuir um relatório de filmes no acervo da loja.', 
(SELECT id FROM project WHERE name = 'VideoStore'));

INSERT INTO use_case(id, name, description, project_id)
VALUES('UC01', 'Cadastrar Filme', 'Caso de uso responsável por manter as informações do filme.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC02', 'Cadastrar Gênero', 'Caso de uso responsável por manter as informações do gênero.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC03', 'Cadastrar Cliente', 'Caso de uso responsável por manter as informações do cliente.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC04', 'Cadastrar Dependente', 'Caso de uso responsável por manter as informações do dependente.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC05', 'Reservar Filme', 'Caso de uso responsável por realizar a reservas de filmes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC06', 'Locar Filme', 'Caso de uso responsável por realizar a locação de filmes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC07', 'Emitir Relatório de Clientes', 'Caso de uso responsável por emitir o relatório de clientes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC08', 'Emitir Relatório de Filmes', 'Caso de uso responsável por emitir o relatório de filmes do acervo da loja.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO use_case(id, name, description, project_id)
VALUES('UC09', 'Emitir Relatório de Filmes Locados por Cliente', 
'Caso de uso responsável por emitir o relatório de filmes locados por cliente.', 
(SELECT id FROM project WHERE name = 'VideoStore'));

INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN01', 'Validação de campos do formulário de cadastro de filme', 'Regras de validação ao cadastrar filme.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN02', 'Validação de campos do formulário de cadastro de gênero', 'Regras de validação ao cadastrar gênero.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN03', 'Validação de campos do formulário de cliente', 'Regras de validação ao cadastrar cliente.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN04', 'Validação de campos do formulário de dependente', 'Regras de validação ao cadastrar dependente.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN05', 'Associar dependente ao cliente', 'Regras para associar um dependente a um cliente.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN06', 'Regras para realizar reserva de filmes', 'Regras para permitir a reserva de filmes pelo cliente.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN07', 'Regras para realizar locação de filmes', 'Regras para permitir a locação de filmes pelo cliente.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN08', 'Emissão do relatório de clientes', 'Regras do relatório de clientes.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN09', 'Emissão do relatório de filmes', 'Regras do relatório de filmes.',
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO business_rule(id, name, description, project_id)
VALUES('RN10', 'Emissão do relatório de filmes locados por cliente', 'Regras do relatório de filmes locados por cliente.',
(SELECT id FROM project WHERE name = 'VideoStore'));

INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI01', 'Persistir filme', 'Regras para persistir um filme na base de dados.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI02', 'Persistir gênero', 'Regras para persistir um gênero na base de dados.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI03', 'Persistir cliente', 'Regras para persistir um cliente na base de dados.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI04', 'Persistir dependente', 'Regras para persistir um dependente na base de dados.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI05', 'Consulta dos gêneros de filmes', 'SQL da consulta de gêneros de filmes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI06', 'Consulta de clientes', 'SQL da consulta de clientes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI07', 'Consulta de filmes', 'SQL da consulta de filmes.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
INSERT INTO implementation_rule(id, name, description, project_id)
VALUES('RI08', 'Consulta de filmes locados por cliente', 'SQL da consulta de filmes locados por cliente.', 
(SELECT id FROM project WHERE name = 'VideoStore'));
