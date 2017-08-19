--liquibase formatted sql

--changeset Swaroop:InitialCharadesSchema(dbms:postgresql failOnError:true splitStatements:false)
CREATE TABLE charades (
  charade_id BIGSERIAL PRIMARY KEY,
  charade_type BIGINT,
  charade TEXT
);
--rollback SELECT 1;
