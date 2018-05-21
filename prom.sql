-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2018 at 08:40 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prom`
--

-- --------------------------------------------------------

--
-- Table structure for table `alternatif`
--

CREATE TABLE `alternatif` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alternatif`
--

INSERT INTO `alternatif` (`id`, `nama`, `deskripsi`) VALUES
(19, 'galaxy', 'gagagaga'),
(20, 'iphone', 'iiii'),
(21, 'bb', 'bbbb'),
(22, 'lumia', 'lulululu');

-- --------------------------------------------------------

--
-- Table structure for table `alternatif_kriteria`
--

CREATE TABLE `alternatif_kriteria` (
  `id` int(11) NOT NULL,
  `idKriteria` int(11) NOT NULL,
  `idAlternatif` int(11) NOT NULL,
  `nilai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alternatif_kriteria`
--

INSERT INTO `alternatif_kriteria` (`id`, `idKriteria`, `idAlternatif`, `nilai`) VALUES
(4, 5, 16, 70),
(5, 6, 16, 3500),
(6, 5, 17, 70),
(7, 5, 18, 70),
(8, 5, 19, 70),
(9, 6, 19, 3500),
(10, 7, 19, 10),
(11, 8, 19, 80),
(12, 9, 19, 1),
(13, 10, 19, 36),
(14, 5, 20, 90),
(15, 6, 20, 4500),
(16, 7, 20, 10),
(17, 8, 20, 60),
(18, 9, 20, 5),
(19, 10, 20, 48),
(20, 5, 21, 80),
(21, 6, 21, 4000),
(22, 7, 21, 9),
(23, 8, 21, 90),
(24, 9, 21, 2),
(25, 10, 21, 48),
(26, 5, 22, 70),
(27, 6, 22, 4000),
(28, 7, 22, 8),
(29, 8, 22, 50),
(30, 9, 22, 4),
(31, 10, 22, 60);

-- --------------------------------------------------------

--
-- Table structure for table `kriteria`
--

CREATE TABLE `kriteria` (
  `id` int(11) NOT NULL,
  `namaKriteria` varchar(100) NOT NULL,
  `minmaks` varchar(100) NOT NULL,
  `bobot` double NOT NULL,
  `tipePreferensi` int(11) NOT NULL,
  `parameterP` int(11) DEFAULT NULL,
  `parameterQ` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kriteria`
--

INSERT INTO `kriteria` (`id`, `namaKriteria`, `minmaks`, `bobot`, `tipePreferensi`, `parameterP`, `parameterQ`) VALUES
(5, 'kualitas', 'Maksimasi', 8, 4, 20, 0),
(6, 'harga', 'Minimasi', 7, 5, 1000, 500),
(7, 'fitur', 'Maksimasi', 7, 4, 2, 0),
(8, 'populer', 'Maksimasi', 4, 3, 0, 20),
(9, 'pelayanan garansi', 'Minimasi', 4, 6, 2, 1),
(10, 'keawetan', 'Maksimasi', 3, 2, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alternatif`
--
ALTER TABLE `alternatif`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `alternatif_kriteria`
--
ALTER TABLE `alternatif_kriteria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `alternatif`
--
ALTER TABLE `alternatif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `alternatif_kriteria`
--
ALTER TABLE `alternatif_kriteria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `kriteria`
--
ALTER TABLE `kriteria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
