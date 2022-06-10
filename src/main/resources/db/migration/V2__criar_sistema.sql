
CREATE TABLE IF NOT EXISTS  acesso.sistema
(
  id bigint NOT NULL,
  data_alteracao timestamp without time zone,
  data_criacao timestamp without time zone NOT NULL,
  nome character varying(255),
  descricao character varying(255),
  link character varying(255),
  icone bytea[],
  CONSTRAINT sistema_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE IF NOT EXISTS acesso.sistema_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


INSERT INTO acesso.sistema (id, nome, descricao, link, icone, data_alteracao, data_criacao) VALUES (1, 'Preencher PADs', 'Preencha seus PADs de maneira rápida e fácil.', 'http://localhost:8080/pad-web', null, now(), now());

