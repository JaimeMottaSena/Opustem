drop database OpusTem;
CREATE DATABASE OpusTem;
USE  OpusTem;

create table usuario (
IdUsuario int (11) primary key auto_increment not null,
AliasUsuario varchar (10) unique not null,
NombreUsuario  varchar(15) not null,
ApellidoUsuario varchar (15) not null,
FechaNacimiento date not null,
CorreoUsuario varchar(20)  unique not null,
ClaveUsuario varchar (20) not null,
TipoDocumento varchar (5) not null,
NumeroDocumento int (10) unique not null,
DireccionUsuario varchar (15) not null,
Telefono int(12) unique not null,
IdCargoFK int(11) not null,
IdTurnoFK int(11) not null,
Estado varchar (10) not null
);
drop table usuario;

CREATE TABLE turno (
  IdTurno int(10) NOT NULL,
  HoraEntrada time DEFAULT NULL,
  HoraSalida time DEFAULT NULL
) ;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`IdTurno`, `HoraEntrada`, `HoraSalida`) VALUES
(1, '07:00:00', '06:00:00'),
(2, '06:00:00', '06:00:00');

drop table cargo;
CREATE TABLE `cargo` (
  `IdCargo` int(10) NOT NULL,
  `NombreCargo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`IdCargo`, `NombreCargo`) VALUES
(1, 'Jefe'),
(2, 'Empleado');

ALTER TABLE `usuario`
ADD KEY `FKTurno` (`IdTurnoFK`);


ALTER TABLE `usuario`
ADD KEY `FKTCargo` (`IdCargoFK`);
ADD KEY `FKTurno` (`HoraEntradaFK`);

describe usuario;