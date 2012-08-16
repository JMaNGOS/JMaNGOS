REVOKE ALL PRIVILEGES ON * . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `world` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `world` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `characters` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `characters` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `accounts` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `accounts` . * FROM 'JMaNGOS'@'localhost';

DELETE FROM `user` WHERE CONVERT( User USING utf8 ) = CONVERT( 'JMaNGOS' USING utf8 ) AND CONVERT( Host USING utf8 ) = CONVERT( 'localhost' USING utf8 ) ;

DROP DATABASE IF EXISTS `world` ;

DROP DATABASE IF EXISTS `characters` ;

DROP DATABASE IF EXISTS `accounts` ;
