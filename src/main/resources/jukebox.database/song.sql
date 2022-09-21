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
  `genre` VARCHAR(45) NOT NULL,
  `duration` VARCHAR(45) NOT NULL,
  `url` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`songId`));
  --insert values into song table
  insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
  VALUES ('1', 'Shippuuden', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '2:06',
   'src/main/resources/songs/01-Shippuuden.wav');
   insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `gener`, `duration`, `url`)
   VALUES ('3', 'HomeComing', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '1:50',
    'src/main/resources/songs/03-Homecoming.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
VALUES ('4', 'Experience_Many_Battles', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal',
 '1:51', 'src/main/resources/songs/04-Experienced Many Battles.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
VALUES ('5', 'Lighting_Speed', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '2:16',
 'src/main/resources/songs/05-Lightning Speed.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('6', 'Man_Of_The_World', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '2:55',
  'src/main/resources/songs/07-Man of the World.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('7', 'Anger', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '2:54',
  'src/main/resources/songs/09-Anger.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('8', 'Jinchuuriki', 'Jujutsu_Kaisen', 'Hiroaki_ Tsutsumi', 'Strong Hip Hop', '2:01',
  'src/main/resources/songs/12-Jinchuuriki.wav');
  insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
  VALUES ('9', 'Akatsuki', 'Naruto', 'Yasuharu Takanashi', 'Industrial Metal', '2:01',
   'src/main/resources/songs/akatsuki-theme.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('10', 'Beat_It', 'Thriller', 'Michael Jackson', 'Rock', '4:56',
  'src/main/resources/songs/Michael_Jackson_Beat_it.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('11', 'Faith', 'After_Hours', 'Weeknd', 'RetroWave', '4:43',
  'src/main/resources/songs/The_Weeknd_-_Faith_b64f0d283.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('12', 'Save_Your_Tears', 'After_Hours', 'Weeknd', 'Synth_Pop', '3;35',
  'src/main/resources/songs/The_Weeknd_-_Save_Your_Tears_b64f0d216.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `duration`, `url`)
 VALUES ('13', 'Too_Late', 'After_Hours', 'Weeknd', 'Synth_Pop', '4:00',
 'src/main/resources/songs/The_Weeknd_-_Too_Late_b64f0d240.wav');
insert into `jukebox`.`song` (`song_Id`, `name`, `album`, `artist`, `genre`, `url`)
 VALUES ('14', 'Unravel', 'Tokyo_Ghoul', 'Yutaka Yamada', 'Punk_Rock',
 'src/main/resources/songs/Tokyo Ghoul.wav');



