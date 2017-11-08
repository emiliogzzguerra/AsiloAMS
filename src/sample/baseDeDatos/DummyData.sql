-- Ejemplo para insertar información a las diferentes tablas:
-- Se debe insertar información en el siguiente orden:
-- 1.  asilo
-- 2.  paciente
-- 3.  evento
-- 4.  familiar
-- 5.  informacion_emergencia
-- 6.  enfermedad
-- 7.  alergias
-- 8.  receta
-- 9.  medicamento
-- 10. paciente_medicamento
-- 11. padecimiento
-- 12. paciente_padecimiento
-- 13. padecimiento
-- 14. incumbencia
-- 15. telefono_asilo
-- 16. telefono_familiar
-- 17. telefono_informacion_emergencia

-- PARA INSERTAR MULTIPLES DATOS A LA MISMA TABLA:

-- insert into ehr (id, blood_type)
-- values
--   (1,'A+'),
--   (2,'B-'),
--   (3,'AB+'),
--   (4,'A+'),
--   (5,'O-'),
--   (6,'O+'),
--   (7,'O-'),
--   (8,'O+'),
--   (9,'O+'),
--   (10,'O+'),
--   (11,'O+'),
--   (12,'O+'),
--   (13,'O+');
/*

insert into asilo (nombre,ciudad,calle,codigo_postal,cuartos_disponibles,camas_disponibles) 
  values
  ("asilo1","Monterrey","Eugenio Gza Sada",64860,20,10);

insert into paciente (sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,numero_cuarto,numero_cama,estatus,asilo_id) 
  values 
  (0,'2015-09-12 8:15',"Emilio","Gonzalez","Monterrey","Centauro #125",64860,"O",1,2,0,1);

insert into evento (fecha,enfermera,descripcion,paciente_id) 
  values 
  ('2015-09-12 8:15',"panchis","Hellowwwwwoeijowiejf",1);

insert into familiar (nombre,apellido,email,paciente_id) 
  values 
  ("nombre","apellido","email",1);

insert into informacion_emergencia (poliza_seguro,hospital_preferente,fecha_vencimiento_poliza,paciente_id,comentarios) 
  values 
  ("poliza_seguro","hospital_preferente",'2015-09-12 8:15',1,"comentarios");

insert into enfermedad (fecha_inicio,fecha_final,paciente_id) 
  values 
  ('2015-09-12 8:15','2015-09-12 8:15',1);

insert into alergias (paciente_id,nombre) 
  values 
  (1,"nombre");

insert into receta (identificador,fecha,paciente_id) 
  values 
  ("folioReceta",'2015-09-12 8:15',1);

insert into medicamento (nombre,tipo,paciente_id,receta_id) 
  values 
  ("nombre","tipo",1,1);

insert into paciente_medicamento (cantidad,medida,fecha_inicio,fecha_final,dosis,paciente_id,medicamento_id) 
  values 
  (30,"gramos",'2015-09-12 8:15','2015-09-12 8:15',"Una vez cada x asodifj",1,1);

insert into padecimiento (nombre) 
  values 
  ("nombre");

insert into paciente_padecimiento (descripcion,paciente_id,padecimiento_id) 
  values 
  ("descripcion",1,1);

insert into incumbencia (incumbencia,familiar_id) 
  values 
  ("incumbencia",1);

insert into telefono_asilo (telefono,asilo_id) 
  values 
  ("telefono",1);

insert into telefono_familiar (telefono,familiar_id) 
  values 
  ("telefono",1);

insert into telefono_informacion_emergencia (telefono,informacion_emergencia_id) 
  values 
  ("telefono",1);

*/

insert into paciente (sexo,fecha_nacimiento,nombre,apellido,ciudad,calle,codigo_postal,sangre,numero_cuarto,numero_cama,estatus,asilo_id) 
  values 
  (0,'2017-04-11 3:15',"Pepe","Gomez","Aguascalientes","FR #125",64340,"O",1,2,0,1),
  (0,'2018-04-21 3:15',"Alejandro","Gonzalez","Monterrey","AE #125",64840,"O",1,2,0,1),
    (0,'2005-02-12 3:15',"David","Gomez","DF","HO #125",64840,"O",1,2,0,1),
      (0,'2015-12-01 3:15',"Marcelo","Ramirez","Cancun","Van #125",64840,"O",1,2,0,1),
        (1,'2014-05-06 3:15',"Maria","Gomez","Tampico","LAE #125",64840,"O",1,2,1,1),
          (1,'2007-02-08 3:15',"Graciela","Garcia","Monterrey","Monte #125",64840,"O",1,2,0,2),
            (1,'2009-02-09 3:15',"Lucia","Gomez","Monterrey","Kili #125",64840,"O",1,1,0,1);
