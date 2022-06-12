ALTER TABLE acesso.usuario
ADD COLUMN IF NOT EXISTS token varchar(255);

ALTER TABLE acesso.usuario
ADD COLUMN IF NOT EXISTS ativo boolean;

ALTER TABLE acesso.sistema
ADD COLUMN IF NOT EXISTS ativo boolean;

ALTER TABLE acesso.sistema
ADD COLUMN IF NOT EXISTS link varchar(255);

UPDATE acesso.usuario set token = '$2a$10$EQlkvZb8PZ8TjdT0pN2Z5OaE5HYjHZ.C16DdA0DOlLGQCYvRrspje', ativo=true;

UPDATE acesso.sistema set ativo=true, link='http://localhost:8080/sistema';

