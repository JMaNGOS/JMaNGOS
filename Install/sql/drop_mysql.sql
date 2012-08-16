REVOKE ALL PRIVILEGES ON * . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `mangos` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `mangos` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `characters` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `characters` . * FROM 'JMaNGOS'@'localhost';

REVOKE ALL PRIVILEGES ON `realmd` . * FROM 'JMaNGOS'@'localhost';

REVOKE GRANT OPTION ON `realmd` . * FROM 'JMaNGOS'@'localhost';

DELETE FROM `user` WHERE CONVERT( User USING utf8 ) = CONVERT( 'JMaNGOS' USING utf8 ) AND CONVERT( Host USING utf8 ) = CONVERT( 'localhost' USING utf8 ) ;

DROP DATABASE IF EXISTS `mangos` ;

DROP DATABASE IF EXISTS `characters` ;

DROP DATABASE IF EXISTS `realmd` ;
