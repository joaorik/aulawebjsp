-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2018 at 06:07 PM
-- Server version: 5.6.37
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aula_web`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(250) NOT NULL,
  `address` text,
  `city` varchar(50) DEFAULT NULL,
  `estate` varchar(50) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `addr_number` varchar(10) DEFAULT NULL,
  `neighborhood` varchar(100) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `galleries`
--

CREATE TABLE IF NOT EXISTS `galleries` (
  `id` int(10) unsigned NOT NULL,
  `image` varchar(100) NOT NULL,
  `caption` varchar(250) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `galleries`
--

INSERT INTO `galleries` (`id`, `image`, `caption`) VALUES
(1, 'cables-connection.jpg', 'Servicos eletricos'),
(2, 'blue-brush.jpg', 'Pintura'),
(3, 'adult-boots.jpg', 'Reformas'),
(4, 'person-welder.jpg', 'Reparos'),
(5, 'business-career.jpg', 'Limpeza'),
(6, 'building-cleaning.jpg', 'Limpeza Predial');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE IF NOT EXISTS `services` (
  `id` int(10) unsigned NOT NULL,
  `title` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `title`, `image`, `content`) VALUES
(1, 'Encanador', 'encanador.jpg', 'Todos os serviços de encanador. <br> Conserto de vazamentos. <br> Troca de torneiras Conserto de descargas.'),
(2, 'Eletrecista', 'eletricista.jpg', 'Todos os serviços de eletricista. <br> Conserto de chuveiros. <br> Troca de torneira elétrica. <br> Troca de interruptor.'),
(3, 'Pintura', 'pintura.jpg', 'Todos os serviços de pintura, <br> Pintura de paredes. <br> Aplicação de texturas. <br> Aplicação de grafiatos.'),
(4, 'Consertos e Reparos', 'consertos-e-reparos.jpg', 'Serviços de reparos e consertos. <br> Troca de fechaduras. <br> Instalação de maquina de lavar. <br> Instalação de varais'),
(5, 'Marcenaria', 'marcenaria.jpg', 'Pequenos serviços de marcenaria. <br> Conserto de moveis planejados. <br> Ajuste de armários embutidos. <br> Consertos em portas e janelas.'),
(6, 'Novas Instalações', 'instalacoes.jpg', 'Serviços em casas e apartamentos. <br> Instalação de fogões. <br> Instalação de eletrodomésticos. <br> Instalações de chuveiros e torneiras.');

-- --------------------------------------------------------

--
-- Table structure for table `sliders`
--

CREATE TABLE IF NOT EXISTS `sliders` (
  `id` int(10) unsigned NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sliders`
--

INSERT INTO `sliders` (`id`, `image`) VALUES
(1, 'maint1.jpg'),
(2, 'maint2.jpg'),
(3, 'maint3.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(140) NOT NULL,
  `passwd` varchar(70) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `passwd`) VALUES
(1, 'admin', 'admin@sinale.com.br', '123123123'),
(2, 'joao', 'joao@sinale.com.br', 'x1x2x3x4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `galleries`
--
ALTER TABLE `galleries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sliders`
--
ALTER TABLE `sliders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `galleries`
--
ALTER TABLE `galleries`
  MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `sliders`
--
ALTER TABLE `sliders`
  MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
