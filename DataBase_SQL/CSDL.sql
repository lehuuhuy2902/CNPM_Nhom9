/*
MySQL Backup
Database: qlcuahangquanao
Backup Time: 2021-06-09 22:51:07
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `qlcuahangquanao`.`customer`;
DROP TABLE IF EXISTS `qlcuahangquanao`.`detailedinvoice`;
DROP TABLE IF EXISTS `qlcuahangquanao`.`invoice`;
DROP TABLE IF EXISTS `qlcuahangquanao`.`product`;
CREATE TABLE `customer` (
  `id` char(6) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `phone` char(10) NOT NULL,
  `typeCard` varchar(255) DEFAULT NULL,
  `point` decimal(5,0) DEFAULT NULL,
  `dateSD` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `detailedinvoice` (
  `id_Invoice` char(6) NOT NULL,
  `id_Product` char(6) NOT NULL,
  `quantity` decimal(4,0) DEFAULT NULL,
  PRIMARY KEY (`id_Invoice`,`id_Product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `invoice` (
  `id_Invoice` char(6) NOT NULL,
  `id_Cus` char(6) NOT NULL,
  `date` date DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `usePoint` decimal(5,0) DEFAULT NULL,
  `price_Invoice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_Invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `product` (
  `id` char(6) NOT NULL,
  `name` varchar(255) NOT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
BEGIN;
LOCK TABLES `qlcuahangquanao`.`customer` WRITE;
DELETE FROM `qlcuahangquanao`.`customer`;
INSERT INTO `qlcuahangquanao`.`customer` (`id`,`name`,`phone`,`typeCard`,`point`,`dateSD`,`email`,`dob`) VALUES ('C001', 'Nguyễn Thị Thủy', '0237569411', 'Thành viên Vàng', 3035, '2022-06-08', 'thuy@gmail.com', '1985-02-21'),('C002', 'Trần Lê Hòa Nam', '0985611455', 'Thành viên Đồng', 1258, '2022-06-08', 'nam@gmail.com', '2000-02-19'),('C003', 'Lâm Lệ Châu', '0155214455', 'Thành viên Đồng', 2014, '2022-06-08', 'chau@gmail.com', '2004-02-01'),('C004', 'Trương Hoàng Vũ', '0351655555', 'Thành viên Bạc', 3598, '2022-06-08', 'vu@gmail.com', '1997-02-01');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `qlcuahangquanao`.`detailedinvoice` WRITE;
DELETE FROM `qlcuahangquanao`.`detailedinvoice`;
INSERT INTO `qlcuahangquanao`.`detailedinvoice` (`id_Invoice`,`id_Product`,`quantity`) VALUES ('HD0', 'SP001', 1),('HD0', 'SP004', 1),('HD0', 'SP005', 2),('HD1', 'SP001', 2),('HD1', 'SP003', 1),('HD2', 'SP001', 5),('HD2', 'SP003', 1),('HD3', 'SP001', 4);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `qlcuahangquanao`.`invoice` WRITE;
DELETE FROM `qlcuahangquanao`.`invoice`;
INSERT INTO `qlcuahangquanao`.`invoice` (`id_Invoice`,`id_Cus`,`date`,`price`,`discount`,`usePoint`,`price_Invoice`) VALUES ('HD0', 'C001', '2021-06-07', 912000.00, 10000.00, 200, 900000),('HD1', 'C003', '2021-06-07', 375000.00, 0.00, 0, 375000),('HD2', 'C001', '2021-06-08', 450000.00, 50000.00, 1000, 390000),('HD3', 'C001', '2021-06-09', 100000.00, 15000.00, 1200, 73000);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `qlcuahangquanao`.`product` WRITE;
DELETE FROM `qlcuahangquanao`.`product`;
INSERT INTO `qlcuahangquanao`.`product` (`id`,`name`,`unit`,`price`) VALUES ('SP001', 'Áo len lạnh', 'cái', 25000.00),('SP002', 'Đồ ngủ ABC', 'bộ', 120000.00),('SP003', 'Áo len cho nam', 'cái', 325000.00),('SP004', 'Quần jeans nam', 'cái', 295000.00),('SP005', 'Váy xếp li', 'cái', 296000.00);
UNLOCK TABLES;
COMMIT;
