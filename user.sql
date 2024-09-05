DROP USER if exists 'spring'@'localhost';

CREATE USER 'spring'@'localhost' IDENTIFIED BY 'Spring@123';

GRANT ALL PRIVILEGES ON * . * TO 'spring'@'localhost';