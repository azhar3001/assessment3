#Script to create table
CREATE TABLE Student (
    id INT IDENTITY(1,1) NOT NULL, -- AUTO_INCREMENT equivalent in MSSQL
    name VARCHAR(45) NOT NULL,
    address VARCHAR(45) NULL, -- DEFAULT NULL is implicit in MSSQL
    gender CHAR(1) NOT NULL DEFAULT 'M',
    dob DATETIME NULL,
    email VARCHAR(45) NULL,
    mobile VARCHAR(15) NULL,
    phone VARCHAR(15) NULL,
    CONSTRAINT PK_Student PRIMARY KEY (id) -- Explicit primary key definition
);

#Swagger file
http://localhost:8080/swagger-ui/index.html#/
