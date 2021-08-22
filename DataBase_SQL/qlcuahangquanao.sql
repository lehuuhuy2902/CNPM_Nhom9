/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : qlcuahangquanao

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 23/06/2021 11:14:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `typeCard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `point` decimal(5, 0) NULL DEFAULT NULL,
  `dateSD` date NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `dob` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('C000', 'Khách Vãng Lai', '0000000000', '', 0, '1900-01-01', 'vanglai@gmail.com', '1900-01-01');
INSERT INTO `customer` VALUES ('C001', 'Nguyễn Thị Thủy', '0237569411', 'Thành viên Vàng', 3038, '2022-06-08', 'thuy@gmail.com', '1985-02-21');
INSERT INTO `customer` VALUES ('C002', 'Trần Lê Hòa Nam', '0985611455', 'Thành viên Đồng', 1258, '2022-06-08', 'nam@gmail.com', '2000-02-19');
INSERT INTO `customer` VALUES ('C003', 'Lâm Lệ Châu', '0155214455', 'Thành viên Đồng', 2014, '2022-06-08', 'chau@gmail.com', '2004-02-01');
INSERT INTO `customer` VALUES ('C004', 'Trương Hoàng Vũ', '0351655555', 'Thành viên Bạc', 3598, '2022-06-08', 'vu@gmail.com', '1997-02-01');

-- ----------------------------
-- Table structure for detailedinvoice
-- ----------------------------
DROP TABLE IF EXISTS `detailedinvoice`;
CREATE TABLE `detailedinvoice`  (
  `id_Invoice` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_Product` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` decimal(4, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Invoice`, `id_Product`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of detailedinvoice
-- ----------------------------
INSERT INTO `detailedinvoice` VALUES ('HD0', 'SP001', 1);
INSERT INTO `detailedinvoice` VALUES ('HD0', 'SP004', 1);
INSERT INTO `detailedinvoice` VALUES ('HD0', 'SP005', 2);
INSERT INTO `detailedinvoice` VALUES ('HD1', 'SP001', 2);
INSERT INTO `detailedinvoice` VALUES ('HD1', 'SP003', 1);
INSERT INTO `detailedinvoice` VALUES ('HD2', 'SP001', 5);
INSERT INTO `detailedinvoice` VALUES ('HD2', 'SP003', 1);
INSERT INTO `detailedinvoice` VALUES ('HD3', 'SP001', 4);
INSERT INTO `detailedinvoice` VALUES ('HD4', 'SP001', 1);
INSERT INTO `detailedinvoice` VALUES ('HD5', 'SP001', 1);
INSERT INTO `detailedinvoice` VALUES ('HD6', 'SP001', 1);
INSERT INTO `detailedinvoice` VALUES ('HD7', 'SP001', 7);
INSERT INTO `detailedinvoice` VALUES ('HD8', 'SP001', 1);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone_number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (0, 'Hồ Quốc Chung', 'Male', 44, 'admin', 393777466);
INSERT INTO `employee` VALUES (1, 'Nguyen Van Hung', 'Male', 35, 'admin', 325987463);
INSERT INTO `employee` VALUES (2, 'Le Quoc Dat', 'Male', 35, 'bán hàng', 988667667);
INSERT INTO `employee` VALUES (3, 'Lê Thị Tuyết Hoa', 'Female', 29, 'kho', 995443455);

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice`  (
  `id_Invoice` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_Cus` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `date` date NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `discount` decimal(10, 2) NULL DEFAULT NULL,
  `usePoint` decimal(5, 0) NULL DEFAULT NULL,
  `price_Invoice` decimal(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Invoice`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of invoice
-- ----------------------------
INSERT INTO `invoice` VALUES ('HD0', 'C001', '2021-06-07', 912000.00, 10000.00, 200, 900000);
INSERT INTO `invoice` VALUES ('HD1', 'C003', '2021-06-07', 375000.00, 0.00, 0, 375000);
INSERT INTO `invoice` VALUES ('HD2', 'C001', '2021-06-08', 450000.00, 50000.00, 1000, 390000);
INSERT INTO `invoice` VALUES ('HD3', 'C001', '2021-06-09', 100000.00, 15000.00, 1200, 73000);
INSERT INTO `invoice` VALUES ('HD4', 'C001', '2021-06-22', 25000.00, 10000.00, 11, 14890);
INSERT INTO `invoice` VALUES ('HD5', 'C001', '2021-06-22', 25000.00, 4000000.00, -14, -3974860);
INSERT INTO `invoice` VALUES ('HD6', 'C001', '2021-06-22', 25000.00, 0.00, 0, 25000);
INSERT INTO `invoice` VALUES ('HD7', 'C001', '2021-06-22', 175000.00, 0.00, 0, 175000);
INSERT INTO `invoice` VALUES ('HD8', 'C001', '2021-06-22', 25000.00, 0.00, 0, 25000);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `addDate` date NULL DEFAULT NULL,
  `quatity` int(255) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('SP001', 'Áo len lạnh', 'cái', 25000.00, '2021-06-02', 10, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP002', 'Đồ ngủ ABC', 'bộ', 320000.00, '2021-06-22', 12, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP003', 'Áo khoác hoddie basic', 'cái', 115000.00, '2021-05-12', 3, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP004', 'Quần jeans nam', 'cái', 295000.00, '2021-06-09', 3, 'Ngừng Bán');
INSERT INTO `product` VALUES ('SP005', 'Váy xếp li', 'cái', 296000.00, '2021-05-03', 0, 'Hết Hàng');
INSERT INTO `product` VALUES ('SP006', 'Quần âu nam basic', 'cái', 250000.00, '2021-06-09', 10, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP007', 'Áo sơ mi tay dài', 'cái', 115000.00, '2021-05-17', 12, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP008', 'Quần thun sporty nữ', 'cái', 99000.00, '2021-04-12', 99, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP009', 'Quần lửng kaki', 'cái', 88000.00, '2021-06-02', 0, 'Hết Hàng');
INSERT INTO `product` VALUES ('SP010', 'Áo sơ mi tay ngắn', 'cái', 169000.00, '2021-05-02', 11, 'Ngừng Bán');
INSERT INTO `product` VALUES ('SP011', 'Áo fannel tay ngắn', 'cái', 123000.00, '2021-06-06', 2, 'Còn Hàng');
INSERT INTO `product` VALUES ('SP012', 'Quần kaki panda nâu', 'cái', 119000.00, '2021-05-03', 3, 'Còn Hàng');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123', NULL);
INSERT INTO `user` VALUES ('nguyenvannam', '456', NULL);

SET FOREIGN_KEY_CHECKS = 1;
