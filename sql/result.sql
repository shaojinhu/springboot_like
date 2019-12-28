/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.24-log : Database - result
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`result` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `result`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `companyOid` int(5) NOT NULL,
  `companyName` varchar(10) NOT NULL,
  PRIMARY KEY (`companyOid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `likeman` */

DROP TABLE IF EXISTS `likeman`;

CREATE TABLE `likeman` (
  `serialID` varchar(25) NOT NULL,
  `manName` varchar(10) DEFAULT NULL,
  `manStation` int(5) NOT NULL,
  `manAddress` varchar(50) DEFAULT NULL,
  `manTel` varchar(11) DEFAULT NULL,
  `companyOid` int(5) NOT NULL,
  `manType` int(5) NOT NULL,
  `operateName` varchar(10) DEFAULT NULL,
  `operateDateTime` datetime DEFAULT NULL,
  `hot` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`serialID`),
  KEY `fk_company` (`companyOid`),
  KEY `fk_type` (`manType`),
  KEY `fk_station` (`manStation`),
  CONSTRAINT `fk_company` FOREIGN KEY (`companyOid`) REFERENCES `company` (`companyOid`),
  CONSTRAINT `fk_station` FOREIGN KEY (`manStation`) REFERENCES `station` (`manstation`),
  CONSTRAINT `fk_type` FOREIGN KEY (`manType`) REFERENCES `type` (`mantype`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `manstation` int(5) NOT NULL AUTO_INCREMENT,
  `manstationname` varchar(10) NOT NULL,
  PRIMARY KEY (`manstation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf32;

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `mantype` int(5) NOT NULL AUTO_INCREMENT,
  `manname` varchar(10) NOT NULL,
  PRIMARY KEY (`mantype`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `nikename` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
