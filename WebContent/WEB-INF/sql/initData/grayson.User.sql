DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `passwd` varchar(255) NOT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastvisittime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visitip` varchar(255) DEFAULT '0.0.0.0',
  `levels` varchar(255) DEFAULT '0',
  `role_ids` varchar(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


INSERT INTO `user` VALUES (1,'zhengyi','grayson','2014-10-17 10:14:15','2014-10-17 10:14:15','0.0.0.0','99','99');

