CREATE SCHEMA LAB5;

USE LAB5;

CREATE TABLE rol (
    idrol INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    dni CHAR(8) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    edad INT NOT NULL,
    pwd VARCHAR(100) NOT NULL,
    activo TINYINT NOT NULL DEFAULT 1,
    idrol INT NOT NULL,
    FOREIGN KEY (idrol) REFERENCES rol(idrol)
);

describe usuario;
describe rol;

INSERT INTO rol (idrol, nombre) VALUES (1,'USER');
INSERT INTO rol (idrol, nombre) VALUES (2,'ADMIN');
SELECT * FROM rol;


INSERT INTO usuario (nombre, apellido, dni, email, edad, pwd, activo, idrol)
VALUES ('Juan', 'Ulloa', '76608126', 'juan@gmail.com', 21, 'contra', 1, 1);

SELECT * FROM usuario;