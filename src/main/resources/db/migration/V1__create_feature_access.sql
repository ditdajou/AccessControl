CREATE TABLE `vincenttest`.`feature_access` (
`feature_name` VARCHAR(45) NOT NULL,
`email` VARCHAR(45) NOT NULL,
`enable_access` BIT NOT NULL DEFAULT (0),
 PRIMARY KEY (`feature_name`,`email`));
