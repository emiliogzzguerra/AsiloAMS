CREATE DATABASE IF NOT EXISTS sistema_asilo;

USE sistema_asilo;

CREATE TABLE IF NOT EXISTS asilo
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  ciudad VARCHAR(30) NOT NULL,
  calle VARCHAR(30) NOT NULL,
  codigo_postal INT NOT NULL,
  cuartos_disponibles INT NOT NULL,
  camas_disponibles INT NOT NULL,
  telefono VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS paciente
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sexo CHAR NOT NULL,
  fecha_nacimiento VARCHAR(30) NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  ciudad VARCHAR(30),
  calle VARCHAR(30),
  codigo_postal INT,
  sangre VARCHAR(2) NOT NULL,
  numero_cuarto INT,
  numero_cama INT,
  paciente_medicado_manana BOOLEAN NOT NULL DEFAULT 0,
  paciente_medicado_tarde BOOLEAN NOT NULL DEFAULT 0,
  paciente_medicado_noche BOOLEAN NOT NULL DEFAULT 0,
  estatus INT NOT NULL,
  foto VARCHAR(100),
  asilo_id INT NOT NULL,
  FOREIGN KEY (asilo_id) REFERENCES asilo(id)
);

CREATE TABLE IF NOT EXISTS evento
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  fecha VARCHAR(30) NOT NULL,
  enfermera VARCHAR(30),
  descripcion TEXT,
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS familiar
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  parentesco VARCHAR(30),
  telefono VARCHAR(30),
  celular VARCHAR(30),
  incumbencia VARCHAR(30) NOT NULL,
  paciente_id  INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS informacion_emergencia
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  poliza_seguro VARCHAR(30) NOT NULL,
  hospital_preferente VARCHAR(30) NOT NULL,
  fecha_vencimiento_poliza VARCHAR(30),
  comentarios TEXT,
  telefono VARCHAR(30),
  celular VARCHAR(30),
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS enfermedad
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre_enfermedad VARCHAR(30) NOT NULL,
  fecha_inicio VARCHAR(30) NOT NULL,
  fecha_final VARCHAR(30),
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS alergias
(
  paciente_id INT NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  PRIMARY KEY(paciente_id, nombre),
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS receta
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  identificador VARCHAR(30) NOT NULL,
  fecha VARCHAR(30) NOT NULL,
  paciente_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS medicamento
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  tipo VARCHAR(30) NOT NULL,
  paciente_id INT NOT NULL,
  receta_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (receta_id) REFERENCES receta(id)
);

CREATE TABLE IF NOT EXISTS paciente_medicamento
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  cantidad INT NOT NULL, -- 28, 30
  medida VARCHAR(30) NOT NULL, -- Gramos
  fecha_inicio VARCHAR(30) NOT NULL,
  fecha_final VARCHAR(30),
  dosis VARCHAR(100),
  manana BOOLEAN NOT NULL DEFAULT 0,
  tarde BOOLEAN NOT NULL DEFAULT 0,
  noche BOOLEAN NOT NULL DEFAULT 0,
  paciente_id INT NOT NULL,
  medicamento_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (medicamento_id) REFERENCES medicamento(id)
);

CREATE TABLE IF NOT EXISTS padecimiento
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(30),
  descripcion TEXT
);
