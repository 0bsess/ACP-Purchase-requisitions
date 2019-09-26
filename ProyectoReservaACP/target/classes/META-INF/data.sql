insert into pais values(default,'Perú');
insert into pais values(default,'Ecuador');
insert into pais values(default,'Chile');
insert into pais values(default,'Argentina');
insert into pais values(default,'USA');

insert into ciudad values(default,'Arizona',5);
insert into ciudad values(default,'Buenos Aires',4);
insert into ciudad values(default,'Boston',5);
insert into ciudad values(default,'Piura',1);
insert into ciudad values(default,'Tacna',1);
insert into ciudad values(default,'Guayaquil',2);
insert into ciudad values(default,'Quito',2);
insert into ciudad values(default,'Arica',3);
insert into ciudad values(default,'Santiago',3);


insert into usuario (idusuario,email,flagadmin,iddocumento,nameapmaterno,nameappaterno,nameusuario,password,phone) values(default,'JuanQ@gmail.com',true,'201910379','Quispe','Flores','Juan','87654321','966888775');
insert into usuario (idusuario,email,flagadmin,iddocumento,nameapmaterno,nameappaterno,nameusuario,password,phone) values(default,'JosePS@gmail.com',true,'201910723','Perez','Smith','Jose','78954321','955888776');

insert into producto (idProducto,nameproducto,dayReabastecimiento,quantityStock,moneyPrecio,quantityReserva) values(default,'Palta','2019/10/10','100',150.0,'90');

insert into reserva (idReserva,dayReserva,idUsuario,idCiudad,dayLlegada,flagAnulado,dayVencimiento) values(default,'2019/10/10',1,2,'2019/11/10',false,'2019/10/13');

insert into factura (idFactura,idReserva,moneyPrecioFinal,flagPagoTarjeta,numFactura,numSerie,flagCancelado,dayFactura) values(default,1,1500.0,true,'F0001','S0001',true,'2019/09/27');

