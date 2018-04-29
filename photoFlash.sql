/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - photoflash
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`photoflash` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `photoflash`;

/*Table structure for table `t_album` */

DROP TABLE IF EXISTS `t_album`;

CREATE TABLE `t_album` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(60) DEFAULT NULL,
  `a_description` varchar(255) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `coverpath` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `power` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `FK_t_album` (`uid`),
  CONSTRAINT `FK_t_album` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_album` */

insert  into `t_album`(`aid`,`albumname`,`a_description`,`type`,`coverpath`,`time`,`power`,`uid`) values (1,'诸葛亮','这是诸葛亮','普通','/upimage/2016-06-27/Three Kingdoms1.jpg','2016-06-25 00:00:00',1,1),(2,'庞统','这是庞统','普通','/upimage/2016-06-27/Three Kingdoms2.jpg','2016-06-25 00:00:00',1,2),(3,'张翼德','这是张翼德','普通','/upimage/2016-06-27/Three Kingdoms3.jpg','2016-06-25 00:00:00',1,1),(4,'曹操','这是曹操','普通','/upimage/2016-06-27/Three Kingdoms4.jpg','2016-06-27 00:00:00',1,2),(5,'关羽','这是关羽','普通','/upimage/2016-06-27/Three Kingdoms5.jpg','2016-06-27 00:00:00',1,3),(6,'吕布','这是吕布','普通','/upimage/2016-06-27/Three Kingdoms6.jpg','2016-06-27 00:00:00',1,3),(7,'刘备','这是刘备','普通','/upimage/2016-06-27/Three Kingdoms7.jpg','2016-06-27 00:00:00',1,1),(8,'赵子龙','这是赵子龙','普通','/upimage/2016-06-27/Three Kingdoms8.jpg','2016-06-27 00:00:00',1,1),(9,'汉献帝','这是汉献帝','亲子','/upimage/2016-06-27/Three Kingdoms9.jpg','2016-06-27 00:00:00',1,2),(10,'马超','这是马超','普通','/upimage/2016-06-27/Three Kingdoms10.jpg','2016-06-27 00:00:00',1,3),(11,'孙仲谋','这是孙仲谋','亲子','/upimage/2016-06-27/Three Kingdoms11.jpg','2016-06-27 00:00:00',1,2),(12,'周瑜','这是周瑜','普通','/upimage/2016-06-27/Three Kingdoms12.jpg','2016-06-28 15:04:31',1,1),(13,'小乔','这是小乔','普通','/upimage/2016-06-27/Three Kingdoms13.jpg','2016-06-28 15:04:32',1,3),(14,'貂蝉','这是貂蝉','普通','/upimage/2016-06-27/Three Kingdoms15.jpg','2016-06-28 15:04:36',1,2),(15,'孙尚香','这是孙尚香','普通','/upimage/2016-06-27/Three Kingdoms16.jpg','2016-06-28 15:04:37',1,3),(16,'孙策','这是孙策','普通','/upimage/2016-06-27/Three Kingdoms17.jpg','2016-06-28 15:04:37',1,2);

/*Table structure for table `t_photo` */

DROP TABLE IF EXISTS `t_photo`;

CREATE TABLE `t_photo` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `photoname` varchar(50) DEFAULT NULL,
  `filepath` varchar(60) DEFAULT NULL,
  `p_description` varchar(200) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `isdel` tinyint(1) DEFAULT NULL,
  `uptime` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK_t_user` (`uid`),
  KEY `FK_t_photo` (`aid`),
  CONSTRAINT `FK_t_photo` FOREIGN KEY (`aid`) REFERENCES `t_album` (`aid`),
  CONSTRAINT `FK_t_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_photo` */

insert  into `t_photo`(`pid`,`photoname`,`filepath`,`p_description`,`uid`,`aid`,`isdel`,`uptime`) values (1,'家人B','upimage/1.jpg','漂亮',1,1,0,'2016-06-26 00:00:00'),(2,'家人C','upimage/2.jpg','漂亮魅力',1,2,0,'2016-06-26 00:00:00'),(3,'家人C','upimage/3.jpg','漂亮魅力',1,1,0,'2016-06-26 00:00:00'),(4,'家人C','upimage/1.jpg','漂亮魅力',1,3,0,'2016-06-26 00:00:00'),(5,'家人C','upimage/2.jpg','漂亮魅力',1,1,0,'2016-06-26 00:00:00'),(6,'曹操','/upimage/2016-06-28/DA6471418D694F9ABF700BE251FAEAAE_777.jpg','曹操的真人秀',2,1,0,'2016-06-28 23:24:16'),(7,'曹操','/upimage/2016-06-28/688663C3A6564DEFBCE4FD4600B1B13B_2.jpg','曹操的真人秀',2,1,0,'2016-06-28 23:27:51'),(8,'张三的世界','/upimage/2016-06-29/B57580DEDB9448609ECB8BB736813426_2.jpg','你不懂',2,1,0,'2016-06-29 00:02:39'),(9,'曹操','/upimage/2016-06-29/B50C3259A9EE4E67B1EC982C48B3AC9D_2.jpg','曹操的真人秀',2,1,0,'2016-06-29 00:04:20'),(10,'刘备','/upimage/2016-06-29/ADFA0561685C4016AE6957A3B1D661C0_2.jpg','刘备的家人',2,1,0,'2016-06-29 00:07:50');

/*Table structure for table `t_reply` */

DROP TABLE IF EXISTS `t_reply`;

CREATE TABLE `t_reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `replytime` datetime NOT NULL,
  `content` text,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `FK_t_photokey` (`pid`),
  KEY `FK_t_userkey` (`uid`),
  CONSTRAINT `FK_t_photokey` FOREIGN KEY (`pid`) REFERENCES `t_photo` (`pid`),
  CONSTRAINT `FK_t_userkey` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_reply` */

insert  into `t_reply`(`rid`,`uid`,`replytime`,`content`,`pid`) values (1,1,'2016-06-26 00:00:00','今天天气不错！~',1),(2,2,'2016-06-26 00:00:00','今天天气不错！家人~',2);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` char(11) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`username`,`password`,`email`,`phone`,`active`) values (1,'张三','123','342834999@qq.com','18186149123',0),(2,'李四','123','','12321312123',0),(3,'王五','123','wangwu@qq.com','12321312121',0),(4,'张小三1','123456','123@qq.com','18186149445',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
