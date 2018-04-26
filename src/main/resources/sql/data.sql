INSERT INTO `menu` (`id_menu`, `type`, `image_path`, `title`, `url`, `short_description`, `description`, `button_text`, `orders`, `data_href`, `start_time`, `end_time`, `active`) VALUES
	(1, 'CAROUSEL', 'image/jumbotron-big.png', 'GET READY TO LIVE', '#', NULL, NULL, NULL, 1, 0, '2017-10-19 00:00:00', '2019-10-21 23:59:59', 1),
	(2, 'CAROUSEL', 'image/jumbotron-big.png', 'GET READY TO LIVE', '#', '', '', '', 2, 0, '2017-10-20 07:00:00', '2019-10-21 07:00:00', 1),
	(3, 'CAROUSEL', 'image/jumbotron-big.png', 'GET READY TO LIVE', '#', '', '', '', 3, 0, '2017-10-20 07:00:00', '2019-10-21 07:00:00', 1),
	(4, 'STATIC-RIGHT', 'image/smalltron-1.png', 'Bebas Aksi Flash', '#', NULL, NULL, NULL, 1, 0, '2017-10-21 00:00:00', '2019-10-21 23:59:59', 1),
	(5, 'STATIC-RIGHT', 'image/smalltron-2.png', 'Bebas Aksi', '#', NULL, NULL, NULL, 2, 0, '2017-10-21 00:00:00', '2019-10-21 23:59:59', 1),
	(6, 'STATIC-RIGHT', 'image/smalltron-3.png', 'Bebas Rencana', '#', NULL, NULL, NULL, 3, 0, '2017-10-21 00:00:00', '2019-10-21 23:59:59', 1),
	(7, 'FIRST-MENU', '', 'Beranda', '#', NULL, NULL, NULL, 1, 0, '2017-10-23 05:27:06', '2019-10-23 05:28:35', 1),
	(8, 'FIRST-MENU', '', 'Tentang Kami', '#', NULL, NULL, NULL, 2, 0, '2017-10-23 05:27:25', '2019-10-23 05:28:44', 1),
	(9, 'FIRST-MENU', '', 'MASUK <span class="caret rotate-to-right"></span>', '#', NULL, NULL, NULL, 3, 0, '2017-10-23 05:27:45', '2019-10-23 05:28:48', 1),
	(10, 'FIRST-MENU', '', 'Chat Sekarang', '#', NULL, NULL, NULL, 4, 0, '2017-10-23 05:28:23', '2019-10-23 05:28:53', 1),
	(11, 'SECONDARY-MENU', '', 'WHY INSURANCE', '#insurance', NULL, NULL, NULL, 1, 1, '2017-10-23 05:29:58', '2019-10-23 05:30:47', 1),
	(12, 'SECONDARY-MENU', '', 'TESTIMONI', '#testimoni', NULL, NULL, NULL, 2, 1, '2017-10-23 05:30:08', '2019-10-23 05:30:51', 1),
	(13, 'SECONDARY-MENU', '', 'BEBAS <span class="caret orange"></span></a>', '#bebas', NULL, NULL, NULL, 3, 1, '2017-10-23 05:30:26', '2019-10-23 05:30:56', 1),
	(14, 'MOBILE-MENU', 'glyphicon glyphicon-home', 'Beranda', '#', NULL, NULL, NULL, 1, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(15, 'MOBILE-MENU', 'glyphicon glyphicon-tags', 'Tentang Kami', '#', NULL, NULL, NULL, 2, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(16, 'MOBILE-MENU', 'glyphicon glyphicon-log-in', 'Masuk', '/login', NULL, NULL, NULL, 3, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(17, 'MOBILE-MENU', 'glyphicon glyphicon-user', 'Chat Sekarang', '#', NULL, NULL, NULL, 4, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(18, 'MOBILE-MENU', 'glyphicon glyphicon-leaf', 'Why Insurance', '#insurance', NULL, NULL, NULL, 5, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(19, 'MOBILE-MENU', 'glyphicon glyphicon-duplicate', 'Testimoni', '#testimoni', NULL, NULL, NULL, 6, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(20, 'MOBILE-MENU', 'glyphicon glyphicon-grain', 'Bebas', '#bebas', NULL, NULL, NULL, 7, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(24, 'FOOTER-LEFT', '', 'Online Security', '#', NULL, NULL, NULL, 1, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(25, 'FOOTER-LEFT', '', 'Disclaimer', '#', NULL, NULL, NULL, 2, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1),
	(26, 'FOOTER-RIGHT', '', 'Copyright &copy; 2017 All Right Reserved', '#', NULL, NULL, NULL, 1, 0, '2017-10-23 00:00:00', '2019-10-23 23:59:59', 1);
INSERT INTO `page` (`id_page`, `type`, `title`, `breadcrumb`, `content`, `code`, `header_image_path`, `icon_path`, `button_text`, `orders`, `active`) VALUES
	(1, 'WHY-INSURANCE', 'KLAIMNYA NYAMAN.', 'Cukup 3 langkah:<ol><li>Download dan isi form</li><li>Kiri Kembali Form lewat email dan pos</li><li>Terima pembayaran</li></ol>', 'Cukup 3 langkah:<ol><li>Download dan isi form</li><li>Kiri Kembali Form lewat email dan pos</li><li>Terima pembayaran</li></ol>', 'klaimnya-nyaman', '', 'icon/aatkxv3SUb.png', 'Lihat Video Tutorial', 1, 1),
	(2, 'WHY-INSURANCE', 'BELINYA MUDAH.', 'Ribet? No way!Beli asuransi kami secara online dengan mudah, kapan saja dimana saja', 'Ribet? No way!Beli asuransi kami secara online dengan mudah, kapan saja dimana saja', 'belinya-mudah', NULL, 'icon/gd6OB7LFFB.png', 'Lihat Lebih Detail', 2, 1),
	(3, 'WHY-INSURANCE', 'TRANSAKSINYA AMAN.', 'Aman dengan Secure Protocol dan fitur otentifikasi ganda.', 'Aman dengan Secure Protocol dan fitur otentifikasi ganda.', 'transaksinya-aman', NULL, 'icon/99bV7abvWo.png', '', 3, 1),
	(4, 'WHY-INSURANCE', 'PERLINDUNGANNYA TRANSPARAN.', 'Hanya ada 2 pengecualian:<ol><li>Menyakiti Diri Sendiri</li><li>Melanggar Hukum</li></ol>', 'Hanya ada 2 pengecualian:<ol><li>Menyakiti Diri Sendiri</li><li>Melanggar Hukum</li></ol>', 'perlindungannya-transparan', NULL, 'icon/vHTr0Zvg1V.png', '', 4, 1),
	(5, 'CELEBRATE-LIVING', 'Celebrate Living', 'This is at the very core of our purpose, our strategy, our customer experience, and our internal culture.', '', 'celebrate-living', 'image/NFft77EhpE.png', '', '', 1, 1),
	(6, 'BEBAS', 'CLICK TO MEET', 'Atur jadwal bertemu dengan agen pilihan kamu hanya dengan 3 langkah mudah!', 'Atur jadwal bertemu dengan agen pilihan kamu hanya dengan 3 langkah mudah!', 'click-to-meet', 'image/x4ubchUoCR.png', '', '', 1, 1),
	(7, 'BEBAS', 'FWD MAX', 'Kami berkomitmen untuk memberikan nilai terbaik Kepada Passionate Customer kami!', 'Kami berkomitmen untuk memberikan nilai terbaik Kepada Passionate Customer kami!', 'fwd-max', 'image/r3tortMcCB.png', '', '', 2, 1),
	(8, 'BEBAS', 'PASSION STORY', 'Ketahui detail mengenai Polis Asuransi kamu di Customer Portal', 'Ketahui detail mengenai Polis Asuransi kamu di Customer Portal', 'passion-story', 'image/d4p0FYHxeI.png', '', '', 3, 1),
	(9, 'BEBAS', 'CUSTOMER PORTAL', 'Ketahui detail mengenai Polis Asuransi kamu di Customer Portal', 'Ketahui detail mengenai Polis Asuransi kamu di Customer Portal', 'customer-portal', 'image/66FKusgvDw.png', '', '', 4, 1),
	(10, 'PRODUCT', 'Bebas Aksi Flash', NULL, NULL, 'bebas-aksi-flash', NULL, NULL, NULL, 1, 1),
	(11, 'PRODUCT', 'Bebas Aksi', NULL, NULL, 'bebas-aksi', NULL, NULL, NULL, 2, 1),
	(12, 'PRODUCT', 'Bebas Aksi Rencana', NULL, NULL, 'bebas-aksi-rencana', NULL, NULL, NULL, 3, 1),
	(13, 'CUSTOMER-PLACE', 'FAQ', NULL, NULL, 'faq', NULL, NULL, NULL, 1, 1),
	(14, 'CUSTOMER-PLACE', 'Claim', NULL, NULL, 'claim', NULL, NULL, NULL, 2, 1),
	(15, 'CUSTOMER-PLACE', 'Cara Beli', NULL, NULL, 'cara-beli', NULL, NULL, NULL, 3, 1),
	(16, 'CUSTOMER-PLACE', 'Beli', NULL, NULL, 'beli', NULL, NULL, NULL, 4, 1),
	(17, 'SECONDARY-MENU', 'WHY INSURANCE', NULL, NULL, '#insurance', NULL, NULL, NULL, 1, 1),
	(18, 'SECONDARY-MENU', 'TESTIMONI', NULL, NULL, '#testimoni', NULL, NULL, NULL, 2, 1),
	(19, 'SECONDARY-MENU', 'BEBAS <span class="caret orange"></span></a>', '', '', '.section-3', '', '', '', 3, 1);
INSERT INTO `setting` (`id_profile`, `company_name`, `address1`, `address2`, `hotline`, `email`, `logo`, `footer_description`, `instagram_link`, `youtube_link`, `facebook_link`, `twitter_link`, `prime`) VALUES
	(1, 'PT FWD Life Indonesia', 'Jalan Sudirman', 'DKI Jakarta', '+62 1500 392', 'cs@fwd.co.id', 'image/I0SiFIXYl3.png', '<p>PT FWD Life Indonesia ("FWD Life") adalah perusahaan asuransi jiwa patungan dan merupakan bagian dari FWD Group. FWD Life berdiri sejak November 2012 dan memperoleh izin di bidang asuransi jiwa dari Otoritas Jasa Keuangan (OJK) pada bulan Februari 2013. FWD Life terdaftar dan tunduk pada pengawasan OJK. iFWD Liberate adalah nama salah satu jalur distribusi asuransi melalui daring (online) dari FWD Life.</p>', 'http://instagram.com/@fwd', 'http://youtube.com/@fwd', 'http://facebook.com/fwd', 'http://twitter.com/@fwd', 1);
INSERT INTO `testimonial` (`id_testimonial`, `datetime`, `name`, `age`, `occupation`, `content`, `avatar_path`, `website`, `prime`, `image_background_path`, `approval`) VALUES
	(1, '2017-11-10 11:32:56', 'Mario Iroth', 37, 'Founder Wheel Story', '<p>Proteksi asuransi sangat penting terlebih untuk kegiatan extreme yang kami lakukan yaitu traveling bermotor, banyak hal yang bisa terjadi diluar dugaan.</p><p>Kami merupakan pemegang produk asuransi personal accident FWD Life Bebas Aksi, dimana proses pembelian dapat dilakukan dengan sangat mudah,  secara online melalui website FWD Life. Dengan Bebas Aksi juga mendukung passion kami sepenuhnya  sampai passion dengan risiko tinggi sekalipun seperti yang kami lakukan sekarang ini.</p>', 'avatar/Pl4m6UAlfz.png', 'http://wheelstoryadv.com', 1, 'image/menV4tA8HE.png', 1),
	(2, '2017-11-02 22:18:41', 'Patrix Tenario', 39, 'Designer', '<p>BAF, BAF apa yg ngeselin? BAFering pas nonton YouTube, tapi kalo BAF dari FWD sih selalu nyenengin, makasih FWD!</p>', 'avatar/Pl4m6UAlfz.png', 'http://designer.com', 0, NULL, 1),
	(3, '2017-11-19 01:25:04', 'Patrixs', 40, 'Designer', '<p>BAF, BAF apa yg ngeselin? BAFering pas nonton YouTube, tapi kalo BAF dari FWD sih selalu nyenengin, makasih FWD!</p>', 'avatar/Pl4m6UAlfz.png', 'http://designer.com', 0, '', 1),
	(4, '2017-11-04 14:15:48', 'Riza Dwi Arifiyanto', 31, 'Programmer', '<p>Testing aja ini</p>', 'avatar/Pl4m6UAlfz.png', 'test.co.id', 0, '', 0),
	(5, '2017-11-10 19:49:34', 'Riza Dwi Arifiyanto', 31, 'Developer', '<p>FWD sangat membantu dan fleksibel sekali. Cakep banget lah! Terima kasih FWD!</p>', 'avatar/fxsDTd5p07.png', 'website.com', 0, NULL, 0);
INSERT INTO `user` (`id_user`, `username`, `password`, `role`, `fullname`, `avatar_path`, `active`) VALUES
	(1, 'rizadwia@gmail.com', '$2a$10$zN6U/VHXh3oJnZexnTCfWebR18rPsDIwWThWh54uo33crgJ5f9AKK', 'ADMIN', 'Riza Dwi Arifiyanto', 'avatar/46GSD1QWbt.png', 1);
