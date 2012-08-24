REVOKE ALL PRIVILEGES ON * . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `world` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `world` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `realm` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `realm` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `auth` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `uth` . * FROM 'JMaNGOS'@'localhost';

DELETE FROM `user` WHERE CONVERT( User USING utf8 ) = CONVERT( 'JMaNGOS' USING utf8 ) AND CONVERT( Host USING utf8 ) = CONVERT( 'localhost' USING utf8 ) ;

DROP DATABASE IF EXISTS `world` ;

DROP DATABASE IF EXISTS `realm` ;

DROP DATABASE IF EXISTS `auth` ;
