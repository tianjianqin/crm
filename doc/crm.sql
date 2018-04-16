/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : crm1

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-04-16 09:31:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `consultrecord`
-- ----------------------------
DROP TABLE IF EXISTS `consultrecord`;
CREATE TABLE `consultrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customId` int(11) NOT NULL,
  `consultManId` int(11) NOT NULL,
  `consultStatu` char(1) NOT NULL,
  `consultDate` datetime NOT NULL,
  `result` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customId` (`customId`),
  KEY `consultManId` (`consultManId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consultrecord
-- ----------------------------
INSERT INTO `consultrecord` VALUES ('1', '8', '7', '3', '2017-11-16 00:00:00', '客户没有意向');
INSERT INTO `consultrecord` VALUES ('2', '10', '33', '2', '2017-11-16 00:00:00', '客户很好说话');
INSERT INTO `consultrecord` VALUES ('3', '11', '7', '0', '2017-11-16 00:00:00', null);
INSERT INTO `consultrecord` VALUES ('4', '12', '33', '0', '2017-11-16 00:00:00', null);
INSERT INTO `consultrecord` VALUES ('5', '13', '7', '0', '2017-11-16 00:00:00', null);
INSERT INTO `consultrecord` VALUES ('6', '14', '33', '2', '2017-11-16 00:00:00', '客户很爽快');
INSERT INTO `consultrecord` VALUES ('7', '15', '7', '0', '2017-11-16 00:00:00', null);
INSERT INTO `consultrecord` VALUES ('8', '16', '33', '1', '2017-11-16 00:00:00', '回家考虑');
INSERT INTO `consultrecord` VALUES ('9', '17', '7', '0', '2017-11-16 00:00:00', null);
INSERT INTO `consultrecord` VALUES ('10', '18', '33', '3', '2017-11-16 00:00:00', '');
INSERT INTO `consultrecord` VALUES ('11', '19', '7', '1', '2017-11-16 00:00:00', '');
INSERT INTO `consultrecord` VALUES ('12', '26', '33', '0', '2018-03-22 16:34:32', null);
INSERT INTO `consultrecord` VALUES ('13', '24', '7', '0', '2018-03-22 16:34:32', null);
INSERT INTO `consultrecord` VALUES ('14', '23', '33', '0', '2018-03-22 16:34:32', null);
INSERT INTO `consultrecord` VALUES ('15', '29', '7', '0', '2018-04-03 17:08:49', null);

-- ----------------------------
-- Table structure for `custom`
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `name` char(30) NOT NULL COMMENT '客户姓名',
  `education` char(20) DEFAULT NULL COMMENT '教育水平',
  `phoneNo` char(20) DEFAULT NULL COMMENT '手机号',
  `qq` char(20) NOT NULL COMMENT 'QQ',
  `email` char(30) DEFAULT NULL COMMENT '邮箱',
  `customStatu` char(1) NOT NULL COMMENT '客户状态',
  `createDate` datetime DEFAULT NULL COMMENT '创建日期',
  `inviteName` char(30) DEFAULT NULL COMMENT '邀请人姓名',
  PRIMARY KEY (`id`,`customStatu`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('1', '张三', '本科', '15678976754', '1234567896', '1456326598@qq.com', '2', '2017-11-08 09:00:00', '李白11');
INSERT INTO `custom` VALUES ('2', 'Lisi', '硕士', '56987415501', '123654783', '123654783@qq.com', '2', '2017-11-13 00:00:00', '李白');
INSERT INTO `custom` VALUES ('3', '波比', '专科', '13625645689', '1236547895', '1456326598@qq.com', '4', '2017-11-13 00:00:00', '曹操');
INSERT INTO `custom` VALUES ('4', '陈小春', '硕士', '13565845687', '1456326598', '1456326598@qq.com', '2', '2017-11-14 00:00:00', '周杰伦');
INSERT INTO `custom` VALUES ('5', '黄晓明', '博士', '16589456587', '23654568', '23654568@qq.com', '2', '2017-11-14 00:00:00', '周杰伦');
INSERT INTO `custom` VALUES ('6', '王宝强', '博士', '15235654214', '136542369', '136542369@qq.com', '2', '2017-11-14 00:00:00', '王祖蓝');
INSERT INTO `custom` VALUES ('7', '张撒', '高中', '15649856547', '123656666', '1236547895@qq.com', '4', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('8', '李四', '高中', '16954263214', '1156986514', '1569865145@qq.com', '4', '2017-11-14 00:00:00', '曹操');
INSERT INTO `custom` VALUES ('9', '王麻子', '初中', '13625421232', '1542365452', '1542365452@qq.com', '2', '2017-11-14 00:00:00', '曹操');
INSERT INTO `custom` VALUES ('10', '猴子', '初中', '136254216587', '1542366987', '1542366987@qq.com', '3', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('11', '牛魔', '初中', '136254296541', '154236699', '1542366987@qq.com', '3', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('12', '鬼谷子', '本科', '136254296543', '1542366998', '1542366988@qq.com', '3', '2017-11-14 00:00:00', '妲己');
INSERT INTO `custom` VALUES ('13', '猴子', '初中', '13625421658', '1542366987', '1542366987@qq.com', '3', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('14', '牛魔', '初中', '13625429654', '154236699', '1542366987@qq.com', '3', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('15', '鬼谷子', '本科', '13625429658', '1542366998', '1542366988@qq.com', '3', '2017-11-14 00:00:00', '妲己');
INSERT INTO `custom` VALUES ('16', '大漠', '硕士', '13625429657', '1542366998', '1542366988@qq.com', '3', '2017-11-14 00:00:00', '妲己');
INSERT INTO `custom` VALUES ('17', '小法', '专科', '16587456235', '256984563', '1236547895@qq.com', '3', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('18', '打法', '专科', '19865232514', '326598542', '326598542@qq.com', '4', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('19', '大师', '专科', '19865232543', '326598542', '326598542@qq.com', '2', '2017-11-14 00:00:00', '李白');
INSERT INTO `custom` VALUES ('22', '李湘', '博士', '15678976754', '1456326598', '1456326598@qq.com', '4', '2017-11-17 00:00:00', '贾樟柯');
INSERT INTO `custom` VALUES ('23', '张杰', '本科', '15865241421', '124521421', '124521421@qq.com', '3', '2018-03-19 00:00:00', '');
INSERT INTO `custom` VALUES ('24', '高解', '本科', '18754123254', '1523625362', '1523625362@qq.com', '3', '2018-03-21 00:00:00', '李浩');
INSERT INTO `custom` VALUES ('25', '李科', '专科', '18754123253', '1523625363', '1523625363@qq.com', '2', '2018-03-21 13:02:56', '高解');
INSERT INTO `custom` VALUES ('26', '黄琪', '专科', '18754123255', '1523625364', '1523625364@qq.com', '3', '2018-03-21 10:05:07', '高帅');
INSERT INTO `custom` VALUES ('27', '白灵', '本科', '18754253625', '526584154', '526584154@qq.com', '2', '2018-03-28 00:00:00', '赵四');
INSERT INTO `custom` VALUES ('28', '胡一天', '本科', '15632563625', '895623652', '895623652@qq.com', '2', '2018-03-28 00:00:00', '');
INSERT INTO `custom` VALUES ('29', '百晓', '本科', '15263254124', '1523632514', '1523632514@qq.com', '3', '2018-04-03 00:00:00', '李飞');
INSERT INTO `custom` VALUES ('30', '胡哥', '本科', '15958452142', '25365251', '25365251@qq.com', '2', '2018-04-03 00:00:00', '');
INSERT INTO `custom` VALUES ('31', '窦骁', '本科', '13626254124', '632565214', '632565214@163.com', '2', '2018-04-03 00:00:00', '');

-- ----------------------------
-- Table structure for `custominfo`
-- ----------------------------
DROP TABLE IF EXISTS `custominfo`;
CREATE TABLE `custominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customId` int(11) NOT NULL,
  `followManId` int(11) NOT NULL,
  `statu` char(1) DEFAULT NULL,
  `startDate` datetime NOT NULL COMMENT '创建日期',
  `lastFollowDate` datetime DEFAULT NULL COMMENT '下次联系日期',
  `planDate` datetime DEFAULT NULL COMMENT '计划联系日期',
  `mark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customId` (`customId`),
  KEY `followManId` (`followManId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custominfo
-- ----------------------------
INSERT INTO `custominfo` VALUES ('1', '1', '29', '2', '2017-11-15 00:00:00', '2018-03-24 19:17:22', null, '客户有意向，很好沟通');
INSERT INTO `custominfo` VALUES ('2', '2', '30', '2', '2017-11-15 00:00:00', '2017-11-16 00:00:00', '2017-11-19 00:00:00', '哈哈哈');
INSERT INTO `custominfo` VALUES ('3', '3', '29', '4', '2017-11-15 00:00:00', '2017-11-18 00:00:00', null, null);
INSERT INTO `custominfo` VALUES ('4', '4', '30', '3', '2017-11-15 00:00:00', '2017-11-17 00:00:00', '2017-11-19 00:00:00', '');
INSERT INTO `custominfo` VALUES ('5', '5', '29', '2', '2017-11-17 00:00:00', '2018-03-22 14:05:04', '2018-03-28 17:23:15', null);
INSERT INTO `custominfo` VALUES ('6', '6', '30', '0', '2017-11-15 00:00:00', '2017-11-16 00:00:00', null, '');
INSERT INTO `custominfo` VALUES ('7', '7', '29', '4', '2017-11-17 00:00:00', '2018-03-25 00:15:56', null, '无意向');
INSERT INTO `custominfo` VALUES ('8', '9', '30', '0', '2017-11-15 00:00:00', '2017-11-17 00:00:00', null, null);
INSERT INTO `custominfo` VALUES ('9', '22', '34', '4', '2017-11-17 00:00:00', '2017-11-18 00:00:00', '2017-11-20 00:00:00', '回家考虑');
INSERT INTO `custominfo` VALUES ('10', '25', '30', '0', '2018-03-22 16:29:20', null, null, null);
INSERT INTO `custominfo` VALUES ('11', '19', '29', '0', '2018-03-22 16:29:36', null, null, null);
INSERT INTO `custominfo` VALUES ('12', '28', '29', '0', '2018-03-28 15:19:34', null, null, null);
INSERT INTO `custominfo` VALUES ('13', '27', '29', '2', '2018-03-28 15:19:34', '2018-03-28 16:45:40', '2018-04-03 17:09:31', null);
INSERT INTO `custominfo` VALUES ('14', '31', '29', '0', '2018-04-03 17:08:24', null, null, null);
INSERT INTO `custominfo` VALUES ('15', '30', '29', '0', '2018-04-03 17:08:24', null, null, null);

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '技术部');
INSERT INTO `department` VALUES ('2', '电话销售部');
INSERT INTO `department` VALUES ('3', '线上咨询部');
INSERT INTO `department` VALUES ('4', '线下咨询部');
INSERT INTO `department` VALUES ('5', '销售支持部');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(30) NOT NULL,
  `password` char(18) NOT NULL,
  `nickname` char(30) NOT NULL,
  `realname` char(30) NOT NULL,
  `jobInfoId` int(11) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `phoneNo` char(11) NOT NULL,
  `officeTel` char(11) NOT NULL,
  `workStatu` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobInfoId` (`jobInfoId`),
  KEY `departmentId` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'superadmin', '123456', '老李', '李嘉诚', '1', '1', '16868686868', '110110', '1');
INSERT INTO `employee` VALUES ('2', '1', '1', '黑马', '黑马', '1', '1', '1', '1', '1');
INSERT INTO `employee` VALUES ('3', '2', '2', 'hello', '哈罗', '2', '1', '11111111111', '222222', '1');
INSERT INTO `employee` VALUES ('7', 'abc@abc.com', '123456', '飞飞', '李飞', '3', '4', '14568978654', '123456897', '1');
INSERT INTO `employee` VALUES ('18', 'dianhua@163.com', '123456', '孩子', '哪吒', '8', '2', '15678946521', '456987566', '1');
INSERT INTO `employee` VALUES ('19', 'dianhuaadmin@163.com', '123456', '三只眼', '杨戬', '9', '2', '16589563214', '456213235', '1');
INSERT INTO `employee` VALUES ('26', 'admin', '123456', '小马', '马云', '2', '1', '12365478954', '12365212', '1');
INSERT INTO `employee` VALUES ('27', 'zixunadmin@163.com', '123456', '小白', '百丈潭', '4', '4', '15649874562', '362541', '1');
INSERT INTO `employee` VALUES ('28', 'xiaoshou@163.com', '123456', '魔王', '李白', '7', '5', '15632456954', '362541', '1');
INSERT INTO `employee` VALUES ('29', 'dianhua1@163.com', '123456', '老杨', '杨树林', '8', '2', '15698541232', '658956', '1');
INSERT INTO `employee` VALUES ('30', 'dianhua2@163.com', '123456', '大白', '白路', '8', '2', '13625469584', '3625412', '1');
INSERT INTO `employee` VALUES ('33', 'zixun@163.com', '123456', '小凯', '王凯', '3', '4', '15698563215', '3625654', '1');
INSERT INTO `employee` VALUES ('34', 'wangzi@163.com', '123456', '老贾', '贾樟柯', '5', '3', '13625466952', '3625142', '1');
INSERT INTO `employee` VALUES ('35', 'wangziadmin@163.com', '123456', '老李', '李云龙', '6', '3', '15978563214', '3625654', '1');
INSERT INTO `employee` VALUES ('37', '3', '3', '岳不群', '岳不群', '2', '1', '13312341001', '110510', '1');
INSERT INTO `employee` VALUES ('38', '4', '4', '4', '4', '2', '1', '12345612310', '520', '1');
INSERT INTO `employee` VALUES ('39', 'maike@163.com', '123456', '麦克', '麦克', '2', '1', '15645621230', '5689421', '1');
INSERT INTO `employee` VALUES ('43', 'tianjianqin', '888888', '太阳', '田建勤', '2', '1', '15979089491', '88888', '1');
INSERT INTO `employee` VALUES ('44', 'lingshuhao', '123456', '林疯子', '林书豪', '5', '3', '18816813564', '787878', '1');
INSERT INTO `employee` VALUES ('45', 'zhaosi', '123456', '老四', '赵四', '2', '1', '16523202120', '989898', '1');
INSERT INTO `employee` VALUES ('46', 'longxiaoyu', '123456', '小雨', '龙小雨', '3', '4', '16523012012', '110120119', '1');

-- ----------------------------
-- Table structure for `jobinfo`
-- ----------------------------
DROP TABLE IF EXISTS `jobinfo`;
CREATE TABLE `jobinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` char(30) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `remarks` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobinfo
-- ----------------------------
INSERT INTO `jobinfo` VALUES ('1', '超级管理员', '1', null);
INSERT INTO `jobinfo` VALUES ('2', '管理员', '1', null);
INSERT INTO `jobinfo` VALUES ('3', '咨询师', '4', null);
INSERT INTO `jobinfo` VALUES ('4', '咨询师主管', '4', null);
INSERT INTO `jobinfo` VALUES ('5', '网络咨询', '3', null);
INSERT INTO `jobinfo` VALUES ('6', '网络咨询主管', '3', null);
INSERT INTO `jobinfo` VALUES ('7', '销售助理', '5', null);
INSERT INTO `jobinfo` VALUES ('8', '电话销售员', '2', null);
INSERT INTO `jobinfo` VALUES ('9', '电话销售主管', '2', null);

-- ----------------------------
-- Table structure for `jobright`
-- ----------------------------
DROP TABLE IF EXISTS `jobright`;
CREATE TABLE `jobright` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobInfoId` int(11) NOT NULL,
  `rightId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobright
-- ----------------------------
INSERT INTO `jobright` VALUES ('1', '1', '1');
INSERT INTO `jobright` VALUES ('2', '1', '5');
INSERT INTO `jobright` VALUES ('3', '1', '14');
INSERT INTO `jobright` VALUES ('4', '2', '5');
INSERT INTO `jobright` VALUES ('5', '3', '28');
INSERT INTO `jobright` VALUES ('6', '3', '33');
INSERT INTO `jobright` VALUES ('9', '5', '14');
INSERT INTO `jobright` VALUES ('10', '5', '20');
INSERT INTO `jobright` VALUES ('11', '5', '24');
INSERT INTO `jobright` VALUES ('12', '5', '33');
INSERT INTO `jobright` VALUES ('13', '6', '24');
INSERT INTO `jobright` VALUES ('14', '6', '31');
INSERT INTO `jobright` VALUES ('15', '6', '33');
INSERT INTO `jobright` VALUES ('16', '7', '5');
INSERT INTO `jobright` VALUES ('17', '7', '14');
INSERT INTO `jobright` VALUES ('18', '7', '20');
INSERT INTO `jobright` VALUES ('19', '8', '14');
INSERT INTO `jobright` VALUES ('20', '8', '24');
INSERT INTO `jobright` VALUES ('21', '8', '33');
INSERT INTO `jobright` VALUES ('22', '9', '24');
INSERT INTO `jobright` VALUES ('23', '9', '31');
INSERT INTO `jobright` VALUES ('24', '9', '33');
INSERT INTO `jobright` VALUES ('25', '1', '2');
INSERT INTO `jobright` VALUES ('26', '1', '3');
INSERT INTO `jobright` VALUES ('27', '1', '4');
INSERT INTO `jobright` VALUES ('28', '1', '6');
INSERT INTO `jobright` VALUES ('29', '1', '7');
INSERT INTO `jobright` VALUES ('30', '1', '8');
INSERT INTO `jobright` VALUES ('31', '1', '15');
INSERT INTO `jobright` VALUES ('32', '1', '16');
INSERT INTO `jobright` VALUES ('33', '2', '6');
INSERT INTO `jobright` VALUES ('34', '2', '7');
INSERT INTO `jobright` VALUES ('35', '2', '11');
INSERT INTO `jobright` VALUES ('38', '3', '29');
INSERT INTO `jobright` VALUES ('39', '3', '30');
INSERT INTO `jobright` VALUES ('40', '3', '35');
INSERT INTO `jobright` VALUES ('43', '5', '19');
INSERT INTO `jobright` VALUES ('44', '5', '21');
INSERT INTO `jobright` VALUES ('45', '5', '22');
INSERT INTO `jobright` VALUES ('46', '5', '25');
INSERT INTO `jobright` VALUES ('47', '5', '26');
INSERT INTO `jobright` VALUES ('48', '5', '34');
INSERT INTO `jobright` VALUES ('49', '6', '27');
INSERT INTO `jobright` VALUES ('50', '6', '32');
INSERT INTO `jobright` VALUES ('51', '6', '34');
INSERT INTO `jobright` VALUES ('52', '7', '12');
INSERT INTO `jobright` VALUES ('53', '7', '13');
INSERT INTO `jobright` VALUES ('54', '7', '17');
INSERT INTO `jobright` VALUES ('55', '7', '18');
INSERT INTO `jobright` VALUES ('56', '7', '21');
INSERT INTO `jobright` VALUES ('57', '7', '22');
INSERT INTO `jobright` VALUES ('58', '7', '23');
INSERT INTO `jobright` VALUES ('59', '8', '19');
INSERT INTO `jobright` VALUES ('60', '8', '25');
INSERT INTO `jobright` VALUES ('61', '8', '26');
INSERT INTO `jobright` VALUES ('62', '8', '34');
INSERT INTO `jobright` VALUES ('63', '9', '27');
INSERT INTO `jobright` VALUES ('64', '9', '32');
INSERT INTO `jobright` VALUES ('65', '9', '34');
INSERT INTO `jobright` VALUES ('66', '10', '31');
INSERT INTO `jobright` VALUES ('67', '10', '32');
INSERT INTO `jobright` VALUES ('68', '10', '33');
INSERT INTO `jobright` VALUES ('69', '10', '34');
INSERT INTO `jobright` VALUES ('70', '10', '35');
INSERT INTO `jobright` VALUES ('73', '4', '31');
INSERT INTO `jobright` VALUES ('74', '4', '32');
INSERT INTO `jobright` VALUES ('75', '4', '33');
INSERT INTO `jobright` VALUES ('76', '4', '35');

-- ----------------------------
-- Table structure for `resetpass`
-- ----------------------------
DROP TABLE IF EXISTS `resetpass`;
CREATE TABLE `resetpass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(30) NOT NULL,
  `phoneNo` char(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resetpass
-- ----------------------------
INSERT INTO `resetpass` VALUES ('6', 'tianjianqin', '15979089491');

-- ----------------------------
-- Table structure for `rights`
-- ----------------------------
DROP TABLE IF EXISTS `rights`;
CREATE TABLE `rights` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(40) NOT NULL,
  `rightType` char(1) NOT NULL,
  `url` char(100) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rights
-- ----------------------------
INSERT INTO `rights` VALUES ('1', '权限管理', '1', '', '1');
INSERT INTO `rights` VALUES ('2', '增加职位权限', '2', 'jobinfo_list.html', '1');
INSERT INTO `rights` VALUES ('3', '修改职位权限', '2', 'jobinfo_list.html', '1');
INSERT INTO `rights` VALUES ('4', '删除职位权限', '2', 'jobinfo_list.html', '1');
INSERT INTO `rights` VALUES ('5', '账号管理', '1', null, '5');
INSERT INTO `rights` VALUES ('6', '添加员工账号', '2', 'employee_list.jsp', '5');
INSERT INTO `rights` VALUES ('7', '删除员工账号', '2', 'employee_list.jsp', '5');
INSERT INTO `rights` VALUES ('8', '查看员工信息', '2', 'employee_list.jsp', '5');
INSERT INTO `rights` VALUES ('11', '重置用户密码', '2', 'employee_resetpass_list.html', '5');
INSERT INTO `rights` VALUES ('12', '查询所有销售员工', '2', 'sale_employee_list.html', '5');
INSERT INTO `rights` VALUES ('13', '查询所有咨询员工', '2', 'consult_employee_list.html', '5');
INSERT INTO `rights` VALUES ('14', '报表管理', '1', null, '14');
INSERT INTO `rights` VALUES ('15', '查询所有员工', '2', 'employee_list.jsp', '14');
INSERT INTO `rights` VALUES ('16', '查询所有客户', '2', 'custom_list.html', '14');
INSERT INTO `rights` VALUES ('17', '客户信息导入', '2', 'custom_import_export.html', '14');
INSERT INTO `rights` VALUES ('18', '客户信息导出', '2', 'custom_import_export.html', '14');
INSERT INTO `rights` VALUES ('19', '导出客户开发报表', '2', 'custominfo_export.html', '14');
INSERT INTO `rights` VALUES ('20', '客户资料', '1', null, '20');
INSERT INTO `rights` VALUES ('21', '添加客户信息', '2', 'custom_list.html', '20');
INSERT INTO `rights` VALUES ('22', '修改客户信息', '2', 'custom_list.html', '20');
INSERT INTO `rights` VALUES ('23', '分配客户', '2', 'distribute_sale.html', '20');
INSERT INTO `rights` VALUES ('24', '客户开发', '1', null, '24');
INSERT INTO `rights` VALUES ('25', '查看客户开发信息', '2', 'custominfo_list.html', '24');
INSERT INTO `rights` VALUES ('26', '修改客户开发信息', '2', 'custominfo_list.html', '24');
INSERT INTO `rights` VALUES ('27', '员工客户开发信息', '2', 'custominfo_query.html', '24');
INSERT INTO `rights` VALUES ('28', '客户咨询', '1', null, '28');
INSERT INTO `rights` VALUES ('29', '查看客户咨询信息', '2', 'consultrecord_list.html', '28');
INSERT INTO `rights` VALUES ('30', '修改客户咨询信息', '2', 'consultrecord_list.html', '28');
INSERT INTO `rights` VALUES ('31', '部门管理', '1', null, '31');
INSERT INTO `rights` VALUES ('32', '查看部门员工信息', '2', 'employee_query.html', '31');
INSERT INTO `rights` VALUES ('33', '统计数据', '1', null, '33');
INSERT INTO `rights` VALUES ('34', '客户开发统计数据', '2', 'custominfo_data.html', '33');
INSERT INTO `rights` VALUES ('35', '客户咨询统计数据', '2', 'consultrecord_data.html', '33');
