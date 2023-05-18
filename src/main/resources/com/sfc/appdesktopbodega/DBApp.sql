create table users(
                      iduser int primary key AUTO_INCREMENT,
                      user_dni char(8) unique not null,
                      user_password varchar(128) not null,
                      user_nombres varchar(70) not null,
                      user_apellidos varchar(70) not null,
                      user_rol int not null,
                      user_fecha TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
                      user_email varchar(50),
                      user_celular varchar(9),
                      user_imagen Longblob,
                      user_token varchar(128),
                      user_online tinyint,
                      foreign key (user_rol) references rol(idRol),
                      CONSTRAINT users_ibfk_1 FOREIGN KEY (user_rol) REFERENCES rol (idRol),
                      CONSTRAINT ck_validateDni CHECK (((length(user_dni) = 8) and (user_dni > 0) and (user_dni <= 99999999)))
);
CREATE TABLE rol (
                     idRol int primary key AUTO_INCREMENT,
                     rol_cargo varchar(45) NOT NULL,
                     rol_estado varchar(45) NOT NULL
);

create table userAttempt(
                            id int not null ,
                            userAttempt_number int unsigned not null,
                            foreign key (id) references users(iduser) on DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE configuracion (
                               id int primary key,
                               conf_nombre varchar(30) NOT NULL,
                               conf_valor varchar(30) DEFAULT NULL,
                               estado tinyint NOT NULL,
                               id_user int NOT NULL,
                               FOREIGN KEY (id_user) REFERENCES users (iduser)
);


create table operacion(
                          idOperacion int primary key auto_increment,
                          operacion_nombre varchar(50) not null,
                          id_modulo int not null,
                          foreign key (id_modulo) references modulo(idModulo)
);



create table rolOperacion(
                             idRolOperacion int primary key auto_increment,
                             id_rol int not null,
                             id_Operacion int not null,
                             foreign key (id_rol) references rol(idRol),
                             foreign key(id_Operacion)references operacion(idOperacion)
);

create table modulo(
                       idModulo int primary key auto_increment,
                       modulo_nombre varchar(50) not null
);



create table cliente(
                        cliente_id int primary key auto_increment,
                        cliente_dni varchar(8) unique not null,
                        cliente_ruc varchar(11) unique  null,
                        cliente_nombres varchar(50) not null,
                        cliente_apellidos varchar(50) not null,
                        cliente_correo varchar(50) null,
                        cliente_edad varchar (2) null,
                        cliente_domicilio varchar (50) null,
                        cliente_telefono varchar(15) null
);

create table producto(
                         producto_id int primary key auto_increment,
                         producto_codigo varchar(14) UNIQUE not null,
                         producto_nombre varchar(70) not null,
                         producto_categoria int not null,
                         producto_marca varchar(50) not null,
                         producto_costo decimal(7,2) not null,
                         producto_precio decimal(6,2) not null,
                         producto_stock int not null,
                         producto_imagen longblob not null,
                         foreign key(producto_categoria) REFERENCES categoria(categoria_id)
);

create table proveedor(
                          proveedor_id int primary key auto_increment,
                          proveedor_RUC varchar(11) not null,
                          proveedor_empresa varchar(40) not null,
                          proveedor_dni varchar(8) null,
                          proveedor_nombre varchar(50) not null,
                          proveedor_apellido varchar(50) not null,
                          proveedor_ubicacion varchar(60) not null,
                          proveedor_telefono varchar(15) not null
);

create table categoria(
                          categoria_id int primary key auto_increment,
                          categoria_nombre varchar(50) not null unique,
                          categoria_descripcion varchar(100) not null
);

create table detalleVenta(
                             dVenta_id int primary key not null auto_increment,
                             detalleVenta_id int not null,
                             detalleVenta_producto int not null,
                             detalleVenta_cantidad int not null,
                             detalleVenta_precio decimal(10,2) not null,
                             detalleVenta_descuento decimal(7,2) not null,
                             foreign key(detalleVenta_id) REFERENCES venta(venta_id) ON DELETE CASCADE,
                             foreign key(detalleVenta_producto) REFERENCES producto(producto_id)
);

create table venta(
                      venta_id int primary key auto_increment,
                      venta_cliente int not null,
                      venta_usuario int not null,
                      venta_descuento decimal(10,2)not null,
                      venta_total decimal (10,2) not null,
                      venta_fecha TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
                      foreign key(venta_cliente) REFERENCES cliente(cliente_id),
                      foreign key(venta_usuario) REFERENCES users(iduser)
);

create table compra(
                       compra_id int primary key auto_increment,
                       compra_usuario int not null,
                       compra_proveedor int not null,
                       compra_total decimal(10,2) not null,
                       venta_fecha TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
                       compra_estado varchar(30) null,
                       foreign key(compra_usuario) REFERENCES users(iduser),
                       foreign key(compra_proveedor) REFERENCES proveedor(proveedor_id)
);

create table detalleCompra(
                              dcompra_id int primary key auto_increment,
                              detalleCompra_id int not null,
                              detalleCompra_producto int not null,
                              detalleCompra_cantidad int not null,
                              detalleCompra_precio decimal(6,2) not null,
                              detalleCompra_descuento decimal(6,2) not null,
                              foreign key(detalleCompra_id) REFERENCES compra(compra_id) ON DELETE CASCADE,
                              foreign key(detalleCompra_producto) REFERENCES producto(producto_id)

);

create table auditUser(
                          idAuditoria int not null primary key auto_increment,
                          audit_iduser Int null,
                          auditOLD_dni CHAR(8) null,
                          auditNEW_dni CHAR(8) null,
                          auditOLD_password varchar(128) null,
                          auditNEW_password varchar(128) null,
                          auditOLD_nombres varchar(50) null,
                          auditNEW_nombres varchar(50) null,
                          auditOLD_apellidos varchar(50) null,
                          auditNEW_apellidos varchar(50) null,
                          auditOLD_rol int null,
                          auditNEW_rol int null,
                          fecha datetime,
                          audit_action varchar(20),
                          audit_host varchar(20)
);


/* TRIGGERS ///////////////////*/
CREATE TRIGGER InsertUser AFTER
    INSERT
    ON users
    for each row
    insert into auditUser(audit_iduser,auditNEW_dni,auditNEW_password,auditNEW_nombres,auditNEW_apellidos,auditNEW_rol,fecha,audit_action,audit_host)
    values (new.iduser,new.user_dni,new.user_password,new.user_nombres,new.user_apellidos,new.user_rol,now(),'INSERT',(select SUBSTRING_INDEX(Host,':',1) as 'ip' from information_schema.processlist WHERE ID=connection_id())
    );

CREATE TRIGGER UpdateUser AFTER
    UPDATE
    ON users
    for each row
    insert into auditUser(audit_iduser,auditOLD_dni,auditNEW_dni,auditOLD_password,auditNEW_password,auditOLD_nombres,auditNEW_nombres,auditOLD_apellidos,auditNEW_apellidos,auditOLD_rol,auditNEW_rol,fecha,audit_action,audit_host)
    values (new.iduser,OLD.user_dni,new.user_dni,OLD.user_password,new.user_password,OLD.user_nombres,new.user_nombres,OLD.user_apellidos,new.user_apellidos,OLD.user_rol,new.user_rol,now(),'UPDATE',(select SUBSTRING_INDEX(Host,':',1) as 'ip' from information_schema.processlist WHERE ID=connection_id())
    );

CREATE TRIGGER DeleteUser AFTER
    DELETE
    ON users
    for each row
    insert into auditUser(audit_iduser, auditNEW_dni, auditNEW_password, auditNEW_nombres, auditNEW_apellidos, auditNEW_rol, fecha,audit_action, audit_host)
    values
        (OLD.iduser, OLD.user_dni, OLD.user_password, OLD.user_nombres, OLD.user_apellidos, OLD.user_rol, now(),
         'DELETE',(select SUBSTRING_INDEX(Host,':',1) as 'ip' from information_schema.processlist WHERE ID=connection_id())
         );