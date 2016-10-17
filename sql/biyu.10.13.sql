/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.1.73-community : Database - biyu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biyu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `biyu`;

/*Table structure for table `t_account` */

DROP TABLE IF EXISTS `t_account`;

CREATE TABLE `t_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(16) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '用户手机号，也是唯一身份验证',
  `password` varchar(32) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '密码，md5加密',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账户表，用户登陆验证。';

/*Data for the table `t_account` */

insert  into `t_account`(`id`,`phone`,`password`) values (1,'123','gdyb21LQTcIANtvYMT7QVQ=='),(2,'chengcheng','zOp6aw0yLTNLDmKlhMQ7Bg==');

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `fid` bigint(20) DEFAULT NULL COMMENT 'feed ID',
  `comments` text CHARACTER SET utf8 COMMENT '评论信息',
  `uid` int(11) DEFAULT NULL COMMENT '会员人ID',
  `created` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`fid`,`comments`,`uid`,`created`) values (1,2,'xzzzzzzzzzzzzzzzzzzzzzzzzzzzzz',1,'2016-09-27 09:49:53'),(2,2,'在那里啊？出来high',1,'2016-09-27 10:04:02'),(3,2222,'在那里啊？出来high',1,'2016-09-27 10:04:28'),(4,2222,'在那里啊？出来eweeeeeeeeeeeeeeeeqewrdcasdfasdfsadfgregregrhigh',1,'2016-09-27 10:05:34'),(5,2222,'在那里啊？出来&lt;script src=&#39;sdd&#39;&gt;&lt;/script&gt;high',1,'2016-09-27 10:07:17');

/*Table structure for table `t_feed` */

DROP TABLE IF EXISTS `t_feed`;

CREATE TABLE `t_feed` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识ID',
  `uid` int(11) DEFAULT NULL COMMENT '会员ID',
  `ftype` char(2) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `message` text COLLATE utf8_bin COMMENT '消息内容 64kb',
  `forwarded` int(10) DEFAULT NULL COMMENT '转发数',
  `liked` int(10) DEFAULT NULL COMMENT '喜欢数',
  `pic` text COLLATE utf8_bin COMMENT '图片数组',
  `lng` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '经度',
  `lat` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '纬度',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `ind_uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_feed` */

insert  into `t_feed`(`id`,`uid`,`ftype`,`message`,`forwarded`,`liked`,`pic`,`lng`,`lat`,`created`) values (2,1,'1','测试文本内容~121298',2,5,'[]','104.06','30.67','2016-09-26 22:34:17'),(6,1,'1','测试文wwwwwww本内容~121298',20,10,'[\"http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg\",\"http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg\",\"http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg\"]','104.06','30.67','2016-09-26 22:38:27'),(7,1,'1','测试文wwwwwww本内容~1434345345',0,3,'[\"http://b.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=277c06a0cc1349546a13e0363727f93d/3812b31bb051f819ffbbbd6bddb44aed2e73e771.jpg\",\"http://b.hiphotos.baidu.com/baike/crop%3D0%2C2%2C560%2C370%3Bc0%3Dbaike80%2C5%2C5%2C80%2C26/sign=44216f7132f33a878a225a5afb6c3c0a/b3b7d0a20cf431ad5af7af784336acaf2edd984e.jpg\",\"http://a.hiphotos.baidu.com/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=88b3ac0bdc2a283457ab3e593adca28f/adaf2edda3cc7cd965fa88cf3101213fb90e91d5.jpg\"]','104.06','30.67','2016-09-26 22:39:55'),(8,2,'2','测试文本内容~1232222222222',2,0,'[]','104.06','30.67','2016-09-26 22:43:31'),(9,3,'2','测试文本内容~123333333',3,2,'[]','104.06','30.67','2016-09-26 22:49:31'),(10,3,'1','测试文本内容~14444444444',4,0,'[]','104.06','30.67','2016-09-26 22:49:34');

/*Table structure for table `t_liked` */

DROP TABLE IF EXISTS `t_liked`;

CREATE TABLE `t_liked` (
  `id` int(10) DEFAULT NULL COMMENT '标识',
  `fid` bigint(20) DEFAULT NULL COMMENT '动态ID',
  `uid` int(11) DEFAULT NULL COMMENT '会员ID',
  `created` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_liked` */

/*Table structure for table `t_mail` */

DROP TABLE IF EXISTS `t_mail`;

CREATE TABLE `t_mail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '信件主题',
  `content` text CHARACTER SET utf8 COMMENT '信件内容',
  `fromPhone` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送方手机',
  `toPhone` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '接收方手机',
  `status` int(11) DEFAULT NULL COMMENT '信件状态,1:已发送;2:已阅读',
  `sendDate` datetime DEFAULT NULL COMMENT '发送时间',
  `allowReciveDate` datetime DEFAULT NULL COMMENT '允许接受的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_mail` */

insert  into `t_mail`(`id`,`subject`,`content`,`fromPhone`,`toPhone`,`status`,`sendDate`,`allowReciveDate`) values (4,'haha','hehehe','123','123',2,'2016-09-25 14:19:46','2016-09-25 14:19:46'),(5,'haha','hehehe','123','123',2,'2016-09-25 14:32:08','2016-09-08 00:00:01');

/*Table structure for table `t_penpal` */

DROP TABLE IF EXISTS `t_penpal`;

CREATE TABLE `t_penpal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `penpalPhone` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_penpal` */

/*Table structure for table `t_point_io` */

DROP TABLE IF EXISTS `t_point_io`;

CREATE TABLE `t_point_io` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `accountPhone` varchar(16) CHARACTER SET utf8 NOT NULL COMMENT '对应t_account的手机号',
  `currentPoint` bigint(20) DEFAULT NULL COMMENT '当前积分，变化前的',
  `changePoint` bigint(20) DEFAULT NULL COMMENT '增加或减少的积分',
  `changeDate` date DEFAULT NULL COMMENT '变化时间',
  `reson` varchar(300) CHARACTER SET utf8 DEFAULT NULL COMMENT '原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='积分流水表，用于记录积分的流水。';

/*Data for the table `t_point_io` */

/*Table structure for table `t_sms_log` */

DROP TABLE IF EXISTS `t_sms_log`;

CREATE TABLE `t_sms_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识ID',
  `mobile` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `verifi_code` varchar(6) COLLATE utf8_bin DEFAULT NULL COMMENT '验证码',
  `created` datetime DEFAULT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_sms_log` */

/*Table structure for table `t_stamp` */

DROP TABLE IF EXISTS `t_stamp`;

CREATE TABLE `t_stamp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '标识ID',
  `mobile` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `mail_id` int(10) DEFAULT NULL COMMENT '收发邮件ID',
  `pic` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '邮票URL',
  `created` datetime DEFAULT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_stamp` */

/*Table structure for table `t_user_info` */

DROP TABLE IF EXISTS `t_user_info`;

CREATE TABLE `t_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `accountPhone` varchar(16) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '对应t_account的手机号',
  `avatar` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像',
  `postCode` varchar(6) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮编',
  `nickName` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `sex` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别,0 女 1 男 2 其它',
  `birthDay` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生年月',
  `zodiac` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '星座',
  `location` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生地',
  `favorite` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '爱好',
  `needs` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '需求',
  `status` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '目前状态',
  `signature` varchar(512) CHARACTER SET utf8 DEFAULT NULL COMMENT '个性签名',
  `point` bigint(20) DEFAULT '0' COMMENT '积分',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户基础信息表。';

/*Data for the table `t_user_info` */

insert  into `t_user_info`(`id`,`accountPhone`,`avatar`,`postCode`,`nickName`,`sex`,`birthDay`,`zodiac`,`location`,`favorite`,`needs`,`status`,`signature`,`point`,`updated`) values (1,'123','http://baidu.com/logo.jpg',NULL,'b1','0','2016-09-27',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL),(2,'chengcheng','http://baidu.com/logo.jpg',NULL,'b3','0','2016-09-27',NULL,NULL,NULL,NULL,NULL,NULL,0,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*===*/;
