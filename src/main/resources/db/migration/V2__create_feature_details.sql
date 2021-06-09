CREATE TABLE `vincenttest`.`feature_details` (
  `feature_name` VARCHAR(45) NOT NULL,
  `feature_desc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`feature_name`));

INSERT INTO `vincenttest`.`feature_details` ( `feature_name`, `feature_desc`) VALUES ('APPLY_LOAN','sample desc');
INSERT INTO `vincenttest`.`feature_details` ( `feature_name`, `feature_desc`) VALUES ('SCORING_DETAILS','sample desc');
INSERT INTO `vincenttest`.`feature_details` ( `feature_name`, `feature_desc`) VALUES ('CUSTOMER_DETAILS','sample desc');
INSERT INTO `vincenttest`.`feature_details` ( `feature_name`, `feature_desc`) VALUES ('BUSINESS_ACCOUNT','sample desc');
INSERT INTO `vincenttest`.`feature_details` ( `feature_name`, `feature_desc`) VALUES ('FUND_INVEST','sample desc');