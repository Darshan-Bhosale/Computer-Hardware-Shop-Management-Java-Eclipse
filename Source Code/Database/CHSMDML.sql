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

-- Dumping data for table chsm.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `name`, `reg_date`, `gender`, `address`, `contact`, `email`, `cr_amount`, `balance`) VALUES
	(1, 'gfgfhfh', '2018-03-20 00:00:00', 'Male', 'hhjhjh		', 77787, 'hjbh', 56565675, 576565),
	(2, 'deva', '2018-03-20 00:00:00', 'Male', 'kalamboli', 9702909906, 'devena/jnsvja', 2342342, 23424),
	(3, 'kala', '2018-03-12 00:00:00', 'Male', 'kalamboli', 9702909906, 'devendra.joglekar@gmail.com', 22, 22),
	(4, 'devad', '2018-03-12 00:00:00', 'Male', 'kalambl', 9702906609, 'devendra.joglekar@yahoo.in', 1888, 22),
	(5, 'fdf', '2018-03-12 00:00:00', 'Male', 'ffrf	', 66677554, 'ri@f', 527776, 252676);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping data for table chsm.cust_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `cust_order` DISABLE KEYS */;
INSERT INTO `cust_order` (`id`, `date`, `cust_id`, `cust_name`, `cust_contact`, `cust_bamount`, `pro_id`, `pro_mno`, `pro_quntity`, `pro_rate`, `tot_amount`, `address`) VALUES
	(1, '2018-03-12 00:00:00', 1, 'gfgfhfh', 77787, 576565, 1, '566', 8, 6788, 54304, 'hhjhjh		'),
	(2, '2018-03-13 00:00:00', 5, 'fdf', 66677554, 252676, 1, '566', 6, 6788, 40728, 'ffrf	');
/*!40000 ALTER TABLE `cust_order` ENABLE KEYS */;

-- Dumping data for table chsm.dispatch_custorder: ~0 rows (approximately)
/*!40000 ALTER TABLE `dispatch_custorder` DISABLE KEYS */;
INSERT INTO `dispatch_custorder` (`id`, `date`, `order_id`, `cust_name`, `cust_address`, `cust_contact`, `order_amount`, `vehical_number`, `driver_name`, `tot_amount`) VALUES
	(1, '2018-03-11 00:00:00', 1, 'gfgfhfh', 'hhjhjh		', 77787, 54304, '23112dfffd', 'err', 57019),
	(2, '2018-03-19 00:00:00', 1, 'gfgfhfh', 'hhjhjh		', 77787, 54304, 'gfgftyyy', 'gggvg', 57019);
/*!40000 ALTER TABLE `dispatch_custorder` ENABLE KEYS */;

-- Dumping data for table chsm.employee: ~0 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `name`, `birth_date`, `gender`, `address`, `contact`, `email`, `joining_date`, `designation`, `salary`) VALUES
	(1, 'devendra joglekar', '2018-03-15 00:00:00', 'Male', 'devenra', '231312312', 'adsasd', '2018-03-21 00:00:00', 'devenloper', 2000),
	(2, 'dasda', '2018-03-14 00:00:00', 'Male', 'dahsbd', '9702909907', 'deva@gmai.com', '2018-03-21 00:00:00', 'deva', 40000),
	(3, 'devas', '2018-03-13 00:00:00', 'Male', 'panvel', '4846586435', 'deva@mail.com', '2018-03-20 00:00:00', 'devena', 21666),
	(4, 'sagar wardhe', '1994-05-10 00:00:00', 'Male', 'afsgfgsj', 'uju7551185', 'aksh341', '2018-03-22 00:00:00', 'jyujuewd', 40000),
	(5, 'aa', '1988-03-16 00:00:00', 'Male', 'jjhjwqh			', '78898789787', 'rttt@gmail.com', '2018-03-13 00:00:00', 'dhahsdh', 23456),
	(6, 'GANESH ZAMBARE', '1995-11-27 00:00:00', 'Male', 'KALAMBOLI SECTOR-3 , LIG 1 ROOM NO ', '9967646286', 'GZ6522@GMAIL.COM', '2018-03-26 00:00:00', 'WORKER', 1000),
	(7, 'aaa', '2000-03-28 00:00:00', 'Male', 'hhj	', '4564338485', 'rrrr@gmail.com', '2018-03-06 00:00:00', 'ddfe', 1233),
	(8, 'rahul', '2021-07-23 00:00:00', 'Male', 'sdad', '2322342342', 'deva@gmail.com', '2021-07-06 00:00:00', 'dsad', 2000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping data for table chsm.emp_salary: ~0 rows (approximately)
/*!40000 ALTER TABLE `emp_salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_salary` ENABLE KEYS */;

-- Dumping data for table chsm.login: ~0 rows (approximately)
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`id`, `lname`, `lpass`) VALUES
	(1, 'dev', 'dev'),
	(2, 'deva', 'deva'),
	(3, 'dev', 'dev'),
	(4, 'sagar', '1234'),
	(5, 'aaa', 'aaa'),
	(6, 'GANESH', '14325'),
	(7, 'rwrw', '1234'),
	(8, 'rahul', 'rahul');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping data for table chsm.product: ~0 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `c_name`, `p_name`, `model_no`, `color`, `description`, `prise`) VALUES
	(1, 'fff', 'tff', '566', 'gggf', 'gfgffg		', 6788),
	(2, 'ddd', 'ffff', 'fr656565', 'dff', 'ddd	', 766768),
	(3, 'aaa', 'aaa', 'f5667', 'hhgh', 'tfhgygyg', 66);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping data for table chsm.supplier: ~0 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `name`, `reg_date`, `gender`, `address`, `contact`, `email`, `cr_amount`, `balance`) VALUES
	(1, 'sagar', '2018-03-11', 'Male', 'qggdga', 542275442, 'kkkaghb', 300, -600),
	(2, 'aaa', '2018-03-12', 'Male', 'vgg	', 7888899, 'gh@gmil.com', 5000, 10000),
	(3, 'bbb', '2018-03-14', 'Male', 'hg	', 7788, 'hjhh', 90000, 6788),
	(4, 'ganesh', '2018-03-19', 'Male', 'udiuwdfh	', 123123123, 'eeefasfsdfsad', 21000, 122),
	(5, 'devena', '2018-03-29', 'Male', 'dev', 9875465468, 'devan@gmai.com', 342434234, 21342134);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

-- Dumping data for table chsm.sup_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `sup_order` DISABLE KEYS */;
INSERT INTO `sup_order` (`id`, `date`, `sup_id`, `sup_name`, `pro_id`, `pro_mn`, `pro_qn`, `pro_rate`, `tot_amount`) VALUES
	(1, '2018-03-01 00:00:00', 1, 'sagar', 1, '566', 3, 6788, 20364),
	(2, '2018-03-14 00:00:00', 4, 'ganesh', 1, '566', 3, 6788, 20364),
	(3, '2018-03-19 00:00:00', 3, 'bbb', 1, '566', 1, 6788, 6788);
/*!40000 ALTER TABLE `sup_order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
