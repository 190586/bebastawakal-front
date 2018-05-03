CREATE TABLE IF NOT EXISTS `authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `menu` (
  `id_menu` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `button_text` varchar(100) DEFAULT NULL,
  `data_href` bit(1) NOT NULL,
  `description` longtext,
  `end_time` datetime DEFAULT NULL,
  `image_path` varchar(50) NOT NULL,
  `orders` int(11) NOT NULL,
  `short_description` longtext,
  `start_time` datetime NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `type` varchar(50) NOT NULL,
  `url` longtext,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `page` (
  `id_page` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `breadcrumb` longtext,
  `button_text` varchar(100) DEFAULT NULL,
  `code` varchar(100) NOT NULL,
  `content` longtext,
  `header_image_path` varchar(50) DEFAULT NULL,
  `icon_path` varchar(50) DEFAULT NULL,
  `orders` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `type` varchar(16) NOT NULL,
  PRIMARY KEY (`id_page`),
  UNIQUE KEY `UK_9pi3hcvib9isvoad8c3by5qc7` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `setting` (
  `id_profile` bigint(20) NOT NULL AUTO_INCREMENT,
  `address1` longtext NOT NULL,
  `address2` longtext,
  `company_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `facebook_link` varchar(50) NOT NULL,
  `footer_description` longtext NOT NULL,
  `hotline` varchar(15) NOT NULL,
  `instagram_link` varchar(50) NOT NULL,
  `logo` varchar(50) NOT NULL,
  `prime` tinyint(4) NOT NULL,
  `twitter_link` varchar(50) NOT NULL,
  `youtube_link` varchar(50) NOT NULL,
  PRIMARY KEY (`id_profile`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `testimonial` (
  `id_testimonial` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `approval` bit(1) NOT NULL,
  `avatar_path` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `datetime` datetime NOT NULL,
  `image_background_path` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `occupation` varchar(100) NOT NULL,
  `prime` bit(1) NOT NULL,
  `website` longtext NOT NULL,
  PRIMARY KEY (`id_testimonial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `avatar_path` varchar(50) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `password` longtext NOT NULL,
  `role` longtext NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
