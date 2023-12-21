CREATE TABLE productos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    descripcion VARCHAR(100),
    nombre VARCHAR(40),
    estado VARCHAR(10),
    precio NUMERIC(6, 2)
);