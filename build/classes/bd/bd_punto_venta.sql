CREATE DATABASE proveedores;

USE proveedores;

CREATE TABLE proveedor( 
    id_proveedor integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(25) NOT NULL,
    apellido_paterno varchar(25) NOT NULL,
    apellido_materno varchar(25) NOT NULL,
    empresa varchar(20) NOT NULL,
    calle varchar(20) NOT NULL,
    colonia varchar(20) NOT NULL,
    numero_exterior varchar(16) NOT NULL,
    telefono varchar(10) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO proveedor (nombre, apellido_paterno, apellido_materno, empresa,calle, colonia, numero_exterior, telefono) VALUES 
('Daniela','Rubiales','Márquez','danimac','lomas de san miguel','Las carreras','12','7711548264');


SELECT * FROM proveedor;