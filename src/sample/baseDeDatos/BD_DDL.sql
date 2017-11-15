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
  camas_disponibles INT NOT NULL
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
  paciente_id  INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS informacion_emergencia
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  poliza_seguro VARCHAR(30) NOT NULL,
  hospital_preferente VARCHAR(30) NOT NULL,
  fecha_vencimiento_poliza DATE,
  paciente_id INT NOT NULL,
  comentarios TEXT,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);

CREATE TABLE IF NOT EXISTS enfermedad
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nombre_enfermedad VARCHAR(30) NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_final DATE,
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
  fecha_inicio DATE NOT NULL,
  fecha_final DATE,
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
  nombre VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS paciente_padecimiento
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  descripcion TEXT,
  paciente_id INT NOT NULL,
  padecimiento_id INT NOT NULL,
  FOREIGN KEY (paciente_id) REFERENCES paciente(id),
  FOREIGN KEY (padecimiento_id) REFERENCES padecimiento(id)
);

CREATE TABLE IF NOT EXISTS incumbencia
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  incumbencia VARCHAR(30) NOT NULL,
  familiar_id INT NOT NULL,
  FOREIGN KEY (familiar_id) REFERENCES familiar(id)
);

CREATE TABLE IF NOT EXISTS telefono_asilo
(
  telefono VARCHAR(30) NOT NULL,
  asilo_id INT NOT NULL,
  PRIMARY KEY(asilo_id, telefono),
  FOREIGN KEY (asilo_id) REFERENCES asilo(id)
);

CREATE TABLE IF NOT EXISTS telefono_familiar
(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  telefono VARCHAR(30) NOT NULL,
  familiar_id INT NOT NULL,
  FOREIGN KEY (familiar_id) REFERENCES familiar(id)
);


CREATE TABLE IF NOT EXISTS telefono_informacion_emergencia
(
  telefono VARCHAR(30) NOT NULL,
  informacion_emergencia_id INT NOT NULL,
  PRIMARY KEY(informacion_emergencia_id, telefono),
  FOREIGN KEY (informacion_emergencia_id) REFERENCES informacion_emergencia(id)
);