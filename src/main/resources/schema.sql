CREATE TABLE employee
(
 userName varchar(100) NOT NULL,
  userId varchar(11) NOT NULL ,
 userAddress varchar(100) DEFAULT NULL,
 userEmail varchar(100) DEFAULT NULL,
 userPassword varchar(100) DEFAULT NULL,
 PRIMARY KEY (userId)
);