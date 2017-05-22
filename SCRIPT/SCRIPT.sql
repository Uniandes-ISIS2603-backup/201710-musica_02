/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  af.olivares10
 * Created: 03-abr-2017
 */
DELETE FROM ENTRADAENTITY;

DELETE FROM FUNCIONENTITY_ARTISTAENTITY;
DELETE FROM REVIEWENTITY;
DELETE FROM CLIENTEENTITY;

DELETE FROM CANCIONENTITY;
DELETE FROM DISCOENTITY;
DELETE FROM ARTISTAENTITY;
DELETE FROM FUNCIONENTITY;
DELETE FROM VENUEENTITY;
DELETE FROM FESTIVALENTITY;
DELETE FROM CIUDADENTITY;
DELETE FROM GENEROENTITY;

insert into CIUDADENTITY (id, name) values (1001, 'Goim');
insert into CIUDADENTITY (id, name) values (1002, 'Kungsbacka');
insert into CIUDADENTITY (id, name) values (1003, 'Musina');
insert into CIUDADENTITY (id, name) values (1004, 'Frei Paulo');
insert into CIUDADENTITY (id, name) values (1005, 'Jiumen');

insert into GENEROENTITY (ID,NOMBRE) values (1001, 'Rock');
insert into GENEROENTITY (ID,NOMBRE) values (1002, 'Salsa');
insert into GENEROENTITY (ID,NOMBRE) values (1003, 'Reggaeton');
insert into GENEROENTITY (ID,NOMBRE) values (1004, 'Reggae');
insert into GENEROENTITY (ID,NOMBRE) values (1005, 'HipHop');
insert into GENEROENTITY (ID,NOMBRE) values (1006, 'Electronica');
insert into GENEROENTITY (ID,NOMBRE) values (1007, 'Mixto');


insert into FESTIVALENTITY (ID, FECHAFIN, FECHAINICIO, NOMBRE, CIUDADENTITY_ID,IMAGEN,GENERO_ID) values (1001, '2017-12-01', '2017-01-01', 'Lollapalooza' , 1001,'https://consequenceofsound.files.wordpress.com/2016/01/lollapalooza-2015.png',1001);
insert into FESTIVALENTITY (ID, FECHAFIN, FECHAINICIO, NOMBRE, CIUDADENTITY_ID,IMAGEN,GENERO_ID) values (1002, '2017-12-01', '2017-01-01', 'Salsa al parque', 1002,'http://4.bp.blogspot.com/-1XOb4FGcvIo/UcuVi_oEu9I/AAAAAAAAErg/i3VhHH_g6ig/s1600/festival+salsa+al+parque.gif',1002);
insert into FESTIVALENTITY (ID, FECHAFIN, FECHAINICIO, NOMBRE, CIUDADENTITY_ID,IMAGEN,GENERO_ID) values (1003, '2017-12-01', '2017-01-01', 'Woodstock', 1003,'https://pbs.twimg.com/profile_images/619207497883197440/j3kmzWJN.jpg',1003);
insert into FESTIVALENTITY (ID, FECHAFIN, FECHAINICIO, NOMBRE, CIUDADENTITY_ID,IMAGEN,GENERO_ID) values (1004, '2017-12-01', '2017-01-01', 'Glastonburry', 1004,'http://cdn.glastonburyfestivals.co.uk/wp-content/themes/glasto/assets/gfx/glastonbury_festival_generic.png',1005);
insert into FESTIVALENTITY (ID, FECHAFIN, FECHAINICIO, NOMBRE, CIUDADENTITY_ID,IMAGEN,GENERO_ID) values (1005, '2017-12-01', '2017-01-01', 'Coachella', 1005,'https://s-media-cache-ak0.pinimg.com/originals/90/47/3b/90473b91f75571e71468afcdb8fb42f5.jpg',1006);

insert into VENUEENTITY (ID, CAPACIDADMAX, DIRECCION, NOMBRE, TIPO, CIUDADENTITY_ID, FESTIVALENTITY_ID, IMAGEN, MAPA) values (1001, 201, '309 Claremont Court', 'Elmside', 'ABIERTO', 1001, 1001, 'https://s-media-cache-ak0.pinimg.com/736x/bd/ce/8e/bdce8e9a495c2e7548c13c39af9d1d62.jpg', 'http://www.garuyo.com/web/media/images/images/mapaforo2.jpg');
insert into VENUEENTITY (ID, CAPACIDADMAX, DIRECCION, NOMBRE, TIPO, CIUDADENTITY_ID, FESTIVALENTITY_ID, IMAGEN, MAPA) values (1002, 202, '60114 Fordem Drive', 'Carpenter', 'CUBIERTO', 1002, 1002, 'http://dceven.ufsc.br/files/2011/02/auditorio2_jpg.jpg', 'http://rutasymapas.com/wp-content/uploads/2012/06/mapa-%C3%B3pera-par%C3%ADs.gif');
insert into VENUEENTITY (ID, CAPACIDADMAX, DIRECCION, NOMBRE, TIPO, CIUDADENTITY_ID, FESTIVALENTITY_ID, IMAGEN, MAPA) values (1003, 203, '9226 Namekagon Parkway', 'Bay', 'CUBIERTO', 1003, 1003, 'http://www.estructurasvt.com.ar/altarimasogradasi/alquileractosmas.jpg', 'http://2011.fidae.gub.uy/uploads/salas/teatro-solis.jpg');
insert into VENUEENTITY (ID, CAPACIDADMAX, DIRECCION, NOMBRE, TIPO, CIUDADENTITY_ID, FESTIVALENTITY_ID, IMAGEN, MAPA) values (1004, 204, '63077 Fair Oaks Hill', 'Randy', 'CUBIERTO', 1004, 1004, 'http://www.eargasmweb.com/wp-content/uploads/2014/04/Ambiente-Escenario-Primavera-The-Breeders-01-Dani-Canto.jpg', 'http://teatrodelbarrio.com/wp-content/uploads/2013/11/mapa.jpg');
insert into VENUEENTITY (ID, CAPACIDADMAX, DIRECCION, NOMBRE, TIPO, CIUDADENTITY_ID, FESTIVALENTITY_ID, IMAGEN, MAPA) values (1005, 205, '47 Welch Terrace', 'Mockingbird', 'ABIERTO', 1005, 1005, 'https://s3-sa-east-1.amazonaws.com/wwwmercadoec/items/sonido-y-amplificacin-profesional-djs-discomvil-tarimas-escenarios-para-eventos-0-0-1.jpg', 'http://www.nancy-tunon.com/rcs_gene/extra/Mapa.png');

insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1001, 110, 201, 1, '2017-04-21', 1001, 1001, 'http://thisnewband.com/wp-content/uploads/2015/09/IMG_7540.jpg');
insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1002, 120, 202, 1, '2017-04-21', 1002, 1002, 'http://thisnewband.com/wp-content/uploads/2015/09/IMG_7540.jpg');
insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1003, 130, 203, 0, '2017-04-21', 1003, 1003, 'http://img2.thejournal.ie/inline/1334434/original/?width=630&version=1334434');
insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1004, 140, 204, 0, '2017-04-21', 1004, 1004, 'http://hot94.fm/wp-content/uploads/2016/12/Rawayana730.gif');
insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1005, 150, 205, 0, '2017-04-21', 1005, 1005, 'https://s-media-cache-ak0.pinimg.com/564x/0b/1b/3f/0b1b3f8c262603c0ed91073356963fa6.jpg');
insert into FUNCIONENTITY (ID, DURACION, ENTRADASDISPONIBLES, ESPAGA, FECHA, FESTIVALENTITY_ID, VENUEENTITY_ID, IMAGEN) values (1006, 110, 201, 1, '2017-05-21', 1001, 1001, 'http://edmchicago.com/wp-content/uploads/2016/03/TC-Lollapalooza-1366x800.jpg');

insert into ARTISTAENTITY (ID, GENERO_ID, NOMBRE, TRAYECTORIA, IMAGEN) values (1001, 1001, 'Led zepellin', 'monetize magnetic relationships', 'http://img.wennermedia.com/social/led-zeppelin-bbc-album-review-fb72cd94-408c-4600-a911-f5a4f5d4730c.jpg');
insert into ARTISTAENTITY (ID, GENERO_ID, NOMBRE, TRAYECTORIA, IMAGEN) values (1002, 1002, 'Skrillex',  'expedite granular technologies', 'http://www.revolution935.com//wp-content/uploads/2016/01/skrillex-headshot.jpg');
insert into ARTISTAENTITY (ID, GENERO_ID, NOMBRE, TRAYECTORIA, IMAGEN) values (1003, 1003, 'DeadMau5',   'mesh enterprise networks', 'http://www.billboard.com/files/media/deadmau5-press-photo-2016-billboard-1548.jpg');
insert into ARTISTAENTITY (ID, GENERO_ID, NOMBRE, TRAYECTORIA, IMAGEN) values (1004, 1004, 'Dread Mar I',   'enhance e-business bandwidth', 'https://pbs.twimg.com/profile_images/800565248650571776/BhndJ8Rr.jpg');
insert into ARTISTAENTITY (ID, GENERO_ID, NOMBRE, TRAYECTORIA, IMAGEN) values (1005, 1005, 'Knife Party',   'whiteboard interactive infomediaries', 'https://lh3.googleusercontent.com/-BhJrGzQLCa8/AAAAAAAAAAI/AAAAAAAAAA0/2Gn2_MDL1HM/photo.jpg');

insert into CLIENTEENTITY (ID,USUARIO, ABONO, DOCUMENTO, NOMBRE, REGISTRADOBLOG, TIPODOCUMENTO) values (1,'1001', 1, '1001', 'Carlos', 0, 'TI');
insert into CLIENTEENTITY (ID,USUARIO, ABONO, DOCUMENTO, NOMBRE, REGISTRADOBLOG, TIPODOCUMENTO) values (2,'1002', 2, '1002', 'Richard', 0, 'CC');
insert into CLIENTEENTITY (ID,USUARIO, ABONO, DOCUMENTO, NOMBRE, REGISTRADOBLOG, TIPODOCUMENTO) values (3,'1003', 3, '1003', 'Thomas', 0, 'CC');
insert into CLIENTEENTITY (ID,USUARIO, ABONO, DOCUMENTO, NOMBRE, REGISTRADOBLOG, TIPODOCUMENTO) values (4,'1004', 4, '1004', 'Angela', 0, 'TI');
insert into CLIENTEENTITY (ID,USUARIO, ABONO, DOCUMENTO, NOMBRE, REGISTRADOBLOG, TIPODOCUMENTO) values (5,'1005', 5, '1005', 'Julie', 1, 'TI');

insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1001, 'Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 1, '2017-04-01', 1, 1001);
insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1002, 'Mauris lacinia sapien quis libero.', 2, '2017-04-01', 2, 1002);
insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1003, 'Nullam varius.', 3, '2017-04-01', 3, 1003);
insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1004, 'Proin eu mi.', 4, '2017-04-01', 4, 1004);
insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1005, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 5, '2017-04-01', 5, 1005);
insert into REVIEWENTITY (ID, DESCRIPCION, CALIFICACION, FECHA, CLIENTE_ID, FUNCION_ID) values (1006, 'Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', 5, '2017-04-01', 5, 1006);



insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1001, 'Physical Graffiti (1975)', 1001, 'https://www.rock.com/assets/products/60626/large/led-zeppelin-i-album-cover-sticker-s1506.jpg');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1006, 'Led Zeppelin (1969)', 1001, 'https://upload.wikimedia.org/wikipedia/en/e/e3/Led_Zeppelin_-_Physical_Graffiti.jpg');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1007, 'Houses of the Holy (1973)', 1001, 'https://upload.wikimedia.org/wikipedia/en/9/9f/Led_Zeppelin_-_Houses_of_the_Holy.jpg');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1002, 'Bangarang', 1002, 'https://upload.wikimedia.org/wikipedia/en/4/46/Bangarang_cover.jpg');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1003, '4X4=12 (2010)', 1003, 'http://www.themusicninja.com/wp-content/uploads/2010/12/deadmau5-4x412-review.jpg');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1004, 'En el sendero (2014)', 1004, 'http://k31.kn3.net/taringa/F/9/3/8/7/D/BraaGranate/1E7.png');
insert into DISCOENTITY (ID, NOMBRE, ARTISTAENTITY_ID, IMAGEN) values (1005, 'Rage valley (2012)', 1005, 'https://upload.wikimedia.org/wikipedia/en/7/79/Rage_Valley_Album_Art.jpg');


insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1001, 1001);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1002, 1002);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1003, 1003);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1004, 1004);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1005, 1005);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1005, 1006);
insert into FUNCIONENTITY_ARTISTAENTITY (ARTISTAS_ID, FUNCIONES_ID) values (1003, 1006);

insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1001, 300, 'Freeman', 1001);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1002, 400, 'Bennett', 1002);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1003, 500, 'Hunter', 1003);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1004, 600, 'Watkins', 1004);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1005, 700, 'Collins', 1005);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1006, 300, 'The Rain Song', 1006);
insert into CANCIONENTITY (ID, DURACION, NOMBRE, DISCOENTITY_ID) values (1007, 300, 'Over the Hills and Far Away', 1006);

insert into ENTRADAENTITY (ID,LIBRE,NOENTRADA,PRECIO,SILLA,CLIENTEENTITY_ID,FUNCIONENTITY_ID) values (1,0,1,1000,'3A',1,1001);
insert into ENTRADAENTITY (ID,LIBRE,NOENTRADA,PRECIO,SILLA,CLIENTEENTITY_ID,FUNCIONENTITY_ID) values (2,0,2,1000,'3A',2,1003);
insert into ENTRADAENTITY (ID,LIBRE,NOENTRADA,PRECIO,SILLA,CLIENTEENTITY_ID,FUNCIONENTITY_ID) values (3,0,3,1000,'3A',3,1004);
insert into ENTRADAENTITY (ID,LIBRE,NOENTRADA,PRECIO,SILLA,CLIENTEENTITY_ID,FUNCIONENTITY_ID) values (4,0,4,1000,'3A',4,1002);
insert into ENTRADAENTITY (ID,LIBRE,NOENTRADA,PRECIO,SILLA,CLIENTEENTITY_ID,FUNCIONENTITY_ID) values (5,0,5,1000,'3A',4,1001);




