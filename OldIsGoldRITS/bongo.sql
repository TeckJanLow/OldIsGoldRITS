-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: bongo-records.cvd1ck22zwym.ap-southeast-2.rds.amazonaws.com    Database: bongo_records
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ALBUM`
--

DROP TABLE IF EXISTS `ALBUM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALBUM` (
  `album_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `artist` varchar(30) NOT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `comment` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1021 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALBUM`
--

LOCK TABLES `ALBUM` WRITE;
/*!40000 ALTER TABLE `ALBUM` DISABLE KEYS */;
INSERT INTO `ALBUM` VALUES (1000,'Yellow Submarine','The Beatles','Rock','Large stock do not purchase\r'),(1001,'The Beatles Anthology','The Beatles','Rock','\r'),(1002,'Endtroducing','DJ Shadow','Hip Hop','\r'),(1003,'Oasis','The Beatles','Rock','\r'),(1004,'Pulp','Different Class','Pop','Not related to Pulp Fiction\r'),(1005,'Harvest','Neil Young','Rock','\r'),(1006,'Music for the Jilted Generation','Prodigy','Electronica','\r'),(1007,'MTV Unplugged','Nirvana','Alternative','\r'),(1008,'Parklife','Blur','Rock','\r'),(1009,'Second Coming','Stone Roses','Rock','Popular\r'),(1010,'Stanley Road','Paul Weller','Rock','\r'),(1011,'Fat of the Land','Prodigy','Electronica','\r'),(1012,'Made in Heaven','Queen','Rock','Popular\r'),(1013,'Protection/No Protection','Massive Attack','Various','\r'),(1014,'Beatles Live at the BBS','The Beatles','Rock','Popular\r'),(1015,'Leftism','Leftfield','Electronica','\r'),(1016,'The King of Limbs','Radiohead','Rock','\r'),(1017,'The Invisible Band','Travis','Pop','\r'),(1018,'Portishead','Dummy','Rock','\r'),(1019,'Definitely Maybe','Oasis','Pop','\r'),(1020,'What\'s the Morning Story','Oasis','Pop','Popular');
/*!40000 ALTER TABLE `ALBUM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER` (
  `cust_id` int(11) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(4) NOT NULL,
  `zip` varchar(6) NOT NULL,
  `preferred_mode` varchar(15) DEFAULT NULL,
  `is_subscribed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES (5000,'Jonathan','Blow','41522456','jblow@gmail.com','151, Animal Crossing','Jonestown','SA','5600','phone',1),(5001,'Johnny','Madden','51566098','johnny.madden@gmail.com','53, North Terrace','Adelaide','SA','5000','phone',1),(5002,'Sarah','Palin','15153663','sarahp@hotmail.com','1, Hutt Street','Adelaide','SA','5000','email',0),(5003,'Brucey','Whayne','91562345','batman1337@gmail.com','100, King William Road','Adelaide','SA','5000','phone',1),(5004,'Dee','Beers','52641256','dbeers@yahoo.com','2, Sturt Street','Adelaide','SA','5000','phone',1),(5005,'Madain','Parameskaran','42306555','mparameskaran@gmail.com','10/10, South Terrace','Adelaide','SA','5000','email',0),(5006,'Cindy','Lai','63662236','lailai@gmail.com','166, Gouger Street','Adelaide','SA','5000','email',1),(5007,'Hannah','Palindrome','55335533','xorhannahrox@hotmail.com','101, Kayak Street','Adelaide','SA','5005','email',0),(5008,'Sindee','Bears','12345678','cindybear@gmail.com','55, Norwood Park','Adelaide','SA','5070','email',0),(5009,'Meli','Sita','55665577','melisita@gmail.com','777, Grange Road','Adelaide','SA','5025','email',1),(5010,'Tech','Lowe','41965233','tlowe@gmail.com','108, Hindley Street','Adelaide','SA','5000','phone',1);
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLOYEE` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(25) NOT NULL,
  `state` varchar(4) NOT NULL,
  `zip` varchar(6) NOT NULL,
  `job` varchar(20) NOT NULL,
  `salary` decimal(8,2) NOT NULL,
  `pass` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE`
--

LOCK TABLES `EMPLOYEE` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE` DISABLE KEYS */;
INSERT INTO `EMPLOYEE` VALUES (100,'Bongo','Roberts','42330655','bongo.roberts@gmail.com','50, Hutt Street','Adelaide','SA','5000','Manager',7135.00,'C+\'[>þ¸Ž¸\0/ð`q¾Ñ'),(101,'Anita','Roberts','42330656','anita.roberts@gmail.com','50, Hutt Street','Adelaide','SA','5000','Manager',3713.00,'öÙò•²Q4RK5\\ÛŽ–fw');
/*!40000 ALTER TABLE `EMPLOYEE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INVENTORY`
--

DROP TABLE IF EXISTS `INVENTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INVENTORY` (
  `sku` int(11) NOT NULL AUTO_INCREMENT,
  `quality` varchar(10) NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `album_id` int(11) NOT NULL,
  `purchase_price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB AUTO_INCREMENT=7030 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INVENTORY`
--

LOCK TABLES `INVENTORY` WRITE;
/*!40000 ALTER TABLE `INVENTORY` DISABLE KEYS */;
INSERT INTO `INVENTORY` VALUES (7000,'mint',2,4.90,1000,3.00),(7001,'good',3,3.90,1000,2.60),(7002,'poor',1,1.50,1000,1.00),(7003,'good',1,6.50,1001,4.33),(7004,'fair',2,5.50,1001,3.67),(7005,'good',1,6.00,1002,4.00),(7006,'good',1,6.20,1003,4.13),(7007,'mint',2,7.80,1004,5.20),(7008,'fair',4,6.20,1005,4.13),(7009,'poor',2,4.10,1005,2.73),(7010,'good',1,4.20,1006,2.80),(7011,'fair',3,3.50,1006,2.33),(7012,'mint',1,9.95,1007,6.63),(7013,'good',2,8.90,1007,5.93),(7014,'good',1,6.50,1008,4.33),(7015,'fair',1,5.00,1009,3.33),(7016,'good',1,5.50,1010,3.67),(7017,'good',2,4.50,1011,3.00),(7018,'good',1,4.90,1012,3.27),(7019,'fair',2,7.80,1012,5.20),(7020,'mint',1,9.90,1013,6.60),(7021,'mint',1,10.50,1014,7.00),(7022,'good',1,7.00,1015,4.67),(7023,'poor',1,6.10,1015,4.07),(7024,'poor',2,7.50,1016,5.00),(7025,'good',1,7.70,1017,5.13),(7026,'fair',3,5.20,1018,3.47),(7027,'fair',1,4.80,1019,3.20),(7028,'fair',1,4.20,1020,2.80),(7029,'poor',1,2.80,1020,1.87);
/*!40000 ALTER TABLE `INVENTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REQUEST`
--

DROP TABLE IF EXISTS `REQUEST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REQUEST` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `cust_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9003 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REQUEST`
--

LOCK TABLES `REQUEST` WRITE;
/*!40000 ALTER TABLE `REQUEST` DISABLE KEYS */;
INSERT INTO `REQUEST` VALUES (9000,5001,100,'mint copy of das bleu u-boat by beetles','2016-01-10',1,1),(9001,5008,100,'midnight persuasion any album any quality','2016-01-11',1,0),(9002,5009,101,'passionfruit orchard good quality by farmers','2016-01-16',1,0);
/*!40000 ALTER TABLE `REQUEST` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-27 15:56:04
