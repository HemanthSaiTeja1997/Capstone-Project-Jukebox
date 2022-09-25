CREATE DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_Id` int NOT NULL AUTO_INCREMENT,
  `playlist_name` varchar(500) NOT NULL,
  `song_Id` int NOT NULL,
  `playlist_url` varchar(300) NOT NULL,
  `songName` varchar(450) NOT NULL,
  PRIMARY KEY (`playlist_Id`),
  KEY `song_Id_idx` (`song_Id`),
  CONSTRAINT `song_Id` FOREIGN KEY (`song_Id`) REFERENCES `song` (`song_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'Hemanth',3,'src/main/resources/songs/03-Homecoming.wav','HomeComing'),(2,'Hemanth',2,'src/main/resources/songs/02-Heaven-Shaking Event.wav','Heaven_Shaking_Event'),(3,'Hemanth',1,'src/main/resources/songs/01-Shippuuden.wav','Shippuuden'),(4,'Mylist',4,'src/main/resources/songs/04-Experienced Many Battles.wav','Experience_Many_Battles'),(5,'Mylist',6,'src/main/resources/songs/07-Man of the World.wav','Man_Of_The_World'),(6,'Mylist',8,'src/main/resources/songs/12-Jinchuuriki.wav','Jinchuuriki');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_Id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `album` varchar(100) NOT NULL,
  `artist` varchar(45) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`song_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'Shippuuden','Naruto','Yasuharu Takanashi','Industrial Metal','2:06','src/main/resources/songs/01-Shippuuden.wav'),(2,'Heaven_Shaking_Event','Naruto','Yasuharu Takanashi','Acoustic Blues','3:03','src/main/resources/songs/02-Heaven-Shaking Event.wav'),(3,'HomeComing','Naruto','Yasuharu Takanashi','Acoustic Blues','1:50','src/main/resources/songs/03-Homecoming.wav'),(4,'Experience_Many_Battles','Naruto','Yasuharu Takanashi','Alternative Metal','1:51','src/main/resources/songs/04-Experienced Many Battles.wav'),(5,'Lighting_Speed','Naruto','Yasuharu Takanashi','Alternative Metal','2:16','src/main/resources/songs/05-Lightning Speed.wav'),(6,'Man_Of_The_World','Naruto','Yasuharu Takanashi','Industrial Metal','2:55','src/main/resources/songs/07-Man of the World.wav'),(7,'Anger','Naruto','Yasuharu Takanashi','Acoustic Blues','2:54','src/main/resources/songs/09-Anger.wav'),(8,'Jinchuuriki','Jujutsu_Kaisen','Hiroaki_ Tsutsumi','Strong Hip Hop','2:01','src/main/resources/songs/12-Jinchuuriki.wav'),(9,'Akatsuki','Naruto','Yasuharu Takanashi','Industrial Metal','2:01','src/main/resources/songs/akatsuki-theme.wav'),(10,'Beat_It','Thriller','Michael Jackson','Rock','4:56','src/main/resources/songs/Michael_Jackson_Beat_it.wav'),(11,'Faith','After_Hours','Weeknd','RetroWave','4:43','src/main/resources/songs/The_Weeknd_-_Faith_b64f0d283.wav'),(12,'Save_Your_Tears','After_Hours','Weeknd','Synth_Pop','3;35','src/main/resources/songs/The_Weeknd_-_Save_Your_Tears_b64f0d216.wav'),(13,'Too_Late','After_Hours','Weeknd','Synth_Pop','4:00','src/main/resources/songs/The_Weeknd_-_Too_Late_b64f0d240.wav'),(14,'Unravel','Tokyo_Ghoul','Yutaka Yamada','Punk_Rock','4:00','src/main/resources/songs/Tokyo Ghoul.wav');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-25 22:44:21
