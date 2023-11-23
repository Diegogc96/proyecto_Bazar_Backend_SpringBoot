-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2023 a las 19:02:54
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
-- Base de datos: `bazar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `apellido`, `dni`, `nombre`) VALUES
(1, 'Galindo', '38928582', 'Diego'),
(2, 'Mercado', '12345678', 'Juan'),
(3, 'Rodriguez', '87654321', 'Paula'),
(5, 'qwe', '111111', 'qwerty');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_seq`
--

CREATE TABLE `cliente_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente_seq`
--

INSERT INTO `cliente_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo_producto` bigint(20) NOT NULL,
  `cantidad_disponible` double DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo_producto`, `cantidad_disponible`, `costo`, `marca`, `nombre`) VALUES
(1, 4, 1500, 'glassInc', 'Botella'),
(2, 3, 756, 'PlasticPlato', 'Plato'),
(3, 25, 55, 'EcoLights', 'Bombilla'),
(4, 400, 25, 'EduCar', 'Lapiz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_seq`
--

CREATE TABLE `producto_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto_seq`
--

INSERT INTO `producto_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `codigo_venta` bigint(20) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`codigo_venta`, `fecha_venta`, `total`, `id_cliente`) VALUES
(402, '2023-11-21', 1500, 1),
(403, '2023-11-21', 1000, 2),
(404, '2023-11-21', 800, 3),
(406, '2023-01-01', 3000, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_lista_productos`
--

CREATE TABLE `venta_lista_productos` (
  `lista_venta_codigo_venta` bigint(20) NOT NULL,
  `lista_productos_codigo_producto` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta_lista_productos`
--

INSERT INTO `venta_lista_productos` (`lista_venta_codigo_venta`, `lista_productos_codigo_producto`) VALUES
(402, 1),
(402, 2),
(403, 3),
(403, 4),
(404, 1),
(404, 2),
(406, 3),
(406, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta_seq`
--

CREATE TABLE `venta_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta_seq`
--

INSERT INTO `venta_seq` (`next_val`) VALUES
(501);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo_producto`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`codigo_venta`),
  ADD UNIQUE KEY `UK_jywx1th6n2ytgn2glxi3ab56y` (`id_cliente`);

--
-- Indices de la tabla `venta_lista_productos`
--
ALTER TABLE `venta_lista_productos`
  ADD KEY `FKivxey0qxhfskip4wdobj5we63` (`lista_productos_codigo_producto`),
  ADD KEY `FK26j287nec6r5eykpfen7thb5l` (`lista_venta_codigo_venta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FKsor2qmi3thao7a8or49vlohp9` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Filtros para la tabla `venta_lista_productos`
--
ALTER TABLE `venta_lista_productos`
  ADD CONSTRAINT `FK26j287nec6r5eykpfen7thb5l` FOREIGN KEY (`lista_venta_codigo_venta`) REFERENCES `venta` (`codigo_venta`),
  ADD CONSTRAINT `FKivxey0qxhfskip4wdobj5we63` FOREIGN KEY (`lista_productos_codigo_producto`) REFERENCES `producto` (`codigo_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
