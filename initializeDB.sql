CREATE DATABASE  IF NOT EXISTS `resource_mgmt`;
USE `resource_mgmt`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `resource`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `resource` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `resource_name` TEXT,
  `resource_code` int,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `resource` WRITE;
INSERT INTO `resource` VALUES
	(1,'Rolleiflex MF Camera', 1000),
    (2,'Guitar Looper Pedal', 200),
    (3,'Tandem Skydiving Coupon', 200),
    (4,'DJI Drone', 700),
    (5,'Electric Guitar', 1000),
    (6,'Bass Guitar', 1000),
    (7,'Acoustic Guitar', 1000),
    (8,'Travel Coupon', 10000);
UNLOCK TABLES;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `project`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `project` (
    `project_id` int NOT NULL AUTO_INCREMENT,
    `project_name` TEXT,
     PRIMARY KEY(`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `project_resource`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `project_resource` (
    `project_resource_id` int NOT NULL AUTO_INCREMENT,
    `project` int,
    `resource` int,
     PRIMARY KEY(`project_resource_id`),
     FOREIGN KEY(project) references project(project_id),
     FOREIGN KEY(resource) references resource(resource_id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
