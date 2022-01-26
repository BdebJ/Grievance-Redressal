-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: redress
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `complid` int NOT NULL AUTO_INCREMENT,
  `compltime` datetime NOT NULL,
  `subject` varchar(75) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `techid` int DEFAULT NULL,
  `compl_status` int NOT NULL DEFAULT '0',
  `startprog` varchar(200) DEFAULT NULL,
  `ongoingprog` varchar(200) DEFAULT NULL,
  `endprog` varchar(200) DEFAULT NULL,
  `res_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`complid`),
  KEY `pid_idx` (`pid`),
  KEY `techId_idx` (`techid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `userinfo` (`pid`),
  CONSTRAINT `techId` FOREIGN KEY (`techid`) REFERENCES `technician` (`techid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='compl_status 0 - Initiated		res_status 0 - Initiated       \n	      1 - Accepted			  1 - Unresolved\n	      2 - Rejected			  2 - Resolved\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerdefects`
--

DROP TABLE IF EXISTS `customerdefects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerdefects` (
  `cusdefid` int NOT NULL AUTO_INCREMENT,
  `ownid` int DEFAULT NULL,
  `cus_def` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cusdefid`),
  KEY `prodOwnId_idx` (`ownid`),
  CONSTRAINT `prodOwnId` FOREIGN KEY (`ownid`) REFERENCES `productowned` (`ownid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdefects`
--

LOCK TABLES `customerdefects` WRITE;
/*!40000 ALTER TABLE `customerdefects` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerdefects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `deptid` int NOT NULL AUTO_INCREMENT,
  `deptname` varchar(45) NOT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `fbackid` int NOT NULL AUTO_INCREMENT,
  `complid` int DEFAULT NULL,
  `feedback` varchar(200) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`fbackid`),
  KEY `compId_idx` (`complid`),
  CONSTRAINT `compId` FOREIGN KEY (`complid`) REFERENCES `complaint` (`complid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `prodid` int NOT NULL AUTO_INCREMENT,
  `deptid` int DEFAULT NULL,
  `prodmodel` varchar(25) DEFAULT NULL,
  `prodname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`prodid`),
  KEY `pdeptid_idx` (`deptid`),
  CONSTRAINT `pdeptid` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdefects`
--

DROP TABLE IF EXISTS `productdefects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productdefects` (
  `pdefid` int NOT NULL AUTO_INCREMENT,
  `prodid` int DEFAULT NULL,
  `prod_def` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pdefid`),
  KEY `prodId_idx` (`prodid`),
  CONSTRAINT `prodId` FOREIGN KEY (`prodid`) REFERENCES `product` (`prodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdefects`
--

LOCK TABLES `productdefects` WRITE;
/*!40000 ALTER TABLE `productdefects` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdefects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productowned`
--

DROP TABLE IF EXISTS `productowned`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productowned` (
  `ownid` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `prodid` int NOT NULL,
  PRIMARY KEY (`ownid`),
  KEY `pid_idx` (`pid`),
  KEY `prodId_idx` (`prodid`),
  CONSTRAINT `prodOwnpid` FOREIGN KEY (`pid`) REFERENCES `userinfo` (`pid`),
  CONSTRAINT `prodOwnprodId` FOREIGN KEY (`prodid`) REFERENCES `product` (`prodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productowned`
--

LOCK TABLES `productowned` WRITE;
/*!40000 ALTER TABLE `productowned` DISABLE KEYS */;
/*!40000 ALTER TABLE `productowned` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technician`
--

DROP TABLE IF EXISTS `technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technician` (
  `techid` int NOT NULL AUTO_INCREMENT,
  `techname` varchar(45) NOT NULL,
  `deptid` int DEFAULT NULL,
  PRIMARY KEY (`techid`),
  KEY `deptid_idx` (`deptid`),
  CONSTRAINT `deptid` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
/*!40000 ALTER TABLE `technician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phno` int DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  `userstatus` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`),
  KEY `tid_idx` (`roleid`),
  CONSTRAINT `tid` FOREIGN KEY (`roleid`) REFERENCES `usertype` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='userstatus 0 - Inactive\n	  1 - Active';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'a','qweqw','wqeqw','wqeqw','wqewqe','we',1233,3,1),(2,'b','zxc','fd','gdfg','gfhfg','fgh',4566,2,1);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertype` (
  `roleid` int NOT NULL AUTO_INCREMENT,
  `role` varchar(25) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Admin'),(2,'CSR'),(3,'Customer');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-26 16:51:55
