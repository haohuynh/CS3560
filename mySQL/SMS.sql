-- MySQL dump 10.17  Distrib 10.3.17-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: SMS
-- ------------------------------------------------------
-- Server version	10.3.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `SMS`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `SMS` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `SMS`;

--
-- Table structure for table `FoodOrder`
--

DROP TABLE IF EXISTS `FoodOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FoodOrder` (
  `OrderNumber` int(11) NOT NULL,
  `OrderDateTime` varchar(30) DEFAULT NULL,
  `TotalAmount` double DEFAULT NULL,
  `Tax` double DEFAULT NULL,
  PRIMARY KEY (`OrderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FoodOrder`
--

LOCK TABLES `FoodOrder` WRITE;
/*!40000 ALTER TABLE `FoodOrder` DISABLE KEYS */;
INSERT INTO `FoodOrder` VALUES (111111,'20191015 09:50',100,0.08),(222222,'20191125 09:55',10,0.08),(333333,'20191126 09:45',40,0.08),(444444,'20191126 10:00',60,0.08);
/*!40000 ALTER TABLE `FoodOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FoodOrderItem`
--

DROP TABLE IF EXISTS `FoodOrderItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FoodOrderItem` (
  `FoodCode` int(11) NOT NULL,
  `OrderNumber` int(11) NOT NULL,
  `Description` varchar(30) NOT NULL,
  `Quantity` int(11) DEFAULT NULL CHECK (`Quantity` > 0),
  `SoldPrice` double DEFAULT NULL CHECK (`SoldPrice` > 0),
  `TrackingNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderNumber`,`FoodCode`),
  KEY `TrackingNumber` (`TrackingNumber`),
  CONSTRAINT `FoodOrderItem_ibfk_1` FOREIGN KEY (`TrackingNumber`) REFERENCES `Shipment` (`TrackingNumber`) ON DELETE SET NULL,
  CONSTRAINT `FoodOrderItem_ibfk_2` FOREIGN KEY (`OrderNumber`) REFERENCES `FoodOrder` (`OrderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FoodOrderItem`
--

LOCK TABLES `FoodOrderItem` WRITE;
/*!40000 ALTER TABLE `FoodOrderItem` DISABLE KEYS */;
INSERT INTO `FoodOrderItem` VALUES (1,111111,'Round Table: Large Chicken and',5,100,111),(2,222222,'Subway: New Pit-Smoked Brisket',2,10,222),(3,333333,'Round Table: BBQ Chicken Pizza',1,20,333),(33,333333,'Round Table: Chicken Maui Zaui',1,20,333),(4,444444,'Qdoba: NACHOS',1,20,444),(44,444444,'Qdoba: BURRITO BOWL',1,20,444),(444,444444,'Qdoba: TORTILLA SOUP',1,20,444);
/*!40000 ALTER TABLE `FoodOrderItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shipment`
--

DROP TABLE IF EXISTS `Shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Shipment` (
  `TrackingNumber` int(11) NOT NULL,
  `DateTimeReceive` varchar(30) DEFAULT NULL,
  `DateTimeDelivery` varchar(30) DEFAULT NULL,
  `DeliveryLocation` varchar(30) DEFAULT NULL,
  `ContactName` varchar(30) DEFAULT NULL,
  `ContactPhoneNumber` varchar(20) DEFAULT NULL,
  `Cost` double DEFAULT NULL,
  `BroncoID` varchar(30) DEFAULT NULL,
  `ShippingStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`TrackingNumber`),
  KEY `BroncoID` (`BroncoID`),
  CONSTRAINT `Shipment_ibfk_1` FOREIGN KEY (`BroncoID`) REFERENCES `Shipper` (`BroncoID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shipment`
--

LOCK TABLES `Shipment` WRITE;
/*!40000 ALTER TABLE `Shipment` DISABLE KEYS */;
INSERT INTO `Shipment` VALUES (111,'2019-10-15T10:00','2019-10-15T10:15','Building 98-1','ABCXYZ','(123) 456-7899',118,'011499371','Completed'),(222,'2019-11-25T10:00','2019-11-25T10:30','Building 09-1','XAYBZC','(456) 123-7899',20.8,'011499371','Closing'),(333,'2019-11-26T10:00',' ','Janpanese Garden','XYZABC','(789) 965-4321',53.2,'011499371','Delivery Pending'),(444,' ',' ','Building 08-1','ABXYCZ','(999) 999-9999',74.8,'999999999','In-Transit');
/*!40000 ALTER TABLE `Shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shipper`
--

DROP TABLE IF EXISTS `Shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Shipper` (
  `BroncoID` varchar(30) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `EmailAddress` varchar(30) DEFAULT NULL,
  `PassPhrase` varchar(130) DEFAULT NULL,
  PRIMARY KEY (`BroncoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shipper`
--

LOCK TABLES `Shipper` WRITE;
/*!40000 ALTER TABLE `Shipper` DISABLE KEYS */;
INSERT INTO `Shipper` VALUES ('011499371','David Roura','(999) 888-7777','droura@cpp.edu','7fde208824c5f238d4c30793ed3c7e4949aedbeda1f5781eb4c6d8b6558a853fc461d157faf3ed3186336016f82d9d6e90eea9274df72fd5802306fe4d741773'),('999999999','Cal Poly Pomona','(ddd) ddd-dddd','cpp@cpp.edu','7fde208824c5f238d4c30793ed3c7e4949aedbeda1f5781eb4c6d8b6558a853fc461d157faf3ed3186336016f82d9d6e90eea9274df72fd5802306fe4d741773');
/*!40000 ALTER TABLE `Shipper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-19  7:55:11
