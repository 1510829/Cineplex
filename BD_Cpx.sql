-- --------------------------------------------------------
-- Host:                         192.168.91.137
-- Versión del servidor:         5.5.65-MariaDB - MariaDB Server
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para information_schema

-- Volcando estructura de base de datos para bd_cineplex
CREATE DATABASE IF NOT EXISTS `bd_cineplex` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_cineplex`;

-- Volcando estructura para tabla bd_cineplex.almacen
CREATE TABLE IF NOT EXISTS `almacen` (
  `id_almacen` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Direccion` varchar(70) NOT NULL,
  `Ubicacion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_almacen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.almacen: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` (`id_almacen`, `Nombre`, `Direccion`, `Ubicacion`) VALUES
	(1, 'Almacen Miraflores', 'Av Balta 5425', 'Lima');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.arrendamiento
CREATE TABLE IF NOT EXISTS `arrendamiento` (
  `id_arrend` char(5) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `Fecha_Venci` date DEFAULT NULL,
  `Estado` char(1) DEFAULT NULL,
  `Id_prov` int(11) NOT NULL,
  PRIMARY KEY (`id_arrend`),
  KEY `Id_prov` (`Id_prov`),
  CONSTRAINT `arrendamiento_ibfk_1` FOREIGN KEY (`Id_prov`) REFERENCES `proveedor` (`id_prov`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.arrendamiento: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `arrendamiento` DISABLE KEYS */;
INSERT INTO `arrendamiento` (`id_arrend`, `Descripcion`, `fecha_ingreso`, `Fecha_Venci`, `Estado`, `Id_prov`) VALUES
	('ARD01', 'Ingreso Ticketeras', '2020-08-06', '2021-08-06', 'A', 411),
	('ARD02', 'Impresoras y varios', '2020-07-22', '2021-07-22', 'A', 414),
	('ARD03', 'Mantenimiento', '2020-07-22', '2021-07-23', 'A', 413),
	('ARD04', 'Monitores y otros', '2020-07-23', '2020-07-23', 'A', 411);
/*!40000 ALTER TABLE `arrendamiento` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.detalle_arrend
CREATE TABLE IF NOT EXISTS `detalle_arrend` (
  `id_det_arrend` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `id_arrend` char(5) NOT NULL,
  PRIMARY KEY (`id_det_arrend`),
  KEY `id_equipo` (`id_equipo`),
  KEY `id_arrend` (`id_arrend`),
  CONSTRAINT `detalle_arrend_ibfk_1` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON DELETE CASCADE,
  CONSTRAINT `detalle_arrend_ibfk_2` FOREIGN KEY (`id_arrend`) REFERENCES `arrendamiento` (`id_arrend`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.detalle_arrend: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_arrend` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_arrend` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.detalle_equipo
CREATE TABLE IF NOT EXISTS `detalle_equipo` (
  `id_det_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `Persona_DNI` char(8) NOT NULL,
  `id_arrend` char(5) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `id_sede` int(11) NOT NULL,
  `Fecha_recepcion` date DEFAULT NULL,
  `Fecha_Salida` date DEFAULT NULL,
  PRIMARY KEY (`id_det_equipo`),
  KEY `Persona_DNI` (`Persona_DNI`),
  KEY `id_arrend` (`id_arrend`),
  KEY `id_almacen` (`id_almacen`),
  KEY `id_equipo` (`id_equipo`),
  KEY `id_sede` (`id_sede`),
  CONSTRAINT `detalle_equipo_ibfk_1` FOREIGN KEY (`Persona_DNI`) REFERENCES `persona` (`DNI`) ON DELETE CASCADE,
  CONSTRAINT `detalle_equipo_ibfk_2` FOREIGN KEY (`id_arrend`) REFERENCES `arrendamiento` (`id_arrend`) ON DELETE CASCADE,
  CONSTRAINT `detalle_equipo_ibfk_3` FOREIGN KEY (`id_almacen`) REFERENCES `almacen` (`id_almacen`) ON DELETE CASCADE,
  CONSTRAINT `detalle_equipo_ibfk_4` FOREIGN KEY (`id_equipo`) REFERENCES `equipo` (`id_equipo`) ON DELETE CASCADE,
  CONSTRAINT `detalle_equipo_ibfk_5` FOREIGN KEY (`id_sede`) REFERENCES `sede` (`id_sede`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.detalle_equipo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_equipo` DISABLE KEYS */;
INSERT INTO `detalle_equipo` (`id_det_equipo`, `Persona_DNI`, `id_arrend`, `id_almacen`, `id_equipo`, `id_sede`, `Fecha_recepcion`, `Fecha_Salida`) VALUES
	(1, '4521489', 'ARD01', 1, 1, 4, '2020-07-06', '2020-08-06'),
	(2, '25657424', 'ARD03', 1, 4, 2, '2020-07-08', '2020-08-06');
/*!40000 ALTER TABLE `detalle_equipo` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `id_equipo` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) NOT NULL,
  `Serie` varchar(20) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Marca` varchar(25) NOT NULL,
  `Fec_Ingreso` date NOT NULL,
  PRIMARY KEY (`id_equipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.equipo: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` (`id_equipo`, `Descripcion`, `Serie`, `Modelo`, `Marca`, `Fec_Ingreso`) VALUES
	(1, 'CPU PV', 'KG2025F41', 'GF-204', 'NCR', '2020-06-11'),
	(2, 'IImpresora Matricial', 'AK4152G41', 'LX-350', 'EPSON', '2020-03-09'),
	(3, 'Monitor', 'CNT254520', 'TP-8412', 'LG', '2020-04-20'),
	(4, 'Cuponera', '5674602452', 'D25', 'NCR', '2020-04-21');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `DNI` char(8) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Fec_Nac` date NOT NULL,
  `Sexo` char(1) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.persona: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`DNI`, `Nombre`, `Apellidos`, `Fec_Nac`, `Sexo`, `Estado`) VALUES
	('25657424', 'Jonathan', 'Guzman Marcos', '1993-10-21', 'M', 'A'),
	('42365214', 'Luis Alberto', 'Castro Gonzales', '1995-08-21', 'M', 'A'),
	('4521489', 'Luis Enrique', 'Sasvedra', '1985-03-12', 'M', 'A');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.proveedor
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_prov` int(11) NOT NULL AUTO_INCREMENT,
  `RUC` varchar(11) NOT NULL,
  `Razon_social` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=420 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.proveedor: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`id_prov`, `RUC`, `Razon_social`, `Descripcion`, `Estado`) VALUES
	(411, '20104563207', 'Driver Peru', 'Controladores y dispositivos', 'A'),
	(412, '20105698545', 'Dell System', 'Equipos menores', 'A'),
	(413, '20600376544', 'System support', 'No especifica', 'A'),
	(414, '20604698970', 'System SAC', 'Especies varias', 'A'),
	(415, '20455014426', 'Accespart SAC', 'Equipos menores', 'A'),
	(416, '20556632465', 'Proveedores S.R.L', 'Mantenimiento de equipos', 'A'),
	(417, '20561120146', 'A & M System Solutions S.A.C .', 'Productos en general', 'A'),
	(418, '20513519673', 'Ingenieros S.A.C.', 'Mantenimiento de equipos', 'A'),
	(419, '20602629458', 'GROUP E.I.R.L  ', 'Equipos varios', 'A');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla bd_cineplex.sede
CREATE TABLE IF NOT EXISTS `sede` (
  `id_sede` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Ubicacion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sede`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bd_cineplex.sede: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` (`id_sede`, `Nombre`, `Estado`, `Ubicacion`) VALUES
	(1, 'Real Placa Centro Cívico', 'A', 'Lima'),
	(2, 'Izaguirre', 'A', 'Lima'),
	(3, 'Real Plaza Chiclayo ', 'A', 'Chiclayo'),
	(4, 'La Rambla', 'A', 'Lima');
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
