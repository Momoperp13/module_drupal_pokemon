CREATE DATABASE village;

CREATE TABLE IF NOT EXISTS migrations
(
  id        SERIAL       NOT NULL
    CONSTRAINT migrations_pkey
    PRIMARY KEY,
  migration VARCHAR(255) NOT NULL,
  batch     INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
  id             SERIAL       NOT NULL
    CONSTRAINT users_pkey
    PRIMARY KEY,
  name           VARCHAR(255) NOT NULL,
  pays           VARCHAR,
  mobile         VARCHAR,
  email          VARCHAR(255) NOT NULL
    CONSTRAINT users_email_unique
    UNIQUE,
  password       VARCHAR(255) NOT NULL,
  remember_token VARCHAR(100),
  admin          BOOLEAN,
  created_at     TIMESTAMP(0),
  updated_at     TIMESTAMP(0)
);

CREATE TABLE IF NOT EXISTS password_resets
(
  email      VARCHAR(255) NOT NULL,
  token      VARCHAR(255) NOT NULL,
  created_at TIMESTAMP(0)
);

CREATE INDEX IF NOT EXISTS password_resets_email_index
  ON password_resets (email);

CREATE TABLE IF NOT EXISTS catalogue
(
  id          SERIAL NOT NULL
    CONSTRAINT catalogue_pkey
    PRIMARY KEY,
  numero      INTEGER,
  capacite    INTEGER,
  type        VARCHAR,
  description VARCHAR,
  prix        INTEGER,
  created_at  TIMESTAMP,
  deleted_at  TIMESTAMP,
  updated_at  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reservations
(
  id           SERIAL NOT NULL
    CONSTRAINT reservations_pkey
    PRIMARY KEY,
  arrivee      DATE,
  depart       DATE,
  prix         INTEGER,
  created_at   TIMESTAMP,
  deleted_at   TIMESTAMP,
  updated_at   TIMESTAMP,
  catalogue_id INTEGER
    CONSTRAINT reservations_catalogue_id_fkey
    REFERENCES catalogue,
  user_id      INTEGER
    CONSTRAINT reservations_user_id_fkey
    REFERENCES users
);

CREATE TABLE IF NOT EXISTS migrations
(
  id        SERIAL       NOT NULL
    CONSTRAINT migrations_pkey
    PRIMARY KEY,
  migration VARCHAR(255) NOT NULL,
  batch     INTEGER      NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
  id             SERIAL       NOT NULL
    CONSTRAINT users_pkey
    PRIMARY KEY,
  name           VARCHAR(255) NOT NULL,
  email          VARCHAR(255) NOT NULL
    CONSTRAINT users_email_unique
    UNIQUE,
  password       VARCHAR(255) NOT NULL,
  remember_token VARCHAR(100),
  created_at     TIMESTAMP(0),
  updated_at     TIMESTAMP(0)
);

CREATE TABLE IF NOT EXISTS password_resets
(
  email      VARCHAR(255) NOT NULL,
  token      VARCHAR(255) NOT NULL,
  created_at TIMESTAMP(0)
);

CREATE INDEX IF NOT EXISTS password_resets_email_index
  ON password_resets (email);

CREATE TABLE IF NOT EXISTS client
(
  id         SERIAL NOT NULL
    CONSTRAINT client_pkey
    PRIMARY KEY,
  nom        VARCHAR,
  prenom     VARCHAR,
  pays       VARCHAR,
  mobile     INTEGER,
  email      VARCHAR,
  created_at TIMESTAMP,
  deleted_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS catalogue
(
  id          SERIAL NOT NULL
    CONSTRAINT catalogue_pkey
    PRIMARY KEY,
  numero      INTEGER,
  capacite    INTEGER,
  type        VARCHAR,
  description VARCHAR,
  prix        INTEGER,
  created_at  TIMESTAMP,
  deleted_at  TIMESTAMP,
  updated_at  TIMESTAMP
);

CREATE TABLE IF NOT EXISTS reservations
(
  id           SERIAL NOT NULL
    CONSTRAINT reservations_pkey
    PRIMARY KEY,
  arrivee      DATE,
  depart       DATE,
  prix         INTEGER,
  created_at   TIMESTAMP,
  deleted_at   TIMESTAMP,
  updated_at   TIMESTAMP,
  catalogue_id INTEGER
    CONSTRAINT reservations_catalogue_id_fkey
    REFERENCES catalogue,
  user_id      INTEGER
    CONSTRAINT reservations_user_id_fkey
    REFERENCES client
);



