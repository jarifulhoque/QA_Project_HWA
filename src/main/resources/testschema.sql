DROP TABLE IF EXISTS `premier_league`;

CREATE TABLE `premier_league`(
	`id` BIGINT AUTO_INCREMENT,
	`club` VARCHAR(255),
	`stadium_capacity` VARCHAR(255),
	`club_value` INT,
	`points` INT,
	PRIMARY KEY (`id`)
);