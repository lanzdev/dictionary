-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2017 at 08:14 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dictionary`
--

-- --------------------------------------------------------

--
-- Table structure for table `antonym`
--

CREATE TABLE `antonym` (
  `antonym_id` int(11) NOT NULL,
  `antonym` varchar(255) DEFAULT NULL,
  `term_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `definition`
--

CREATE TABLE `definition` (
  `definition_id` int(11) NOT NULL,
  `definition` varchar(1000) DEFAULT NULL,
  `term_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `suite`
--

CREATE TABLE `suite` (
  `suite_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `privacy` enum('private','public') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `synonym`
--

CREATE TABLE `synonym` (
  `synonym_id` int(11) NOT NULL,
  `synonym` varchar(255) DEFAULT NULL,
  `term_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `term`
--

CREATE TABLE `term` (
  `term_id` int(11) NOT NULL,
  `origin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `terms_suite`
--

CREATE TABLE `terms_suite` (
  `terms_suite_id` int(11) NOT NULL,
  `suite_id` int(11) DEFAULT NULL,
  `term_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(16) NOT NULL,
  `permission` enum('admin','user') DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `antonym`
--
ALTER TABLE `antonym`
  ADD PRIMARY KEY (`antonym_id`),
  ADD KEY `term_id` (`term_id`);

--
-- Indexes for table `definition`
--
ALTER TABLE `definition`
  ADD PRIMARY KEY (`definition_id`),
  ADD KEY `term_id` (`term_id`);

--
-- Indexes for table `suite`
--
ALTER TABLE `suite`
  ADD PRIMARY KEY (`suite_id`),
  ADD KEY `created_by` (`created_by`);

--
-- Indexes for table `synonym`
--
ALTER TABLE `synonym`
  ADD PRIMARY KEY (`synonym_id`),
  ADD KEY `term_id` (`term_id`);

--
-- Indexes for table `term`
--
ALTER TABLE `term`
  ADD PRIMARY KEY (`term_id`);

--
-- Indexes for table `terms_suite`
--
ALTER TABLE `terms_suite`
  ADD PRIMARY KEY (`terms_suite_id`),
  ADD KEY `suite_id` (`suite_id`),
  ADD KEY `term_id` (`term_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `antonym`
--
ALTER TABLE `antonym`
  MODIFY `antonym_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `definition`
--
ALTER TABLE `definition`
  MODIFY `definition_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `suite`
--
ALTER TABLE `suite`
  MODIFY `suite_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `synonym`
--
ALTER TABLE `synonym`
  MODIFY `synonym_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `term`
--
ALTER TABLE `term`
  MODIFY `term_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `terms_suite`
--
ALTER TABLE `terms_suite`
  MODIFY `terms_suite_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `antonym`
--
ALTER TABLE `antonym`
  ADD CONSTRAINT `antonym_ibfk_1` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`);

--
-- Constraints for table `definition`
--
ALTER TABLE `definition`
  ADD CONSTRAINT `definition_ibfk_1` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`);

--
-- Constraints for table `suite`
--
ALTER TABLE `suite`
  ADD CONSTRAINT `suite_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `synonym`
--
ALTER TABLE `synonym`
  ADD CONSTRAINT `synonym_ibfk_1` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`);

--
-- Constraints for table `terms_suite`
--
ALTER TABLE `terms_suite`
  ADD CONSTRAINT `terms_suite_ibfk_1` FOREIGN KEY (`suite_id`) REFERENCES `suite` (`suite_id`),
  ADD CONSTRAINT `terms_suite_ibfk_2` FOREIGN KEY (`term_id`) REFERENCES `term` (`term_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
