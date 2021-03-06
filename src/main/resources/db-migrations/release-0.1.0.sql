--liquibase formatted sql

--changeset Swaroop:MovieNamesTable(dbms:postgresql failOnError:true splitStatements:false)
CREATE TABLE movie_titles (
  id BIGSERIAL PRIMARY KEY,
  title TEXT NOT NULL,
  dubtitle TEXT,
  director TEXT,
  crew TEXT,
  year INTEGER
);

ALTER TABLE movie_titles ADD CONSTRAINT title_year UNIQUE (title, year);
--rollback SELECT 1;
