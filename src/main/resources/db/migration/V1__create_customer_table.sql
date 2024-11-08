CREATE TABLE customer (
    id BIGSERIAL PRIMARY KEY,
    version BIGINT NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL
);