
CREATE SCHEMA IF NOT EXISTS acesso;


CREATE TABLE IF NOT EXISTS  acesso.usuario
(
  id bigint NOT NULL,
  data_alteracao timestamp without time zone,
  data_criacao timestamp without time zone NOT NULL,
  cpf character varying(255),
  nome character varying(255),
  email character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE IF NOT EXISTS acesso.usuario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


CREATE TABLE IF NOT EXISTS acesso.perfil
(
  id bigint NOT NULL,
  data_alteracao timestamp without time zone,
  data_criacao timestamp without time zone NOT NULL,
  nome character varying(255),
  CONSTRAINT perfil_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE IF NOT EXISTS acesso.perfil_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 12
  CACHE 1;


CREATE TABLE IF NOT EXISTS acesso.usuario_perfil
(
  id_usuario bigint NOT NULL,
  id_perfil bigint NOT NULL,
  CONSTRAINT fk2qe6tjawyl6ojl32uhbwllldh FOREIGN KEY (id_usuario)
      REFERENCES acesso.usuario (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk3cxlmf5q4y8mllkos025n9px8 FOREIGN KEY (id_perfil)
      REFERENCES acesso.perfil (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (1, 'PROFESSOR', now(), now());
INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (2,'COORDENADOR', now(), now());
INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (3,'GESTOR', now(), now());
INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (4,'ESCOLARIDADE', now(), now());
INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (5,'ALUNO', now(), now());
INSERT INTO acesso.perfil(id, nome, data_criacao, data_alteracao) values (6,'SISTEMA', now(), now());

INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (1, 'professor@upe.br', '91171706057', 'Professor UPE', now(), null);
INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (2, 'coordenador@upe.br', '44295775010', 'Coordenador UPE', now(), null);
INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (3, 'gestor@upe.br', '65204390022', 'Gestor UPE', now(), null);
INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (4, 'escolaridade@upe.br', '70928327051', 'Escolaridade UPE', now(), null);
INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (5, 'aluno@upe.br', '55325192000', 'Aluno UPE', now(), null);
INSERT INTO acesso.usuario(id, email, cpf, nome, data_criacao, data_alteracao)   values (6, 'sistema@upe.br', '36628781003', 'Sistema UPE', now(), null);

INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (1, 1);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (2, 1);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (2, 2);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (3, 1);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (3, 2);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (3, 3);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (4, 4);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (5, 5);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 1);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 2);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 3);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 4);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 5);
INSERT INTO acesso.usuario_perfil(id_usuario, id_perfil) values (6, 6);
