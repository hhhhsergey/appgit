CREATE DATABASE  IF NOT EXISTS `mathapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mathapp`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: mathapp
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `math_table`
--

DROP TABLE IF EXISTS `math_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `math_table` (
  `id_math` int NOT NULL AUTO_INCREMENT,
  `rank` double NOT NULL,
  `rank_total` double NOT NULL,
  `date` date NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id_math`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user_table` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `math_table`
--

LOCK TABLES `math_table` WRITE;
/*!40000 ALTER TABLE `math_table` DISABLE KEYS */;
INSERT INTO `math_table` VALUES (1,1,1,'2020-11-09',1),(2,2,22,'2020-11-14',1),(3,2,22,'2020-11-14',1),(4,2,22,'2020-11-14',1),(5,2,22,'2020-11-14',1),(6,2,22,'2020-11-14',1),(7,2,22,'2020-11-14',1),(8,2,22,'2020-11-14',1),(9,1,1,'2020-11-14',2),(10,1,1,'2020-11-15',2),(11,1,1,'2020-11-16',2),(12,0,0.75,'2020-11-17',2),(13,0.5,0.7,'2020-12-03',2),(14,0.75,0.7083333333333334,'2020-12-03',2),(15,0.75,0.7142857142857143,'2020-12-03',2),(16,0.5,0.6875,'2020-12-15',2),(17,1,0.7222222222222222,'2021-01-10',2),(18,1,0.75,'2021-01-10',2),(19,1,0.7727272727272727,'2021-01-11',2),(20,1,0.7916666666666666,'2021-01-11',2),(21,1,0.8076923076923077,'2021-01-11',2),(22,1,0.8214285714285714,'2021-01-11',2),(23,1,0.8333333333333334,'2021-01-11',2),(24,1,0.84375,'2021-01-11',2),(25,1,0.8529411764705882,'2021-01-11',2),(26,1,0.8611111111111112,'2021-01-11',2),(27,1,0.868421052631579,'2021-01-11',2),(28,1,0.875,'2021-01-11',2),(29,1,0.8809523809523809,'2021-01-11',2),(30,1,0.8863636363636364,'2021-01-11',2),(31,1,0.8913043478260869,'2021-01-11',2),(32,1,0.8958333333333334,'2021-01-14',2),(33,1,1,'2021-01-15',14),(34,1,1,'2021-01-15',14),(35,1,1,'2021-01-15',14),(36,1,1,'2021-01-15',14),(37,1,1,'2021-01-16',14),(38,1,1,'2021-01-16',14),(39,1,1,'2021-01-16',20),(40,1,1,'2021-01-16',21),(41,1,1,'2021-01-16',21),(42,1,1,'2021-01-16',21),(43,1,1,'2021-01-16',22),(44,1,1,'2021-01-16',22),(45,1,1,'2021-01-16',22),(46,1,1,'2021-01-16',22),(47,1,1,'2021-01-16',22),(48,1,1,'2021-01-16',14),(49,1,0.9,'2021-01-16',2),(50,1,0.9038461538461539,'2021-01-16',2),(51,1,0.9074074074074074,'2021-01-16',2),(52,1,0.9107142857142857,'2021-01-16',2),(53,1,0.9137931034482759,'2021-01-16',2),(54,1,0.9166666666666666,'2021-01-16',2),(55,1,0.9193548387096774,'2021-01-16',2),(56,1,0.921875,'2021-01-16',2),(57,1,0.9242424242424242,'2021-01-16',2),(58,1,0.9264705882352942,'2021-01-16',2),(59,1,0.9285714285714286,'2021-01-16',2),(60,0,0.9027777777777778,'2021-01-16',2),(61,0.5,0.8918918918918919,'2021-01-16',2),(62,0.5,0.881578947368421,'2021-01-16',2);
/*!40000 ALTER TABLE `math_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `active` tinyint DEFAULT NULL,
  `userrole` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'bob','bob',1,'USER'),(2,'tom','tom',1,'user'),(3,'bob2','bob',1,'User'),(4,'name','password',1,'User'),(5,'name2','2',1,'User'),(6,'qwert','qwert',1,'User'),(7,'yuio','yuio',1,'User'),(8,'loli','loli',1,'User'),(9,'qwe','qwe',1,'User'),(10,'qq','1',1,'User'),(11,'z','z',1,'User'),(12,'www123','ww',1,'User'),(13,'q','',1,'User'),(14,'sergey','1111',1,'User'),(15,'qwertyu','qwe',1,'User'),(16,'gerald','qwe',1,'User'),(17,'sergey1','11',1,'User'),(18,'sergey2','22',1,'User'),(19,'sergey3','3',1,'User'),(20,'edisson','123123',1,'User'),(21,'martin','111111',1,'User'),(22,'victoria','qwerty',1,'User');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-21 19:45:14
