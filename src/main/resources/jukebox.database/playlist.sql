--create playlist table in jukebox database
 create TABLE `jukebox`.`playlist`(
  `playlistId` INT NOT NULL,
  `playlistName` VARCHAR(45) NOT NULL,
  `song_Id` INT NOT NULL,
  PRIMARY KEY (`playlistId`),
  INDEX `song_Id_idx` (`song_Id` ASC) VISIBLE,
  CONSTRAINT `song_Id`
    FOREIGN KEY (`song_Id`)
    REFERENCES `jukebox`.`song` (`song_Id`)
    ON delete NO ACTION
    ON update NO ACTION);

