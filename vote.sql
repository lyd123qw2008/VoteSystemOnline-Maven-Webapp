/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : vote1

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-05-25 01:11:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `logintime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO admin VALUES ('4', 'admin', '815fc3d1a7727fc5d3d5ae67d9e9b02d', '2017-05-01 13:57:07');
INSERT INTO admin VALUES ('5', 'admin1', '6621ea8d8d99f9950431947ae211977d', '2017-04-14 17:20:36');
INSERT INTO admin VALUES ('6', '张三', '123456', '2017-05-03 12:04:55');
INSERT INTO admin VALUES ('7', 'test', 'test', '2017-05-03 12:04:55');
INSERT INTO admin VALUES ('8', '1', '1', '2017-05-03 15:52:05');

-- ----------------------------
-- Table structure for `vote`
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `createdate` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `publish` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO vote VALUES ('1', '兴趣', '2017-04-14 17:15:25', '0', '1', '4');
INSERT INTO vote VALUES ('2', '喜爱的明星', '2017-04-14 17:21:43', '1', '1', '5');

-- ----------------------------
-- Table structure for `votecontext`
-- ----------------------------
DROP TABLE IF EXISTS `votecontext`;
CREATE TABLE `votecontext` (
  `votecontext_id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(50) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  `vote_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`votecontext_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of votecontext
-- ----------------------------
INSERT INTO votecontext VALUES ('1', '篮球', '1', '1');
INSERT INTO votecontext VALUES ('2', '兵乓球', '0', '1');
INSERT INTO votecontext VALUES ('3', '足球', '0', '1');
INSERT INTO votecontext VALUES ('4', '羽毛球', '0', '1');
INSERT INTO votecontext VALUES ('5', '周星驰', '0', '2');
INSERT INTO votecontext VALUES ('6', '刘德华', '0', '2');
INSERT INTO votecontext VALUES ('7', '周润发', '1', '2');

-- ----------------------------
-- Table structure for `voter`
-- ----------------------------
DROP TABLE IF EXISTS `voter`;
CREATE TABLE `voter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk ROW_FORMAT=REDUNDANT;

-- ----------------------------
-- Records of voter
-- ----------------------------
INSERT INTO voter VALUES ('1', '1', '127.0.0.1');
INSERT INTO voter VALUES ('2', '2', '127.0.0.1');
