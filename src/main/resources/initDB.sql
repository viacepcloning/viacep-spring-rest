DROP TABLE IF EXISTS address;

CREATE TABLE IF NOT EXISTS address (
  id SERIAL,
  cep VARCHAR(30),
  logradouro VARCHAR(30),
  complemento VARCHAR(30),
  bairro VARCHAR(30),
  localidade VARCHAR(30),
  uf VARCHAR(30),
  ibge VARCHAR(30),
  gia VARCHAR(30),
  ddd VARCHAR(30),
  siafi VARCHAR(30),
  CONSTRAINT pk_address PRIMARY KEY (id)
);

ALTER SEQUENCE address_id_seq RESTART WITH 100;


