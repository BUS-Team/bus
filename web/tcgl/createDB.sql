-- Database: tcgl

-- DROP DATABASE tcgl;

CREATE DATABASE tcgl
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'C'
       LC_CTYPE = 'C'
       CONNECTION LIMIT = -1;

-- Table: posicoes

-- DROP TABLE posicoes;

CREATE TABLE posicoes
(
  id serial NOT NULL,
  datahora timestamp without time zone NOT NULL,
  linha integer,
  sentido character varying(255),
  latitude double precision,
  longitude double precision,
  tipo integer,
  CONSTRAINT posicoes_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE posicoes
  OWNER TO postgres;

-- Index: index_posicoes_id

-- DROP INDEX index_posicoes_id;

CREATE INDEX index_posicoes_id
  ON posicoes
  USING btree
  (id);


CREATE INDEX index_posicoes_linha
  ON posicoes
  USING btree
  (linha);


CREATE INDEX index_posicoes_datahora
  ON posicoes
  USING btree
  (datahora);

