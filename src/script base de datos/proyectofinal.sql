-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-12-2023 a las 05:15:29
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbasignare`
--

CREATE TABLE `tbasignare` (
  `ID` int(11) NOT NULL,
  `OPERADOR` varchar(255) DEFAULT NULL,
  `idEspecialidad` int(11) DEFAULT NULL,
  `idTecnico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbcliente`
--

CREATE TABLE `tbcliente` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbcliente`
--

INSERT INTO `tbcliente` (`ID`, `APELLIDO`, `DIRECCION`, `DNI`, `EMAIL`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Rodriguez', 'Cordoba', 30, 'robertorodriguez@gmail.com', 'Roberto', 4700000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbcontrato`
--

CREATE TABLE `tbcontrato` (
  `ID` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idServicio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbespecialidad`
--

CREATE TABLE `tbespecialidad` (
  `ID` int(11) NOT NULL,
  `TIPO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbincidente`
--

CREATE TABLE `tbincidente` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `FECHACIERRE` datetime DEFAULT NULL,
  `OPERADOR` varchar(255) DEFAULT NULL,
  `TIPO` varchar(255) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idContrato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbrrhh`
--

CREATE TABLE `tbrrhh` (
  `ID` int(11) NOT NULL,
  `ESTADO` tinyint(1) DEFAULT 0,
  `FECHACIERRE` datetime DEFAULT NULL,
  `FECHAINICIO` datetime DEFAULT NULL,
  `OPERADOR` varchar(255) DEFAULT NULL,
  `idIncidente` int(11) DEFAULT NULL,
  `idTecnico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbservicio`
--

CREATE TABLE `tbservicio` (
  `ID` int(11) NOT NULL,
  `TIPO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbtecnico`
--

CREATE TABLE `tbtecnico` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbtecnico`
--

INSERT INTO `tbtecnico` (`ID`, `APELLIDO`, `NOMBRE`) VALUES
(1, 'Perez', 'Jose');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indices de la tabla `tbasignare`
--
ALTER TABLE `tbasignare`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_tbAsignarE_idEspecialidad` (`idEspecialidad`),
  ADD KEY `FK_tbAsignarE_idTecnico` (`idTecnico`);

--
-- Indices de la tabla `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `DNI` (`DNI`);

--
-- Indices de la tabla `tbcontrato`
--
ALTER TABLE `tbcontrato`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_tbContrato_idCliente` (`idCliente`),
  ADD KEY `FK_tbContrato_idServicio` (`idServicio`);

--
-- Indices de la tabla `tbespecialidad`
--
ALTER TABLE `tbespecialidad`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tbincidente`
--
ALTER TABLE `tbincidente`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_tbIncidente_idCliente` (`idCliente`),
  ADD KEY `FK_tbIncidente_idContrato` (`idContrato`);

--
-- Indices de la tabla `tbrrhh`
--
ALTER TABLE `tbrrhh`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_tbRrhh_idIncidente` (`idIncidente`),
  ADD KEY `FK_tbRrhh_idTecnico` (`idTecnico`);

--
-- Indices de la tabla `tbservicio`
--
ALTER TABLE `tbservicio`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tbtecnico`
--
ALTER TABLE `tbtecnico`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbasignare`
--
ALTER TABLE `tbasignare`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tbespecialidad`
--
ALTER TABLE `tbespecialidad`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbincidente`
--
ALTER TABLE `tbincidente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbrrhh`
--
ALTER TABLE `tbrrhh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbservicio`
--
ALTER TABLE `tbservicio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbtecnico`
--
ALTER TABLE `tbtecnico`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbasignare`
--
ALTER TABLE `tbasignare`
  ADD CONSTRAINT `FK_tbAsignarE_idEspecialidad` FOREIGN KEY (`idEspecialidad`) REFERENCES `tbespecialidad` (`ID`),
  ADD CONSTRAINT `FK_tbAsignarE_idTecnico` FOREIGN KEY (`idTecnico`) REFERENCES `tbtecnico` (`ID`);

--
-- Filtros para la tabla `tbcontrato`
--
ALTER TABLE `tbcontrato`
  ADD CONSTRAINT `FK_tbContrato_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `tbcliente` (`ID`),
  ADD CONSTRAINT `FK_tbContrato_idServicio` FOREIGN KEY (`idServicio`) REFERENCES `tbservicio` (`ID`);

--
-- Filtros para la tabla `tbincidente`
--
ALTER TABLE `tbincidente`
  ADD CONSTRAINT `FK_tbIncidente_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `tbcliente` (`ID`),
  ADD CONSTRAINT `FK_tbIncidente_idContrato` FOREIGN KEY (`idContrato`) REFERENCES `tbcontrato` (`ID`);

--
-- Filtros para la tabla `tbrrhh`
--
ALTER TABLE `tbrrhh`
  ADD CONSTRAINT `FK_tbRrhh_idIncidente` FOREIGN KEY (`idIncidente`) REFERENCES `tbincidente` (`ID`),
  ADD CONSTRAINT `FK_tbRrhh_idTecnico` FOREIGN KEY (`idTecnico`) REFERENCES `tbtecnico` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
