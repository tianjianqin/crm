/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - crm1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm1` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `crm1`;

/*Table structure for table `consultrecord` */

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `consultrecord` */

insert  into `consultrecord`(`id`,`customId`,`consultManId`,`consultStatu`,`consultDate`,`result`) values (1,8,7,'3','2017-11-16 00:00:00','客户没有意向'),(2,10,33,'2','2017-11-16 00:00:00','客户很好说话'),(3,11,7,'0','2017-11-16 00:00:00',NULL),(4,12,33,'0','2017-11-16 00:00:00',NULL),(5,13,7,'0','2017-11-16 00:00:00',NULL),(6,14,33,'2','2017-11-16 00:00:00','客户很爽快'),(7,15,7,'0','2017-11-16 00:00:00',NULL),(8,16,33,'1','2017-11-16 00:00:00','回家考虑'),(9,17,7,'0','2017-11-16 00:00:00',NULL),(10,18,33,'3','2017-11-16 00:00:00',''),(11,19,7,'0','2017-11-16 00:00:00',NULL),(12,26,33,'0','2018-03-22 16:34:32',NULL),(13,24,7,'0','2018-03-22 16:34:32',NULL),(14,23,33,'0','2018-03-22 16:34:32',NULL);

/*Table structure for table `custom` */

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `custom` */

insert  into `custom`(`id`,`name`,`education`,`phoneNo`,`qq`,`email`,`customStatu`,`createDate`,`inviteName`) values (1,'张三','本科','15678976754','1234567896','1456326598@qq.com','2','2017-11-08 09:00:00','李白11'),(2,'Lisi','硕士','56987415501','123654783','123654783@qq.com','2','2017-11-13 00:00:00','李白'),(3,'波比','专科','13625645689','1236547895','1456326598@qq.com','4','2017-11-13 00:00:00','曹操'),(4,'陈小春','硕士','13565845687','1456326598','1456326598@qq.com','2','2017-11-14 00:00:00','周杰伦'),(5,'黄晓明','博士','16589456587','23654568','23654568@qq.com','2','2017-11-14 00:00:00','周杰伦'),(6,'王宝强','博士','15235654214','136542369','136542369@qq.com','2','2017-11-14 00:00:00','王祖蓝'),(7,'张撒','高中','15649856547','123656666','1236547895@qq.com','4','2017-11-14 00:00:00','李白'),(8,'李四','高中','16954263214','1156986514','1569865145@qq.com','4','2017-11-14 00:00:00','曹操'),(9,'王麻子','初中','13625421232','1542365452','1542365452@qq.com','2','2017-11-14 00:00:00','曹操'),(10,'猴子','初中','136254216587','1542366987','1542366987@qq.com','3','2017-11-14 00:00:00','李白'),(11,'牛魔','初中','136254296541','154236699','1542366987@qq.com','3','2017-11-14 00:00:00','李白'),(12,'鬼谷子','本科','136254296543','1542366998','1542366988@qq.com','3','2017-11-14 00:00:00','妲己'),(13,'猴子','初中','13625421658','1542366987','1542366987@qq.com','3','2017-11-14 00:00:00','李白'),(14,'牛魔','初中','13625429654','154236699','1542366987@qq.com','3','2017-11-14 00:00:00','李白'),(15,'鬼谷子','本科','13625429658','1542366998','1542366988@qq.com','3','2017-11-14 00:00:00','妲己'),(16,'大漠','硕士','13625429657','1542366998','1542366988@qq.com','3','2017-11-14 00:00:00','妲己'),(17,'小法','专科','16587456235','256984563','1236547895@qq.com','3','2017-11-14 00:00:00','李白'),(18,'打法','专科','19865232514','326598542','326598542@qq.com','4','2017-11-14 00:00:00','李白'),(19,'大师','专科','19865232543','326598542','326598542@qq.com','2','2017-11-14 00:00:00','李白'),(22,'李湘','博士','15678976754','1456326598','1456326598@qq.com','4','2017-11-17 00:00:00','贾樟柯'),(23,'张杰','本科','15865241421','124521421','124521421@qq.com','3','2018-03-19 00:00:00',''),(24,'高解','本科','18754123254','1523625362','1523625362@qq.com','3','2018-03-21 00:00:00','李浩'),(25,'李科','专科','18754123253','1523625363','1523625363@qq.com','2','2018-03-21 13:02:56','高解'),(26,'黄琪','专科','18754123255','1523625364','1523625364@qq.com','3','2018-03-21 10:05:07','高帅');

/*Table structure for table `custominfo` */

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `custominfo` */

insert  into `custominfo`(`id`,`customId`,`followManId`,`statu`,`startDate`,`lastFollowDate`,`planDate`,`mark`) values (1,1,29,'2','2017-11-15 00:00:00','2018-03-24 19:17:22',NULL,'客户有意向，很好沟通'),(2,2,30,'2','2017-11-15 00:00:00','2017-11-16 00:00:00','2017-11-19 00:00:00','哈哈哈'),(3,3,29,'4','2017-11-15 00:00:00','2017-11-18 00:00:00',NULL,NULL),(4,4,30,'3','2017-11-15 00:00:00','2017-11-17 00:00:00','2017-11-19 00:00:00',''),(5,5,29,'0','2017-11-17 00:00:00',NULL,NULL,NULL),(6,6,30,'0','2017-11-15 00:00:00','2017-11-16 00:00:00',NULL,''),(7,7,29,'4','2017-11-17 00:00:00','2018-03-25 00:15:56',NULL,'无意向'),(8,9,30,'0','2017-11-15 00:00:00','2017-11-17 00:00:00',NULL,NULL),(9,22,34,'4','2017-11-17 00:00:00','2017-11-18 00:00:00','2017-11-20 00:00:00','回家考虑'),(10,25,30,'0','2018-03-22 16:29:20',NULL,NULL,NULL),(11,19,29,'0','2018-03-22 16:29:36',NULL,NULL,NULL);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`dname`) values (1,'技术部'),(2,'电话销售部'),(3,'线上咨询部'),(4,'线下咨询部'),(5,'销售支持部');

/*Table structure for table `employee` */

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`username`,`password`,`nickname`,`realname`,`jobInfoId`,`departmentId`,`phoneNo`,`officeTel`,`workStatu`) values (1,'superadmin','123456','老李','李嘉诚',1,1,'16868686868','110110','1'),(2,'1','1','黑马','黑马',1,1,'1','1','1'),(3,'2','2','hello','哈罗',2,1,'11111111111','222222','1'),(7,'abc@abc.com','123456','飞飞','李飞',3,4,'14568978654','123456897','1'),(18,'dianhua@163.com','123456','孩子','哪吒',8,2,'15678946521','456987566','1'),(19,'dianhuaadmin@163.com','123456','三只眼','杨戬',9,2,'16589563214','456213235','1'),(26,'admin','123456','小马','马云',2,1,'12365478954','12365212','1'),(27,'zixunadmin@163.com','123456','小白','百丈潭',4,4,'15649874562','362541','1'),(28,'xiaoshou@163.com','123456','魔王','李白',7,5,'15632456954','362541','1'),(29,'dianhua1@163.com','123456','老杨','杨树林',8,2,'15698541232','658956','1'),(30,'dianhua2@163.com','123456','大白','白路',8,2,'13625469584','3625412','1'),(33,'zixun@163.com','123456','小凯','王凯',3,4,'15698563215','3625654','1'),(34,'wangzi@163.com','123456','老贾','贾樟柯',5,3,'13625466952','3625142','1'),(35,'wangziadmin@163.com','123456','老李','李云龙',6,3,'15978563214','3625654','1'),(37,'3','3','岳不群','岳不群',2,1,'13312341001','110510','1'),(38,'4','4','4','4',2,1,'12345612310','520','1'),(39,'maike@163.com','123456','麦克','麦克',2,1,'15645621230','5689421','1'),(43,'tianjianqin','888888','太阳','田建勤',2,1,'15979089491','88888','1'),(44,'lingshuhao','123456','林疯子','林书豪',5,3,'18816813564','787878','1'),(45,'zhaosi','123456','老四','赵四',2,1,'16523202120','989898','1');

/*Table structure for table `jobinfo` */

DROP TABLE IF EXISTS `jobinfo`;

CREATE TABLE `jobinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job` char(30) NOT NULL,
  `departmentId` int(11) NOT NULL,
  `remarks` varchar(150) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `departmentId` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `jobinfo` */

insert  into `jobinfo`(`id`,`job`,`departmentId`,`remarks`) values (1,'超级管理员',1,NULL),(2,'管理员',1,NULL),(3,'咨询师',4,NULL),(4,'咨询师主管',4,NULL),(5,'网络咨询',3,NULL),(6,'网络咨询主管',3,NULL),(7,'销售助理',5,NULL),(8,'电话销售员',2,NULL),(9,'电话销售主管',2,NULL);

/*Table structure for table `jobright` */

DROP TABLE IF EXISTS `jobright`;

CREATE TABLE `jobright` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jobInfoId` int(11) NOT NULL,
  `rightId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `jobright` */

insert  into `jobright`(`id`,`jobInfoId`,`rightId`) values (1,1,1),(2,1,5),(3,1,14),(4,2,5),(5,3,28),(6,3,33),(7,4,31),(8,4,33),(9,5,14),(10,5,20),(11,5,24),(12,5,33),(13,6,24),(14,6,31),(15,6,33),(16,7,5),(17,7,14),(18,7,20),(19,8,14),(20,8,24),(21,8,33),(22,9,24),(23,9,31),(24,9,33),(25,1,2),(26,1,3),(27,1,4),(28,1,6),(29,1,7),(30,1,8),(31,1,15),(32,1,16),(33,2,6),(34,2,7),(35,2,11),(38,3,29),(39,3,30),(40,3,35),(41,4,32),(42,4,35),(43,5,19),(44,5,21),(45,5,22),(46,5,25),(47,5,26),(48,5,34),(49,6,27),(50,6,32),(51,6,34),(52,7,12),(53,7,13),(54,7,17),(55,7,18),(56,7,21),(57,7,22),(58,7,23),(59,8,19),(60,8,25),(61,8,26),(62,8,34),(63,9,27),(64,9,32),(65,9,34);

/*Table structure for table `resetpass` */

DROP TABLE IF EXISTS `resetpass`;

CREATE TABLE `resetpass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(30) NOT NULL,
  `phoneNo` char(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `resetpass` */

insert  into `resetpass`(`id`,`username`,`phoneNo`) values (6,'tianjianqin','15979089491');

/*Table structure for table `rights` */

DROP TABLE IF EXISTS `rights`;

CREATE TABLE `rights` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(40) NOT NULL,
  `rightType` char(1) NOT NULL,
  `url` char(100) DEFAULT NULL,
  `pid` int(11) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `rights` */

insert  into `rights`(`rid`,`name`,`rightType`,`url`,`pid`) values (1,'权限管理','1','',1),(2,'增加职位权限','2','jobinfo_list.html',1),(3,'修改职位权限','2','jobinfo_list.html',1),(4,'删除职位权限','2','jobinfo_list.html',1),(5,'账号管理','1',NULL,5),(6,'添加员工账号','2','employee_list.jsp',5),(7,'删除员工账号','2','employee_list.jsp',5),(8,'查看员工信息','2','employee_list.jsp',5),(11,'重置用户密码','2','employee_resetpass_list.html',5),(12,'查询所有销售员工','2','sale_employee_list.html',5),(13,'查询所有咨询员工','2','consult_employee_list.html',5),(14,'报表管理','1',NULL,14),(15,'查询所有员工','2','employee_list.jsp',14),(16,'查询所有客户','2','custom_list.html',14),(17,'客户信息导入','2','custom_import_export.html',14),(18,'客户信息导出','2','custom_import_export.html',14),(19,'导出客户开发报表','2','custominfo_export.html',14),(20,'客户资料','1',NULL,20),(21,'添加客户信息','2','custom_list.html',20),(22,'修改客户信息','2','custom_list.html',20),(23,'分配客户','2','distribute_sale.html',20),(24,'客户开发','1',NULL,24),(25,'查看客户开发信息','2','custominfo_list.html',24),(26,'修改客户开发信息','2','custominfo_list.html',24),(27,'员工客户开发信息','2','custominfo_query.html',24),(28,'客户咨询','1',NULL,28),(29,'查看客户咨询信息','2','consultrecord_list.html',28),(30,'修改客户咨询信息','2','consultrecord_list.html',28),(31,'部门管理','1',NULL,31),(32,'查看部门员工信息','2','employee_query.html',31),(33,'统计数据','1',NULL,33),(34,'客户开发统计数据','2','custominfo_data.html',33),(35,'客户咨询统计数据','2','consultrecord_data.html',33);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
