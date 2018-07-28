/*
Navicat MySQL Data Transfer

Source Server         : MyFirst
Source Server Version : 50610
Source Host           : 127.0.0.1:3306
Source Database       : first

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2018-07-28 10:08:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `parent` int(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '', '0', '菜单1');
INSERT INTO `power` VALUES ('2', '', '0', '菜单2');
INSERT INTO `power` VALUES ('3', 'power.action', '1', '功能1');
INSERT INTO `power` VALUES ('4', 'powe.jsp', '1', '功能2');
INSERT INTO `power` VALUES ('5', 'power.jsp', '2', '功能3');
INSERT INTO `power` VALUES ('6', 'power.jsp', '2', '功能4');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '666');
INSERT INTO `role` VALUES ('2', '普通用户', '888');

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) NOT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rpid` (`r_id`),
  KEY `fk_prid` (`p_id`),
  CONSTRAINT `fk_prid` FOREIGN KEY (`p_id`) REFERENCES `power` (`id`),
  CONSTRAINT `fk_rpid` FOREIGN KEY (`r_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_power
-- ----------------------------
INSERT INTO `role_power` VALUES ('1', '1', '3');
INSERT INTO `role_power` VALUES ('2', '1', '4');
INSERT INTO `role_power` VALUES ('3', '1', '1');
INSERT INTO `role_power` VALUES ('4', '2', '2');
INSERT INTO `role_power` VALUES ('5', '2', '5');
INSERT INTO `role_power` VALUES ('6', '2', '6');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('19', 'hechaoqi', '3509c95a270b9c9d3c2ff43bc1351e2f');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rid` (`r_id`),
  KEY `fk_uid` (`u_id`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`r_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '19');
INSERT INTO `user_role` VALUES ('2', '2', '19');
