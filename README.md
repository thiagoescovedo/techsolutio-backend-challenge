TechSolutio Challenge

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
MySQL Server, 8.0.21 version

SCRIPT:

CREATE DATABASE crudtech;

use crudtech;

CREATE TABLE product (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
supplier VARCHAR(255),
price INT
);


/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
In order to run the project, it may be necessary to change the connection settings found in application.properties
Configurations :

spring.datasource.url=jdbc:mysql://localhost:3306/crudtech
spring.datasource.username=root
spring.datasource.password=tech123

Thiago Escovedo da Costa