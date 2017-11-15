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

UPDATE paciente SET foto = "/sample/fotos/emilio.png" WHERE id = "2";


insert into asilo (nombre,ciudad,calle,codigo_postal,cuartos_disponibles,camas_disponibles)
  values
  ("asilo1","Monterrey","Eugenio Gza Sada",64860,20,10),
  ("asilo2","San Pedro","Santa Barbara",24553,30,30),
  ("asilo3","Guadalupe","Porfirio Diaz",45456,10,20);


insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1951-01-03 15:27:05', 'Mace', 'Worton', 'Ronda', '616 Myrtle Way', 10698, 'On', 4, 7, false, false, true, 2, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1954-06-15 19:28:48', 'Tori', 'Bonhan', 'Czarnowąsy', '2294 Hansons Hill', 62785, 'Ap', 4, 6, false, false, false, 1, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1944-02-29 08:36:16', 'Kristy', 'Duffree', 'Müllendorf', '2578 Oneill Alley', 36349, 'ABp', 1, 8, false, false, false, 2, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1947-07-06 14:56:08', 'Verney', 'Wimlett', 'Bulog', '68 Heath Parkway', 25596, 'ABn', 3, 3, false, false, true, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1951-04-09 04:10:44', 'Aylmer', 'Erratt', 'Capas', '12458 Green Ridge Center', 43779, 'ABn', 4, 2, true, true, false, 2, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1945-12-17 18:47:55', 'Micheline', 'Gemmell', 'Fastovetskaya', '5910 Meadow Valley Trail', 36537, 'Op', 2, 3, true, false, false, 2, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1956-02-24 16:21:18', 'Mick', 'Shekle', 'Krajan Pocangan', '4360 Westport Point', 52160, 'Op', 1, 3, false, true, false, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1948-05-26 14:53:01', 'Valentina', 'Benoy', 'San Rafael', '54343 Canary Circle', 46682, 'ABn', 3, 7, false, false, true, 2, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1957-09-14 19:08:57', 'Caitlin', 'Apfelmann', 'L''Aigle', '3 3rd Terrace', 40945, 'On', 2, 3, false, true, false, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1944-02-20 22:49:10', 'Lambert', 'Tayspell', 'Fudian', '28 Lukken Avenue', 49704, 'ABp', 1, 1, false, true, true, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1954-01-09 00:22:10', 'Karia', 'O''Rowane', 'Saint-Jean-de-Luz', '3 Roxbury Avenue', 54501, 'ABp', 4, 3, false, true, true, 2, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1943-03-26 18:22:57', 'Merwyn', 'Nassau', 'Esquel', '5 2nd Crossing', 82453, 'Op', 4, 4, true, false, true, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1947-08-08 06:30:48', 'Faina', 'Keith', 'Xingxi', '2449 Spohn Way', 44367, 'On', 2, 1, false, false, false, 2, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1953-05-11 01:57:16', 'Elmer', 'Sunderland', 'Dal’nerechensk', '410 Melody Park', 47505, 'An', 4, 7, false, true, false, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1944-04-27 14:27:22', 'Carlie', 'Sorby', 'Guanxi', '88 Linden Center', 64232, 'Bp', 3, 7, false, false, true, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1955-05-24 06:18:42', 'Debee', 'Paz', 'Stockholm', '40725 American Place', 36664, 'Ap', 1, 7, false, true, true, 1, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1959-12-15 10:38:11', 'Gabrila', 'Moreton', 'Portland', '94 Fallview Avenue', 91671, 'Op', 3, 2, true, true, true, 2, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1952-06-30 22:06:17', 'Lorant', 'Lesaunier', 'Agdangan', '0224 Canary Pass', 38093, 'ABp', 3, 8, false, false, true, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1956-08-04 06:24:29', 'Byram', 'Gecks', 'Krosno', '75615 Doe Crossing Avenue', 73741, 'On', 3, 6, false, true, false, 1, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1943-11-10 11:50:41', 'Farlay', 'Shynn', 'Thívai', '4 Schurz Circle', 76837, 'Bp', 1, 6, true, false, true, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1955-03-03 22:28:12', 'Tamqrah', 'Jikovsky', 'Aghavnadzor', '75 Banding Court', 48184, 'An', 2, 4, true, true, false, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1943-02-18 21:04:33', 'Ardenia', 'Manhare', 'Santa Bárbara de Padrões', '0 Buena Vista Pass', 26507, 'ABn', 3, 1, false, true, false, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1952-11-07 15:00:59', 'Marlene', 'Verring', 'Altkirch', '514 Badeau Circle', 11573, 'ABp', 2, 7, true, true, false, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1954-10-13 07:56:11', 'Carlynne', 'Burges', 'Clarin', '360 Morningstar Point', 51424, 'Op', 3, 4, false, false, true, 1, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1948-10-25 08:22:34', 'Adelle', 'Spoward', 'Krajan Langenharjo', '25 Sachs Terrace', 87921, 'Ap', 2, 7, false, true, false, 2, 3);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1942-09-27 04:54:04', 'Lock', 'Lovie', 'Salvacion', '4 Hoard Crossing', 63392, 'Bn', 1, 4, true, true, true, 2, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1952-10-25 05:09:19', 'Rebekah', 'Le Marquis', 'Brikama', '2 Derek Court', 59192, 'ABn', 4, 4, true, true, false, 2, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (1, '1952-01-11 10:05:25', 'Lorette', 'Havers', 'Tambaksumur', '421 Lake View Road', 13454, 'ABp', 2, 5, false, true, true, 1, 1);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1957-12-11 07:07:46', 'Waite', 'Bellino', 'Huaribamba', '023 Hanson Point', 65751, 'Bn', 1, 4, false, false, false, 2, 2);
insert into paciente (sexo, fecha_nacimiento, nombre, apellido, ciudad, calle, codigo_postal, sangre, numero_cuarto, numero_cama, paciente_medicado_manana, paciente_medicado_tarde, paciente_medicado_noche, Estatus, asilo_id) values (2, '1949-07-18 04:14:26', 'Derick', 'Gonsalvez', 'Mporokoso', '6120 Springview Drive', 49369, 'On', 4, 1, true, false, true, 2, 2);






insert into evento (fecha,enfermera,descripcion,paciente_id)
  values
  ('2014-09-12 8:55',"panchis","Hellowwwwwoeijowiejf",1),
  ('2013-06-11 5:35',"Daniel","Hellowwwwwoeijowiejf",4),
  ('2012-10-02 6:55',"Juan","Hellowwwwwoeijowiejf",5),
  ('2011-12-05 7:25',"Marcela","Hellowwwwwoeijowiejf",6),
  ('2013-2-07 8:05',"Daniel","HellowwwwwoeijowiejDJM",10);

insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Elnar', 'Pretley', 'epretley0@soundcloud.com','8112886677','81232555','reorden', 1);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Briny', 'Deakes', 'bdeakes1@lulu.com','8112886677','81232555','reorden', 2);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Perry', 'Gai', 'pgai2@yellowbook.com','8112886677','81232555','reorden', 2);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Freemon', 'Blaver', 'fblaver3@w3.org','8112886677','81232555','reorden', 4);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Kristian', 'Allbones', 'kallbones4@techcrunch.com','8112886677','81232555','reorden', 5);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Roch', 'Lineen', 'rlineen5@symantec.com','8112886677','81232555','reorden', 6);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Gerianne', 'Measham', 'gmeasham6@ucla.edu','8112886677','81232555','reorden', 7);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Vally', 'Ruit', 'vruit7@squarespace.com','8112886677','81232555','reorden', 8);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Abby', 'Youens', 'ayouens8@google.pl','8112886677','81232555','reorden', 9);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Dita', 'Dory', 'ddory9@php.net','8112886677','81232555','reorden', 10);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Cobbie', 'Frowen', 'cfrowena@4shared.com','8112886677','81232555','reorden', 11);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Glenine', 'Luesley', 'gluesleyb@mayoclinic.com','8112886677','81232555','reorden', 12);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Jandy', 'Schultheiss', 'jschultheissc@blogspot.com','8112886677','81232555','reorden', 13);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Katherine', 'Bohler', 'kbohlerd@last.fm','8112886677','81232555','reorden', 14);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Candie', 'Flynn', 'cflynne@deliciousdays.com','8112886677','81232555','reorden', 15);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Arnuad', 'Clacson', 'aclacsonf@house.gov','8112886677','81232555','reorden', 16);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Glenda', 'McLice', 'gmcliceg@blog.com','8112886677','81232555','reorden', 17);
insert into familiar (nombre, apellido, email, telefono, celular, incumbencia, paciente_id) values ('Frannie', 'Goose', 'fgooseh@is.gd','8112886677','81232555','reorden', 18);

insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('16252-573', 'Dooley-Morissette', '2016-11-19 00:20:19', 1, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('0245-0420', 'Dach-McKenzie', '2016-12-13 16:58:53', 2, 'Nulla ac enim.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('52125-282', 'Spinka-Ferry', '2017-09-20 21:06:44', 3, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('50268-220', 'Pfannerstill-Mraz', '2017-09-10 20:08:12', 4, 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('98132-738', 'Vandervort, Fay and Klocko', '2017-06-18 21:39:08', 5, 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('54575-357', 'Konopelski LLC', '2017-10-14 12:30:00', 6, 'Proin eu mi. Nulla ac enim.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('64778-1379', 'Hintz and Sons', '2017-04-29 20:40:44', 7, 'Suspendisse ornare consequat lectus.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('65954-536', 'Conn-Padberg', '2017-04-03 21:39:10', 8, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('49288-0359', 'Graham, Cremin and Bins', '2017-04-27 00:28:12', 9, 'Duis bibendum.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('64205-655', 'Senger, Donnelly and Feil', '2017-05-24 03:49:50', 10, 'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('13537-135', 'Kunze-Towne', '2017-01-23 20:09:10', 11, 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('64117-146', 'Kautzer, Crooks and Von', '2017-02-20 23:21:27', 12, 'Vivamus tortor.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('76237-202', 'Mraz, Stokes and Padberg', '2017-02-10 04:42:06', 13, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('55154-9428', 'Kerluke-Kohler', '2017-08-29 09:51:20', 14, 'Curabitur at ipsum ac tellus semper interdum.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('43742-0437', 'Prosacco-Bayer', '2017-08-13 12:47:57', 15, 'Nullam varius. Nulla facilisi.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('0869-0318', 'Senger LLC', '2017-03-30 08:22:28', 16, 'Morbi non quam nec dui luctus rutrum. Nulla tellus.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('41167-1001', 'Sipes, Rodriguez and Ernser', '2017-04-08 09:32:49', 17, 'Morbi porttitor lorem id ligula.');
insert into informacion_emergencia (poliza_seguro, hospital_preferente, fecha_vencimiento_poliza, paciente_id, comentarios) values ('52959-579', 'Beier, Okuneva and Jacobs', '2017-04-17 12:56:47', 18, 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.');


insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-06-22 09:00:58', '2014-09-09 03:16:18', 1);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-11-16 17:48:49', '2016-03-03 23:30:53', 2);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2014-07-01 09:51:20', '2014-10-19 10:31:46', 3);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2014-09-29 11:07:01', '2015-11-27 00:57:28', 4);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-08-26 06:12:39', '2013-10-25 14:55:27', 5);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-02-06 04:21:25', '2013-11-16 11:06:35', 6);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-04-10 22:02:52', '2016-07-09 10:40:03', 7);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2014-01-07 06:05:58', '2015-08-10 21:25:50', 8);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2017-01-17 20:17:55', '2014-03-25 07:05:19', 9);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2016-03-29 17:03:47', '2017-02-03 03:00:46', 10);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2017-02-09 04:16:28', '2016-09-16 07:55:52', 11);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2015-05-23 00:59:19', '2015-12-13 09:35:01', 12);
insert into enfermedad (nombre_enfermedad, fecha_inicio, fecha_final, paciente_id) values ('hellow','2014-01-11 15:03:47', '2014-08-05 19:04:16', 13);

insert into alergias (paciente_id, nombre) values (1, 'Ash White');
insert into alergias (paciente_id, nombre) values (2, 'Lentil');
insert into alergias (paciente_id, nombre) values (3, 'TITANIUM DIOXIDE');
insert into alergias (paciente_id, nombre) values (4, 'Acetaminophen, Dextromethorphan Hydrobromide, Guaifenesin, Phenylephrine Hydrochloride');
insert into alergias (paciente_id, nombre) values (5, 'ibuprofen');
insert into alergias (paciente_id, nombre) values (6, 'Diltiazem Hydrochloride');
insert into alergias (paciente_id, nombre) values (7, 'Melissa Chamomilla');
insert into alergias (paciente_id, nombre) values (8, 'PHENTERMINE HYDROCHLORIDE');
insert into alergias (paciente_id, nombre) values (9, 'not applicable');
insert into alergias (paciente_id, nombre) values (10, 'clindamycin hydrochloride');
insert into alergias (paciente_id, nombre) values (11, 'Glycerin');
insert into alergias (paciente_id, nombre) values (12, 'Diphenhydramine HCl, Phenylephrine HCl');
insert into alergias (paciente_id, nombre) values (13, 'botrytis cinerea');

insert into receta (identificador, fecha, paciente_id) values ('0268-6210', '2016-08-17 14:14:09', 1);
insert into receta (identificador, fecha, paciente_id) values ('61328-001', '2016-10-13 23:39:05', 2);
insert into receta (identificador, fecha, paciente_id) values ('49035-949', '2016-06-19 22:42:10', 3);
insert into receta (identificador, fecha, paciente_id) values ('43269-758', '2016-10-06 00:22:44', 4);
insert into receta (identificador, fecha, paciente_id) values ('49349-481', '2016-03-18 16:16:02', 5);
insert into receta (identificador, fecha, paciente_id) values ('60681-0104', '2016-04-18 19:12:30', 6);
insert into receta (identificador, fecha, paciente_id) values ('0722-6921', '2016-07-15 05:16:33', 7);
insert into receta (identificador, fecha, paciente_id) values ('37000-018', '2015-12-10 17:24:53', 8);
insert into receta (identificador, fecha, paciente_id) values ('49349-757', '2016-06-10 23:24:25', 9);
insert into receta (identificador, fecha, paciente_id) values ('0924-0166', '2016-10-30 20:56:56', 10);
insert into receta (identificador, fecha, paciente_id) values ('40002-003', '2015-11-18 12:58:00', 11);
insert into receta (identificador, fecha, paciente_id) values ('0067-6238', '2015-12-11 11:21:38', 12);
insert into receta (identificador, fecha, paciente_id) values ('0173-0839', '2015-11-23 12:24:07', 13);
insert into receta (identificador, fecha, paciente_id) values ('59779-556', '2016-03-10 10:35:54', 14);
insert into receta (identificador, fecha, paciente_id) values ('59779-536', '2016-09-28 08:52:12', 15);
insert into receta (identificador, fecha, paciente_id) values ('68084-721', '2016-05-16 09:17:43', 16);
insert into receta (identificador, fecha, paciente_id) values ('11489-056', '2015-12-13 08:54:08', 17);
insert into receta (identificador, fecha, paciente_id) values ('37205-429', '2016-10-14 14:10:08', 18);

insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Amoxicillin', 'pastillas', 1, 1);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Head and Shoulders', 'liquido', 2, 2);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Pollens - Weeds and Garden Plants, Plantain, English Plantago lanceolata', 'liquido', 3, 3);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Glipizide and Metformin Hydrochloride', 'injeccion', 4, 4);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('DIPHENHYDRAMINE HYDROCHLORIDE', 'pastillas', 5, 5);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Male Balance', 'liquido', 6, 6);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Bactrim DS', 'liquido', 7, 7);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('VESIcare', 'pastillas', 8, 8);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Malathion', 'injeccion', 9, 9);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('MBM 10 Stomach', 'liquido', 10, 10);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Clario Ultra Blue Antibacterial Foaming Skin Cleanser', 'pastillas', 11, 11);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Spry Xylitol Cinnamon', 'injeccion', 12, 12);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('mapap', 'injeccion', 13, 13);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('NU-DERM SYSTEM NORMAL-DRY', 'liquido', 14, 14);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Rx Act nasal four', 'injeccion', 15, 15);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('SUPER BB', 'pastillas', 16, 16);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Prolensa', 'liquido', 17, 17);
insert into medicamento (nombre, tipo, paciente_id, receta_id) values ('Camilia', 'liquido', 18, 18);

insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (10, 'mililitros', '2014-10-21 12:01:20', '2017-06-19 18:29:36', 'Aliquam erat volutpat. In congue.', 1, 1);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (2, 'gramos', '2016-03-25 11:36:55', '2015-03-13 11:40:41', 'Nam tristique tortor eu pede.', 2, 2);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (8, 'gramos', '2016-03-28 03:57:37', '2015-11-01 00:42:39', 'Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros.', 3, 3);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (2, 'mililitros', '2015-05-29 21:54:54', '2017-10-21 06:56:58', 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', 4, 4);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (15, 'mililitros', '2014-08-11 05:13:39', '2015-02-09 16:08:01', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 5, 5);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (4, 'gramos', '2017-09-01 21:12:32', '2016-10-24 01:03:50', 'Phasellus id sapien in sapien iaculis congue.', 6, 6);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (15, 'gramos', '2017-03-19 10:50:55', '2015-09-05 02:11:57', 'Duis ac nibh.', 7, 7);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (14, 'gramos', '2017-06-07 11:41:47', '2014-11-29 02:49:17', 'Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', 8, 8);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (2, 'mililitros', '2015-04-06 10:14:18', '2017-01-14 10:23:25', 'Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum.', 9, 9);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (2, 'gramos', '2015-07-05 14:24:26', '2015-02-18 00:44:12', 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 10, 10);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (8, 'gramos', '2016-02-11 10:35:23', '2015-03-29 22:07:51', 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', 11, 11);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (8, 'mililitros', '2016-09-10 21:02:40', '2016-06-27 10:06:04', 'Maecenas pulvinar lobortis est.', 12, 12);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (10, 'gramos', '2017-10-06 02:01:47', '2017-04-14 07:21:50', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', 13, 13);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (5, 'gramos', '2014-05-15 04:32:00', '2017-02-12 21:59:00', 'Etiam faucibus cursus urna.', 14, 14);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (8, 'mililitros', '2015-12-29 10:23:59', '2016-06-28 03:22:31', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 15, 15);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (7, 'mililitros', '2014-12-02 05:58:54', '2015-11-20 16:52:55', 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 16, 16);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (6, 'mililitros', '2015-11-14 23:55:13', '2016-06-02 14:14:37', 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 17, 17);
insert into paciente_medicamento (cantidad, medida, fecha_inicio, fecha_final, dosis, paciente_id, medicamento_id) values (14, 'mililitros', '2017-02-23 14:39:11', '2017-10-26 11:20:47', 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', 18, 18);



insert into padecimiento (nombre) values ('Isoodon obesulus');
insert into padecimiento (nombre) values ('Gyps bengalensis');
insert into padecimiento (nombre) values ('Oxybelis sp.');
insert into padecimiento (nombre) values ('Butorides striatus');
insert into padecimiento (nombre) values ('Alectura lathami');
insert into padecimiento (nombre) values ('Mazama americana');
insert into padecimiento (nombre) values ('Felis yagouaroundi');
insert into padecimiento (nombre) values ('Nyctereutes procyonoides');
insert into padecimiento (nombre) values ('Oncorhynchus nerka');
insert into padecimiento (nombre) values ('Panthera tigris');
insert into padecimiento (nombre) values ('Threskionis aethiopicus');
insert into padecimiento (nombre) values ('Martes americana');
insert into padecimiento (nombre) values ('Trichoglossus haematodus moluccanus');
insert into padecimiento (nombre) values ('Corvus brachyrhynchos');
insert into padecimiento (nombre) values ('Crocodylus niloticus');
insert into padecimiento (nombre) values ('Nectarinia chalybea');
insert into padecimiento (nombre) values ('Paradoxurus hermaphroditus');
insert into padecimiento (nombre) values ('Funambulus pennati');

insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 1, 1);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 2, 2);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 3, 3);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.', 4, 4);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 5, 5);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 6, 6);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Integer ac neque. Duis bibendum.', 7, 7);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor.', 8, 8);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Etiam faucibus cursus urna.', 9, 9);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Phasellus sit amet erat.', 10, 10);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Suspendisse potenti.', 11, 11);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 12, 12);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.', 13, 13);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Praesent id massa id nisl venenatis lacinia.', 14, 14);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 15, 15);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Nulla ut erat id mauris vulputate elementum.', 16, 16);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Nulla nisl.', 17, 17);
insert into paciente_padecimiento (descripcion, paciente_id, padecimiento_id) values ('Nunc rhoncus dui vel sem.', 18, 18);

insert into incumbencia (incumbencia, familiar_id) values ('Morbi porttitor lorem id ligula.', 1);
insert into incumbencia (incumbencia, familiar_id) values ('Aliquam quis turpis eget elit sodales scelerisque.', 2);
insert into incumbencia (incumbencia, familiar_id) values ('Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', 3);
insert into incumbencia (incumbencia, familiar_id) values ('Praesent lectus.', 4);
insert into incumbencia (incumbencia, familiar_id) values ('Duis bibendum.', 5);
insert into incumbencia (incumbencia, familiar_id) values ('Mauris ullamcorper purus sit amet nulla.', 6);
insert into incumbencia (incumbencia, familiar_id) values ('Mauris lacinia sapien quis libero.', 7);
insert into incumbencia (incumbencia, familiar_id) values ('In quis justo.', 8);
insert into incumbencia (incumbencia, familiar_id) values ('Duis consequat dui nec nisi volutpat eleifend.', 9);
insert into incumbencia (incumbencia, familiar_id) values ('Etiam pretium iaculis justo.', 10);
insert into incumbencia (incumbencia, familiar_id) values ('Sed vel enim sit amet nunc viverra dapibus.', 11);
insert into incumbencia (incumbencia, familiar_id) values ('Nam tristique tortor eu pede.', 12);
insert into incumbencia (incumbencia, familiar_id) values ('Proin eu mi.', 13);
insert into incumbencia (incumbencia, familiar_id) values ('Donec posuere metus vitae ipsum.', 14);
insert into incumbencia (incumbencia, familiar_id) values ('Maecenas rhoncus aliquam lacus.', 15);
insert into incumbencia (incumbencia, familiar_id) values ('Integer non velit.', 16);
insert into incumbencia (incumbencia, familiar_id) values ('In est risus, auctor sed, tristique in, tempus sit amet, sem.', 17);
insert into incumbencia (incumbencia, familiar_id) values ('Duis bibendum.', 18);

insert into telefono_asilo (telefono, asilo_id) values ('450-647-6257', 3);
insert into telefono_asilo (telefono, asilo_id) values ('173-458-8230', 2);
insert into telefono_asilo (telefono, asilo_id) values ('532-103-8483', 1);


insert into telefono_familiar (telefono, familiar_id) values ('633-239-1796', 1);
insert into telefono_familiar (telefono, familiar_id) values ('652-367-8294', 2);
insert into telefono_familiar (telefono, familiar_id) values ('827-264-9588', 3);
insert into telefono_familiar (telefono, familiar_id) values ('669-591-8768', 4);
insert into telefono_familiar (telefono, familiar_id) values ('581-165-6621', 5);
insert into telefono_familiar (telefono, familiar_id) values ('692-406-0260', 6);
insert into telefono_familiar (telefono, familiar_id) values ('682-222-0193', 7);
insert into telefono_familiar (telefono, familiar_id) values ('225-614-1036', 8);
insert into telefono_familiar (telefono, familiar_id) values ('723-575-3411', 9);
insert into telefono_familiar (telefono, familiar_id) values ('402-798-8087', 10);
insert into telefono_familiar (telefono, familiar_id) values ('384-872-4336', 11);
insert into telefono_familiar (telefono, familiar_id) values ('703-441-3286', 12);
insert into telefono_familiar (telefono, familiar_id) values ('803-351-1229', 13);
insert into telefono_familiar (telefono, familiar_id) values ('595-728-9162', 14);
insert into telefono_familiar (telefono, familiar_id) values ('272-413-1885', 15);
insert into telefono_familiar (telefono, familiar_id) values ('649-116-4795', 16);
insert into telefono_familiar (telefono, familiar_id) values ('512-399-9932', 17);
insert into telefono_familiar (telefono, familiar_id) values ('532-546-7974', 18);

insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('827-224-0039', 1);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('375-421-7358', 2);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('868-810-1373', 3);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('810-533-6721', 4);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('838-506-2483', 5);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('709-747-5921', 6);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('654-778-9458', 7);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('384-225-5653', 8);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('104-607-0416', 9);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('159-227-1226', 10);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('574-429-0383', 11);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('879-737-9390', 12);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('513-773-5519', 13);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('682-673-5086', 14);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('591-488-6755', 15);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('145-815-2169', 16);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('937-420-7629', 17);
insert into telefono_informacion_emergencia (telefono, informacion_emergencia_id) values ('728-250-4693', 18);
