CREATE DATABASE trading;

CREATE TABLE Orders (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
binanceId INT NOT NULL,
pair VARCHAR(30) NOT NULL,
amount INT NOT NULL,
direction VARCHAR(30),
date VARCHAR(30)
)