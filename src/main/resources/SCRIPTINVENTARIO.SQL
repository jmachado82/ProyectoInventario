


CREATE DATABASE PROYECTO_INVENTARIO;
USE PROYECTO_INVENTARIO;

SET GLOBAL time_zone = '+2:00';


CREATE TABLE USUARIO(

id MEDIUMINT  NOT NULL AUTO_INCREMENT,
usuario varchar(100),
pwd varchar(100),
idrol MEDIUMINT,
idtipdoc  MEDIUMINT,                 
documento   varchar(50),
direccion  varchar(200) , PRIMARY KEY (id)
);






INSERT INTO USUARIO(
usuario,pwd ,idrol,idtipdoc,documento,direccion)
VALUES ('alex','alex',1,2,'41327698','psje ismodes 227');

