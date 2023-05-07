/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 07/05/2023 09:18:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_act
-- ----------------------------
DROP TABLE IF EXISTS `t_act`;
CREATE TABLE `t_act` (
  `id` bigint NOT NULL COMMENT '主键',
  `actno` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户名',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_act
-- ----------------------------
BEGIN;
INSERT INTO `t_act` (`id`, `actno`, `balance`) VALUES (1, 'ben', 50000.00);
INSERT INTO `t_act` (`id`, `actno`, `balance`) VALUES (2, 'alex', 0.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
