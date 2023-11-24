-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2023 a las 08:58:23
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
-- Base de datos: `vinted`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido_1` varchar(20) NOT NULL,
  `apellido_2` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tfn` int(10) NOT NULL,
  `numero_ventas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido_1`, `apellido_2`, `email`, `usuario`, `password`, `tfn`, `numero_ventas`) VALUES
(1, 'Alice', 'Johnson', 'Smith', 'alice@example.com', 'alice_j', 'password123', 123456789, 5),
(2, 'Bob', 'Miller', 'Jones', 'bob@example.com', 'bob_m', 'secure456', 987654321, 8),
(3, 'Charlie', 'Williams', 'Brown', 'charlie@example.com', 'charlie_w', 'pass789', 555555555, 12),
(4, 'David', 'Davis', 'Anderson', 'david@example.com', 'david_d', 'abcd1234', 111111111, 15),
(5, 'Eva', 'Smith', 'Taylor', 'eva@example.com', 'eva_s', 'pass5678', 222222222, 3),
(6, 'Frank', 'Johnson', 'Martin', 'frank@example.com', 'frank_j', 'secure789', 333333333, 7),
(7, 'Grace', 'Moore', 'Baker', 'grace@example.com', 'grace_m', 'pass3456', 444444444, 10),
(8, 'Henry', 'White', 'Lee', 'henry@example.com', 'henry_w', 'secure987', 666666666, 6),
(9, 'Ivy', 'Davis', 'Smith', 'ivy@example.com', 'ivy_d', 'pass1234', 777777777, 9),
(10, 'Jack', 'Moore', 'Hall', 'jack@example.com', 'jack_m', 'abcd5678', 888888888, 4),
(11, 'Laura', 'Martinez', 'Gomez', 'laura@example.com', 'laura_m', 'secure123', 555555555, 20),
(12, 'Michael', 'Brown', 'Miller', 'michael@example.com', 'michael_b', 'pass2345', 666666666, 18),
(13, 'Natalie', 'Clark', 'Moore', 'natalie@example.com', 'natalie_c', 'secure567', 777777777, 15),
(14, 'Oliver', 'Taylor', 'Davis', 'oliver@example.com', 'oliver_t', 'pass6789', 888888888, 12),
(15, 'Penelope', 'Wilson', 'Smith', 'penelope@example.com', 'penelope_w', 'abcd7890', 999999999, 10);


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
