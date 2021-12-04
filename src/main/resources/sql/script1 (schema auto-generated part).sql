USE `db_a`
;
DROP DATABASE IF EXISTS db_a;
CREATE DATABASE db_a;
USE `db_a`;

SET FOREIGN_KEY_CHECKS=0
; 
DROP TABLE IF EXISTS `courses` CASCADE
;

DROP TABLE IF EXISTS `m2m_users_courses` CASCADE
;

DROP TABLE IF EXISTS `roles` CASCADE
;

DROP TABLE IF EXISTS `topics` CASCADE
;

DROP TABLE IF EXISTS `users` CASCADE
;

CREATE TABLE `courses`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	`duration` INT NOT NULL,
	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,
	`topic_id` INT UNSIGNED NOT NULL,
	`user_id` INT UNSIGNED NOT NULL,
	`counter` INT UNSIGNED NOT NULL DEFAULT 0,
	`state` INT UNSIGNED NOT NULL DEFAULT 1,
	CONSTRAINT `PK_cources` PRIMARY KEY (`id` ASC),
	CONSTRAINT `UNQ_name` UNIQUE (`name` ASC),
	CONSTRAINT `FK_courses_topics` FOREIGN KEY (`topic_id`) REFERENCES `topics` (`id`) ON DELETE Restrict ON UPDATE Cascade,
	CONSTRAINT `FK_courses_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE Restrict ON UPDATE Cascade
)

;

ALTER TABLE `courses` 
 ADD INDEX `IXFK_courses_topics` (`topic_id` ASC)
;
ALTER TABLE `courses` 
 ADD INDEX `IXFK_courses_users` (`user_id` ASC)
;
ALTER TABLE `courses` 
 ADD INDEX `IND_counter` (`counter` ASC)
;


CREATE TABLE `m2m_users_courses`
(
	`user_id` INT UNSIGNED NOT NULL,
	`course_id` INT UNSIGNED NOT NULL,
	`mark` INT UNSIGNED NULL,
	`reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT `PK_m2m_users_courses` PRIMARY KEY (`user_id` ASC, `course_id` ASC),
	CONSTRAINT `FK_m2m_users_courses_courses` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE Restrict ON UPDATE Cascade,
	CONSTRAINT `FK_m2m_users_courses_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE Restrict ON UPDATE Cascade
)

;

ALTER TABLE `m2m_users_courses` 
 ADD INDEX `IXFK_m2m_users_courses_courses` (`course_id` ASC)
;
ALTER TABLE `m2m_users_courses` 
 ADD INDEX `IXFK_m2m_users_courses_users` (`user_id` ASC)
;


CREATE TABLE `roles`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	CONSTRAINT `PK_users_role` PRIMARY KEY (`id` ASC),
	CONSTRAINT `UNQ_name` UNIQUE (`name` ASC)
)

;

CREATE TABLE `topics`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(128) NOT NULL,
	CONSTRAINT `PK_topics` PRIMARY KEY (`id` ASC),
	CONSTRAINT `UNQ_name` UNIQUE (`name` ASC)
)

;

CREATE TABLE `users`
(
	`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`f_name` VARCHAR(64) NOT NULL,
	`l_name` VARCHAR(64) NOT NULL,
	`email` VARCHAR(128) NOT NULL,
	`password` VARCHAR(64) NOT NULL,
	`role_id` INT UNSIGNED NOT NULL,
	CONSTRAINT `PK_users` PRIMARY KEY (`id` ASC),
	CONSTRAINT `UNQ_email` UNIQUE (`email` ASC),
	CONSTRAINT `FK_users_roles` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE Restrict ON UPDATE Cascade
)

;

ALTER TABLE `users` 
 ADD INDEX `IXFK_users_roles` (`role_id` ASC)
;


SET FOREIGN_KEY_CHECKS=1
; 
