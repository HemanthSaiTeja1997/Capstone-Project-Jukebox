--create a database object of Jukebox
create DATABASE IF NOT EXISTS `jukebox`;
--use the database by following below statement
USE `jukebox`;
--create a song table in the  jukebox database
create TABLE `jukebox`.`song`(
  `songId` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `album` VARCHAR(100) NOT NULL,
  `artist` VARCHAR(45) NOT NULL,
  `gener` VARCHAR(45) NOT NULL,
  `duration` VARCHAR(45) NOT NULL,
  `url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`songId`));
