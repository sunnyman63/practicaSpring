CREATE TABLE RRHH_PERSONA (
  ID BIGINT auto_increment PRIMARY KEY,
  NOMBRE VARCHAR(100) NOT NULL,
  APELLIDOS VARCHAR(100) NOT NULL,
  FECHA_NACIMIENTO DATE NOT NULL,
  TELEFONO VARCHAR(10) NULL,
  DIRECCION VARCHAR(100) NULL,
  CIUDAD VARCHAR(50) NULL,
  PROVINCIA VARCHAR(50) NULL,
  CESION_DATOS BIT DEFAULT 0,
  VALORACION_SERVICIO INTEGER NOT NULL,
  VERSION INTEGER NOT NULL
);