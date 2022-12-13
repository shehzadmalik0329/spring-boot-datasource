CREATE TABLE player (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    ranking INT,
    team VARCHAR(100) NOT NULL,
    age DOUBLE,
    PRIMARY KEY (id)
);