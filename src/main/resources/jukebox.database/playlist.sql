--create playlist table in jukebox database
create TABLE `jukebox`.`playlist`(
  `playlist_Id` INT NOT NULL,
  `playlist_Name` VARCHAR(45) NOT NULL,
  `playlist_Artist` VARCHAR(45) NOT NULL,
  `playlist_Gener` VARCHAR(45) NOT NULL,
  `playlist_Duration` VARCHAR(45) NOT NULL,
  `playlist_URL` VARCHAR(45) NOT NULL,
  `song_Id` INT NOT NULL,
  PRIMARY KEY (`playlist_Id`),
  INDEX `song_Id_idx` (`song_Id` ASC) VISIBLE,
  CONSTRAINT `song_Id`
    FOREIGN KEY (`song_Id`)
    REFERENCES `jukebox`.`song` (`song_Id`)
    ON delete NO ACTION
    ON update NO ACTION);
