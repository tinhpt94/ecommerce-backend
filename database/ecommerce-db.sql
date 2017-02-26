CREATE DATABASE IF NOT EXISTS `ecommerce` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ecommerce`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id`            INT(11)      NOT NULL AUTO_INCREMENT,
  `name`          VARCHAR(200) NOT NULL,
  `code`          VARCHAR(20)  NOT NULL,
  `price`         DOUBLE       NOT NULL,
  `brand`         VARCHAR(50)           DEFAULT NULL,
  `made_in`       VARCHAR(50)           DEFAULT NULL,
  `collection`    VARCHAR(50)           DEFAULT NULL,
  `model`         VARCHAR(100)          DEFAULT NULL,
  `gender`        VARCHAR(1)            DEFAULT NULL,
  `diameter`      DOUBLE                DEFAULT NULL,
  `thickness`     DOUBLE                DEFAULT NULL,
  `weight`        DOUBLE                DEFAULT NULL,
  `water_proof`   VARCHAR(20)           DEFAULT NULL,
  `alarm`         TINYINT(1)            DEFAULT NULL,
  `warranty_time` INT(11)               DEFAULT NULL,
  `image_url`     VARCHAR(200) NOT NULL,
  `created_date`  DATE         NOT NULL,
  `updated_date`  DATE                  DEFAULT NULL,
  `quantity`      INT(11)      NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 52
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products`
  DISABLE KEYS */;
INSERT INTO `products` VALUES
  (1, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL,
   'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (3, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (4, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (5, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (6, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (12, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (13, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (14, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (15, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (16, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (17, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (18, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (19, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (20, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (21, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (22, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (23, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (24, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (25, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (26, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (27, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (28, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (29, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (30, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (31, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (32, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (33, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (34, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (35, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (36, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (37, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (38, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (39, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (40, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (41, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (42, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (43, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (44, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL, 20),
  (45, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (46, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50),
  (47, 'Seiko', 'SBDB001', 20000000, 'Seiko Watches', NULL, NULL, 'SBDB001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Seiko.jpg', '2017-02-26', NULL, 100),
  (48, 'Audemars Piguet', '123123', 21000000, 'Audemars Piguet', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
   NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Audemars-Piguet-1.jpg', '2017-02-26', NULL, 100),
  (49, 'Vacheron Constantin 1', '2323', 15000000, 'Vacheron Constantin', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
   NULL, NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Vacheron-Constantin.jpg', '2017-02-26', NULL,
   20),
  (50, 'Patek Philippe 1', 'PP123', 10000000, 'Patek Philippe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
   NULL, 'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Patek-Philippe.jpg', '2017-02-26', NULL, 50),
  (51, 'Blancpain', 'B2', 111111111, 'Blancpain', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
   'https://www.thetrendspotter.net/wp-content/uploads/2016/01/Blancpain-1.jpg', '2017-02-26', NULL, 50);
/*!40000 ALTER TABLE `products`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id`       INT(11)     NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `email`    VARCHAR(45) NOT NULL,
  `role`     VARCHAR(45) NOT NULL,
  `name`     VARCHAR(100)         DEFAULT NULL,
  `phone`    VARCHAR(20)          DEFAULT NULL,
  `address`  VARCHAR(200)         DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_username_uindex` (`username`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
  DISABLE KEYS */;
INSERT INTO `users` VALUES
  (1, 'tinhpt94', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'tinhpt94@gmail.com', 'ADMIN',
   'Phạm Trung Tính', '0972426521', 'Số 82-84 ngõ 12 Chính Kinh Hà Nội'),
  (2, 'lancao96', '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'lancao96@gmail.com', 'USER',
   'Cao Thị Lan', '0968785313', 'Số 82-84 ngõ 12 Chính Kinh Hà Nội'),
  (3, 'tinhpt944', '$2a$10$LjHXsgWsNeJJy/cg7iceg.GnUzPlHxZQJTZ0g3OSsfo9PgCvSx5Ba', 'tinhpt94@gmail.com', 'USER', NULL,
   NULL, NULL),
  (6, '123123123123123', '$2a$10$kfBW9PC/3EIIo3zQSYUzGuSPrlOQfDNZm/31SGcYYhITseTGf6Y1y', 'phamtinh94@gmail.com', 'USER',
   'Tính Phạm', '972426521', 'Thanh Xuan'),
  (7, '1', '$2a$10$M44xPCH7JeFRT7FKOwDuPO2BNP2.nmetW0syVy5dl3n18l1K.Og.W', 'phamtinh94@gmail.com', 'USER', 'Tính Phạm',
   '972426521', 'Thanh Xuan'),
  (8, '123', '$2a$10$N0C.hdzIGalQqj0iPSeRG.7XbJtyuQUe/o9npvcTXCxMBUPdk5bAO', 'phamtinh94@gmail.com', 'USER',
   'Tính Phạm', '972426521', 'Thanh Xuan'),
  (9, '123123123123', '$2a$10$SXyfFMVb7CuPMYi1hFyCwuPlZ1iaCgNdIOxinC97jiu7oDDObRGTi', 'phamtinh94@gmail.com', 'USER',
   'Tính Phạm', '972426521', 'Thanh Xuan'),
  (10, 'tinhpt94123', '$2a$10$k/dfDPzxsZcstyzmcroCN.NKkA2uoAti89qZI7967vVMyay3KRLq6', 'phamtinh94@gmail.com', 'USER',
   'Tính Phạm', '972426521', 'Thanh Xuan'),
  (11, '123123123123123123123', '$2a$10$GtwlmKhzWaQizLx6y4CkVupdEBT7j29JSYjd11XIdYEi4Bz5MKSAi', 'phamtinh94@gmail.com',
   'USER', 'Tính Phạm', '972426521', 'Thanh Xuan'),
  (12, 'tinhpt9411', '$2a$10$VdtG/uLj8j.edd.xu7tm1OwgZN4Llxzb.5GG66eBDCUKITOEEzM6O', 'phamtinh94@gmail.com', 'USER',
   'Tính Phạm', '972426521', 'Thanh Xuan');
/*!40000 ALTER TABLE `users`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2017-02-26  9:51:27
