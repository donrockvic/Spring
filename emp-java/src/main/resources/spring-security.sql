CREATE TABLE security.users (
    id SERIAL NOT NULL,
    username VARCHAR(30),
    password VARCHAR(50),
    enabled INT NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE security.authorities (
    id SERIAL NOT NULL,
    username VARCHAR(50),
    authority VARCHAR(50),
    PRIMARY KEY(ID),
    CONSTRAINT fk_username FOREIGN KEY(username) REFERENCES security.users(username)
);