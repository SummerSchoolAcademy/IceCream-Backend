DROP TABLE IF EXISTS test;

CREATE TABLE test (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    input VARCHAR(250) NOT NULL
);

INSERT INTO test (input) VALUES ('This is a test input');