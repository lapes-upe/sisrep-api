ALTER TABLE acesso.usuario
ADD COLUMN IF NOT EXISTS foto bytea[],
ADD COLUMN IF NOT EXISTS endereco character varying(255),
ADD COLUMN IF NOT EXISTS cidade character varying(255),
ADD COLUMN IF NOT EXISTS cep character varying(255),
ADD COLUMN IF NOT EXISTS celular character varying(255);
