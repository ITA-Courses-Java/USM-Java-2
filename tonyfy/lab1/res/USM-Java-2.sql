--
-- Table structure for table `Student`
--

CREATE TABLE IF NOT EXISTS `Student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`id`, `firstName`, `lastName`) VALUES
(1, 'John', 'Doe'),
(2, 'O.', 'Henry'),
(3, 'Walter', 'White');
