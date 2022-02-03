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
  `compltime` datetime DEFAULT NULL,
  `subject` varchar(75) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `ownid` int DEFAULT NULL,
  `techid` int DEFAULT NULL,
  `compl_status` int NOT NULL DEFAULT '0',
  `startprog` varchar(200) DEFAULT NULL,
  `ongoingprog` varchar(200) DEFAULT NULL,
  `endprog` varchar(200) DEFAULT NULL,
  `res_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`complid`),
  KEY `pid_idx` (`pid`),
  KEY `techId_idx` (`techid`),
  KEY `ownId_idx` (`ownid`),
  CONSTRAINT `ownId` FOREIGN KEY (`ownid`) REFERENCES `productowned` (`ownid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `userinfo` (`pid`),
  CONSTRAINT `techId` FOREIGN KEY (`techid`) REFERENCES `technician` (`techid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='compl_status 0 - Initiated 1 - Accepted	2 - Rejected	res_status 0 - Unresolved   1 - Resolved';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES (1,'2022-02-01 13:58:55','AC Problem','Our Ac has not been working for past 5 days',10,5,NULL,0,NULL,NULL,NULL,0),(2,'2022-02-01 13:58:55','Fridge Problem','Fridge heating up',10,1,3,1,'Technician has been assigned','Support has been dispatched','Product is serviced and fixed ',1),(3,'2022-02-01 13:58:55','TV problems','TV is showing black screen',25,9,5,1,'Technician has been dispatched','Support is dispacthed','Product is not fixable',0),(4,'2022-02-01 13:58:55','blah bla bla','hahaha',14,10,NULL,2,NULL,NULL,NULL,0),(5,'2022-02-01 13:58:55','Mixer Problem','Mixer motor not spinning',20,6,NULL,1,NULL,NULL,NULL,0),(6,'2022-02-01 13:58:55','MS Teams fault','MS teams not working save project',14,3,NULL,2,NULL,NULL,NULL,1),(7,'2022-02-01 13:58:55','Laptop not working','Laptop',10,9,NULL,0,NULL,NULL,NULL,0),(8,'2022-02-01 13:58:55','Router defect','Router Signal Low',15,12,NULL,0,NULL,NULL,NULL,0),(9,'2022-02-01 13:58:55','Github delete my files','Save meeeeee',4,8,NULL,0,NULL,NULL,NULL,0),(10,'2022-02-01 13:58:55','lorem ipsum ','dolor amet',12,3,NULL,0,NULL,NULL,NULL,0),(11,'2022-02-01 14:06:28','Equipment missing','Missing equipment',10,13,NULL,0,NULL,NULL,NULL,0),(12,'2022-02-02 04:19:05','jaxc','testcomplaint',57,8,NULL,0,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `sl` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phno` varchar(15) NOT NULL,
  `message` varchar(300) NOT NULL,
  `pid` int NOT NULL,
  `username` varchar(25) NOT NULL,
  PRIMARY KEY (`sl`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'Riya','rsaha@gmail.com','9145587584','bad service',57,'testuser7');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdefects`
--

LOCK TABLES `customerdefects` WRITE;
/*!40000 ALTER TABLE `customerdefects` DISABLE KEYS */;
INSERT INTO `customerdefects` VALUES (1,2,'Broken Fan'),(2,4,'LCD broken'),(3,3,'Jammed valve'),(4,7,'Unauthorized part used'),(5,9,'Water damage');
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
  `deptname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `deptstatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'dolorem',0),(2,'accusamus',1),(3,'aut',1),(4,'porro',1),(5,'quae',0),(6,'sed',1),(7,'possimus',1),(8,'quis',1),(9,'AC',1),(10,'quo',1),(11,'Telivision',1),(14,'Ching chong',1),(15,'Ping ling',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,2,'Very good service',8),(2,3,'Average service',6),(5,NULL,'Horrible service',1),(6,NULL,'good care',8);
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
  `prodmodel` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `prodname` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `prodstatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`prodid`),
  KEY `pdeptid_idx` (`deptid`),
  CONSTRAINT `pdeptid` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,9,'R-5','Refrigerator',1),(3,6,'autem','placeat',0),(4,5,'est','fugiat',1),(5,1,'magni','quidem',1),(6,5,'rerum','perferendis',1),(7,5,'ab','eligendi',1),(8,5,'aspernatur','aspernatur',0),(9,5,'quia','repellendus',0),(10,5,'eos','porro',0),(11,2,'sapiente','similique',0),(12,10,'doloremque','itaque',1),(13,5,'repellendus','aut',1),(14,5,'dolores','doloribus',1),(15,5,'cumque','soluta',1),(16,11,'architecto','laborum',1),(17,5,'quia','maiores',1),(18,5,'eos','perspiciatis',1),(19,5,'qui','quasi',1),(20,11,'rerum','neque',1),(21,5,'impedit','iste',1),(22,5,'ea','qui',1),(23,5,'corporis','voluptates',1),(24,5,'dolorum','nostrum',1),(25,5,'aliquam','aut',1),(26,5,'temporibus','ea',1),(27,2,'veritatis','ab',1),(28,5,'quos','molestiae',1),(29,9,'esse','natus',1),(30,5,'odio','enim',1),(31,3,'voluptatem','est',1),(32,5,'ipsam','voluptas',1),(33,8,'expedita','recusandae',1),(34,5,'voluptate','quam',1),(35,4,'incidunt','quia',1),(36,7,'delectus','eius',1),(37,7,'velit','quis',1),(38,9,'praesentium','et',1),(39,3,'ut','velit',1),(40,5,'sint','quas',1),(41,5,'quasi','quibusdam',1),(42,1,'nihil','doloremque',1),(43,5,'tempora','laboriosam',1),(44,1,'accusantium','minus',1),(45,4,'placeat','enim',1),(46,9,'quas','eum',1),(47,5,'consequatur','eos',1),(48,7,'aut','consequatur',1),(49,1,'corrupti','rem',1),(50,6,'sit','modi',1),(51,3,'sm-102','Samsung Galaxy 1',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productowned`
--

LOCK TABLES `productowned` WRITE;
/*!40000 ALTER TABLE `productowned` DISABLE KEYS */;
INSERT INTO `productowned` VALUES (1,2,45),(2,25,7),(3,14,21),(4,8,5),(5,14,8),(6,20,21),(7,13,21),(8,4,17),(9,10,5),(10,15,9),(11,15,7),(12,15,10),(13,10,7);
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
  `techname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `deptid` int DEFAULT NULL,
  `techstatus` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`techid`),
  KEY `deptid_idx` (`deptid`),
  CONSTRAINT `deptid` FOREIGN KEY (`deptid`) REFERENCES `department` (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
INSERT INTO `technician` VALUES (1,'Amit Pandey',9,1),(2,'Dr. Jason D',1,0),(3,'Holly Cummerata',1,1),(4,'Annamarie Effertz Jr.',1,1),(5,'Bobbie Jacobs IV',1,1),(6,'Dr. Keyshawn Brakus II',2,1),(7,'Beryl Wiegand II',2,1),(8,'Athena Rutherford III',2,1),(9,'Jeffry Mitchell',2,1),(10,'Dr. Tressa Altenwerth V',3,1),(11,'Miss Jude Rath',3,1),(12,'Arno Conroy',3,1),(13,'Ms. Elvie Hahn IV',5,1),(14,'Prof. Maegan Mohr I',5,1),(15,'Berry Dietrich',5,1),(16,'Anissa Crona',5,1),(17,'Mrs. Felicia Christiansen I',5,1),(18,'Antonietta Thompson DVM',5,1),(19,'Dr. Candido Weber Sr.',5,1),(20,'Antwan Russel',5,0),(21,'Peyton Reichert',5,1),(22,'Barney Marks Sr.',5,1),(23,'Samson Armstrong',5,1),(24,'Cathy Haag',5,1),(25,'Janis Watsica',5,1),(26,'Dr. Koby Wolf',5,1),(27,'Carroll Oberbrunner',5,1),(28,'Maryse Crooks',5,1),(29,'Cassandra Borer',5,1),(30,'Prof. Harmon Sanford',5,1),(31,'Brody Rowe',5,1),(32,'Freddie Romaguera DVM',5,1),(33,'Dixie Balistreri MD',5,1),(34,'Julian Abernathy',5,1),(35,'Prof. Jean Koss',5,1),(36,'Talon Stanton',5,1),(37,'Stanley Moen',5,1),(38,'Jarrett Prohaska',5,1),(39,'Miss Anjali Koelpin',5,1),(40,'Gust Hayes',5,1),(41,'Dr. Maximus Koelpin',5,1),(42,'Celestine Marks MD',5,1),(43,'Maddison Swift',5,1),(44,'Prof. Antone D\'Amore',5,1),(45,'Trey Heaney',5,1),(46,'Prof. Ibrahim Johns',5,1),(47,'Prof. Reed Bauch IV',5,1),(48,'Jennings Mayer',5,1),(49,'Mrs. Eliane Hermiston',5,1),(50,'Mr. Urban Mayer',5,1),(52,'suraj',5,1),(57,'qwet',5,1),(58,'weqe',5,1),(60,'jsmith',5,1);
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
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phno` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  `userstatus` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `tid_idx` (`roleid`),
  CONSTRAINT `tid` FOREIGN KEY (`roleid`) REFERENCES `usertype` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci COMMENT='userstatus 0 - Inactive\n	  1 - Active';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'bjena','$s0$b0801$dbHbOs8ZUPvxCbuGs25tBA==$vdtk9WN4fPsVjC7PLj/2CkbA6fw4uTbM/kDiD9E8iTA=','Buddhadeb','Jena','55496 Tyra Gateway Suite 382\nWaelchiport, MN 82219','bjena128@gmail.com','9546784589',1,1),(2,'pallab','$s0$b0801$/XuiiFLdaImiu9JeeFL8ww==$sZtlYzUdsLQ/T11wj0sgTXGe+0/lv8CE67SfLWLd6kM=','Cade','Williamson','7219 Buckridge Lodge Suite 661Lonieland, VT 72611-6233','soledad.nolan@example.net','9658754213',1,1),(3,'ani6497','$s0$b0801$R2p6OWboe3vz8Zf+vaMXYg==$QT+JyDszIN8TAtOOUc0T3gQNZ40fQdXsStolQbR9FwQ=','Wellington','Schmidt','350 Lindsey Inlet\nLednerside, UT 66935-6924','tyrell85@example.net','9021546758',1,1),(4,'itkumar','$s0$b0801$uuHUI/l6eoVux8JW68p+/Q==$GByJ3dzUzUWsFMhbAzn3WOloOc9AejGL6XSQd9cw1TU=','Stephon','Bernier','146 Schmidt Point Apt. 974\nFadelton, VA 19068','alanna15@example.com','9265345572',1,1),(5,'csr','$s0$b0801$0SZO3acARZES1om6cKcgVw==$qH1mnXMMK11SH14TQ/crMdR9vKCy2wX4/xAXC2CqdvI=','Kelsi','Abernathy','8232 Shanahan Inlet\nMalachiborough, ID 69571-4116','jedidiah61@example.net','7568994675',2,1),(6,'user','$s0$b0801$02yyDlKtElqJLV2ceFyoQQ==$LuziYgnR1YRMmm8Sm6UPJ3SmVa2eJMPQqkA7EKabh9Y=','Riju','Banerjee','Nefdgt, Kolkata 7001560','q@q.com','8456798541',2,2),(7,'williamson.alphonso','$s0$b0801$3oaN/oTAHtCiKQ4m0zmSHw==$Xhj7yj3RerC4ei18Puk7VNAXQGqsX4voDXN1gFMOxyk=','Meagan','Schaden','4835 Aditya Island Suite 268Selmerchester, MS 72156','jarvis.schaefer@example.org','9235645789',2,2),(8,'brenden.runolfsdottir','$s0$b0801$hwmvNPYOKxac5iUwl/2qbw==$q4bT1GHPwpV02cKDxCz4stVBV0w3q8FUv0GSjTS0MKA=','Jany','Farrell','44015 Zachary RestNorth Tomas, NM 46116','cwyman@example.com','7898778645',2,1),(9,'pfeffer.ahmed','$s0$b0801$NDeJ3cU7zb1NeRB4cBDz0A==$QEejFau9F2ZnkpnFQOTbZS/bzOSmupmH3NZZKWZ7bY4=','Shayna','Anderson','726 Joey ForksEmardmouth, VT 27454-7340','dakota21@example.com2','9424363014',3,2),(10,'Jaydeep','$s0$b0801$IrjfwaOqKnhhPhOPv0IYOw==$ds/vjCft40iZ15hvotZR9ATRT5fAhZZYk/Pm9ZgnT6E=','Jay','deep','fsefsf','dwedw@gm.com','9123399157',3,1),(11,'d\'amore.frederik','$s0$b0801$0b6CGUqJlqVLolbrrSsLGg==$mRXBTUNkaNjbXDOYsaOZDwYJ58rfHnoPDdITR7V5wzI=','Leo','Hayes','174 McKenzie PlainsVernicebury, WA 83973','rroberts@example.com','9453269994',3,1),(12,'alize77','$s0$b0801$x1tY2CymL9np6cxPcakCdg==$H/4NnFhsi7+qY2snjfMNhlsnNa1BYeEu0vbCQ6belCI=','Omer','Gusikowski','88702 Becker Mills Apt. 195Rippinton, LA 58320','xhoeger@example.net','9652321647',3,2),(13,'andre.bernier','$s0$b0801$paKcXckd2b8chC5VeWWcPA==$pmwf/EFn43Jj+88AMK19g3NgphczwvOdJMG0gHWMGz8=','Edna','Gaylord','810 Wilfrid Pass Apt. 249\nStrosinberg, NH 67860-3567','zjacobi@example.org','9264357224',3,1),(14,'harvey.jeremy','$s0$b0801$kXuqp3sZI93dhaeBhAUiuA==$PNibFrUyWOcqUfvqu+XszRBVEp4N1HM698VH0WdkHNQ=','Rowland','Hettinger','56174 Joe Unions\nNorth Garthmouth, KS 58836-0593','leda.torphy@example.org','8444545404',3,1),(15,'mosciski.rosalia','$s0$b0801$aN0BeibtKu2cZUW1S1/e2w==$Xa0NPy5h1lfpew2y26pmk+BLdHugp/TL/GBeJGT/O48=','Cindy','Collins','835 Kuhn Ridge Apt. 236\nAniyamouth, IL 81349','beryl89@example.org','9754652724',3,1),(16,'melody.wehner','$s0$b0801$Zi1z3YO/CiA76I8vfMPqtQ==$fu29hD5OOEJLbYvQd2Xoor9Fc2VkXxVfhMqS52GfEes=','Harry','Aufderhar','7620 Davis Curve\nEast Otha, HI 52658-2116','frice@example.net','5678658764',3,1),(17,'ilockman','$s0$b0801$dQLwANjta4Vd1WJTwASt0A==$NttNnzJ1GeH5rTgU/12DH/albJ2d4hEyAPgzMhSztf8=','Verdie','Schamberger','071 Eusebio Mount Apt. 815\nLynchborough, SD 06912-3840','kassandra.ratke@example.com','2245465464',3,1),(18,'hwelch','$s0$b0801$EAlSB+wibPv/Ynbl3USndQ==$Jbb34m7vwUjdEuv8e/CxejloyCpnoajdyUhFQqZ4hw4=','Jordan','Wilderman','93134 Norwood Loaf Suite 772\nReingerside, IL 63767-0337','kerluke.charlie@example.net','9757864568',3,1),(19,'aracely.o\'reilly','$s0$b0801$Wx5ofQ9jCJcbIifbJ7VuyA==$d6kmfv1EAV7JwiNLUIuJ3ln46phVQDxd68ouVztw4Zw=','Rebeca','Keeling','34218 Reinger Courts\nRafaelshire, PA 54067','jconroy@example.net','9565678535',3,1),(20,'mrmon','$s0$b0801$0Q6Gyl+yZOFlozMF5AB+RQ==$uAP8nPjibxfbnxVhNIjPZK4g3RXYKaRqi7yqDTV/9S4=','234','wfsd','dsfdsf','gh@ggfh.com','5687962575',3,1),(21,'ffsfsdfdsf','$s0$b0801$9xymohnGj0DWpGWr2xvt8g==$rXwZQx8glu57REWVFWzr0PrVhtaA0OGAwllUxYmoukY=','dfgdfg','dfgdfg','wf@g.com','wf@g.com','9567352414',3,1),(22,'hagenes.jamal','$s0$b0801$/XuiiFLdaImiu9JeeFL8ww==$sZtlYzUdsLQ/T11wj0sgTXGe+0/lv8CE67SfLWLd6kM=','Cade','Jakubowski','957 Cummerata Station\nWest Percivalberg, MI 29478','norberto70@example.net','9562443624',3,1),(23,'lia.quigley','$s0$b0801$R2p6OWboe3vz8Zf+vaMXYg==$QT+JyDszIN8TAtOOUc0T3gQNZ40fQdXsStolQbR9FwQ=','Moshe','Gusikowski','08216 Jarred Radial\nPort Reidhaven, AZ 40842-8028','jenkins.alejandrin@example.net','9563534232',3,1),(24,'cary.tremblay','$s0$b0801$uuHUI/l6eoVux8JW68p+/Q==$GByJ3dzUzUWsFMhbAzn3WOloOc9AejGL6XSQd9cw1TU=','Yasmin','Brakus','818 Bauch Ports\nThielport, NH 92800','lindsay55@example.net','9462737624',3,1),(25,'eadams','$s0$b0801$/7/oG1p78HcjHsVKqPqUNA==$f9h7C7FPRRXoSWrPJdXDWdRoL4+ZCRw2YXRmrWTcO84=','Myrna','Jenkins','64292 McKenzie Hills\nVerlafurt, KS 64505-6417','charlotte11@example.com','8465624345',3,1),(26,'igreenholt','$s0$b0801$3oaN/oTAHtCiKQ4m0zmSHw==$Xhj7yj3RerC4ei18Puk7VNAXQGqsX4voDXN1gFMOxyk=','Danial','Becker','6216 Keyon Valleys Apt. 689\nDarbymouth, WY 62419','wzieme@example.com','2435649978',3,1),(27,'lindgren.arnoldo','$s0$b0801$hwmvNPYOKxac5iUwl/2qbw==$q4bT1GHPwpV02cKDxCz4stVBV0w3q8FUv0GSjTS0MKA=','Alvera','Zulauf','774 Vandervort Pines Apt. 076\nLake D\'angelo, RI 03939','dgoyette@example.net','9999999999',3,1),(28,'malcolm22','$s0$b0801$NDeJ3cU7zb1NeRB4cBDz0A==$QEejFau9F2ZnkpnFQOTbZS/bzOSmupmH3NZZKWZ7bY4=','Kamille','Torphy','3408 Jesse Alley Suite 593\nRutherfordburgh, HI 25676','torp.stephon@example.net','6578578657',3,1),(29,'cmoore','$s0$b0801$LmbVHvde4l97as0J0gGONQ==$XMrDbC6xOGf6G6rA4Dpg386Q+bp+TDHcs5zBw0tx7aI=','Emmanuel','Fahey','7536 Cartwright Lodge\nPort Vickieton, WA 56302-1654','alene15@example.com','5424357424',3,1),(30,'kling.ethel','$s0$b0801$WcMb5+Q3VgtltzCWFU5Rbg==$+71+b0opnlsGkmJkOD1Xx4x1NvWA25gJzjvJzqu2e/4=','Jeramy','VonRueden','6594 Senger Orchard Suite 238\nCatharinehaven, NH 01652','teagan.powlowski@example.org','8687678648',3,1),(31,'iwunsch','$s0$b0801$xP1/AxM4FOKN9r39x2kHCg==$/b/jPwx5YsMj+kjQ2VVJBqpIh1ejoWwlfO0zF//rZnc=','Alec','O\'Keefe','1247 Rutherford Street\nNorth Shyanntown, AZ 67444-9008','ellsworth64@example.org','9766436645',3,1),(32,'daren.lang','$s0$b0801$WcMb5+Q3VgtltzCWFU5Rbg==$+71+b0opnlsGkmJkOD1Xx4x1NvWA25gJzjvJzqu2e/4=','Talia','Dach','96113 Jessica Motorway\nNew Jakobview, NY 87503-8601','valentine.hettinger@example.org','9673575324',3,1),(33,'jovanny72','$s0$b0801$KMGA1PSoCpaK2I7PP9/eQg==$4ENV5i1DyPz35QWYextpd7cTsfu7PsHGtrYi3idmgZg=','Rhett','Gerhold','274 Skiles Creek\nNew Pascaleburgh, ME 83868-3429','alexandrine93@example.com','9655332457',3,1),(34,'jalon.green','$s0$b0801$sWySsqYgVMTyvbtdUjf9mw==$emEjepE5ZNfiO9Uva9gmY5i26RWYoO1ZvlM7T4+hV8U=','Cortez','Dickinson','215 Heller Pike Suite 901\nCorkerychester, MT 95201','rice.elva@example.org','9667653324',3,1),(35,'sonya.batz','$s0$b0801$YqJBBIf4ly1Vr0SjKEekAA==$gKB20Oqop9t1RQql5SKsan6FgMX5FDcfhf9WTklv2iU=','Delia','McGlynn','9345 Meghan Light\nLake Delta, MD 87031','ehills@example.net','9576577424',3,1),(57,'testuser7','$s0$b0801$dbHbOs8ZUPvxCbuGs25tBA==$vdtk9WN4fPsVjC7PLj/2CkbA6fw4uTbM/kDiD9E8iTA=','test','user','Nefdgt, Kolkata 7001560','testuser@gmail.com','9145587584',3,1);
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

-- Dump completed on 2022-02-02 18:03:30
