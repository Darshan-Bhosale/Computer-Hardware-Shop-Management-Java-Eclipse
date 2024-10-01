-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.58-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for chsm
CREATE DATABASE IF NOT EXISTS `chsm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chsm`;

-- Dumping structure for table chsm.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `reg_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `gender` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(45) NOT NULL DEFAULT '',
  `contact` double NOT NULL DEFAULT '0',
  `email` varchar(45) NOT NULL DEFAULT '',
  `cr_amount` double NOT NULL DEFAULT '0',
  `balance` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.cust_order
CREATE TABLE IF NOT EXISTS `cust_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `cust_id` int(10) unsigned NOT NULL DEFAULT '0',
  `cust_name` varchar(45) NOT NULL DEFAULT '',
  `cust_contact` double NOT NULL DEFAULT '0',
  `cust_bamount` double NOT NULL DEFAULT '0',
  `pro_id` int(10) unsigned NOT NULL DEFAULT '0',
  `pro_mno` varchar(45) NOT NULL DEFAULT '',
  `pro_quntity` int(10) unsigned NOT NULL DEFAULT '0',
  `pro_rate` double NOT NULL DEFAULT '0',
  `tot_amount` double NOT NULL DEFAULT '0',
  `address` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.dispatch_custorder
CREATE TABLE IF NOT EXISTS `dispatch_custorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `order_id` int(10) unsigned NOT NULL DEFAULT '0',
  `cust_name` varchar(45) NOT NULL DEFAULT '',
  `cust_address` varchar(45) NOT NULL DEFAULT '',
  `cust_contact` double NOT NULL DEFAULT '0',
  `order_amount` double NOT NULL DEFAULT '0',
  `vehical_number` varchar(45) NOT NULL DEFAULT '',
  `driver_name` varchar(45) NOT NULL DEFAULT '',
  `tot_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `birth_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `gender` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(45) NOT NULL DEFAULT '',
  `contact` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(45) DEFAULT NULL,
  `joining_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `designation` varchar(45) NOT NULL DEFAULT '',
  `salary` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.emp_salary
CREATE TABLE IF NOT EXISTS `emp_salary` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `eid` int(10) unsigned NOT NULL DEFAULT '0',
  `ename` varchar(45) NOT NULL DEFAULT '',
  `sdate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `esalary` double NOT NULL DEFAULT '0',
  `advsal` int(10) unsigned NOT NULL DEFAULT '0',
  `bosal` int(10) unsigned NOT NULL DEFAULT '0',
  `totsal` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.login
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lname` varchar(45) NOT NULL DEFAULT '',
  `lpass` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) NOT NULL DEFAULT '',
  `p_name` varchar(45) NOT NULL DEFAULT '',
  `model_no` varchar(45) NOT NULL DEFAULT '',
  `color` varchar(45) DEFAULT NULL,
  `description` varchar(45) NOT NULL DEFAULT '',
  `prise` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `reg_date` varchar(45) NOT NULL DEFAULT '',
  `gender` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(45) NOT NULL DEFAULT '',
  `contact` double NOT NULL DEFAULT '0',
  `email` varchar(45) DEFAULT NULL,
  `cr_amount` double NOT NULL DEFAULT '0',
  `balance` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

-- Dumping structure for table chsm.sup_order
CREATE TABLE IF NOT EXISTS `sup_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `sup_id` int(10) unsigned NOT NULL DEFAULT '0',
  `sup_name` varchar(45) NOT NULL DEFAULT '',
  `pro_id` int(10) unsigned NOT NULL DEFAULT '0',
  `pro_mn` varchar(45) NOT NULL DEFAULT '',
  `pro_qn` int(10) unsigned NOT NULL DEFAULT '0',
  `pro_rate` double NOT NULL DEFAULT '0',
  `tot_amount` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
