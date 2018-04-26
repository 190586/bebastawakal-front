Instalasi Aplikasi Web FWD :
1. Buka file application.properties
2. Pada baris konfigurasi berikut digunakan untuk setting database
		spring.datasource.url=jdbc:mysql://127.0.0.1:3306/fwd_new?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8
		spring.datasource.username=root
		spring.datasource.password=root
		spring.datasource.testOnBorrow=true
		spring.datasource.validationQuery=SELECT 1
	a. Persiapkan sebuah database MySQL kosong, kemudian set namanya pada baris konfigurasi spring.datasource.url
	b. Ubah baris konfigurasi spring.datasource.username merupakan username database dan baris konfigurasi spring.datasource.password merupakan password
	c. Baris konfigurasi spring.datasource.testOnBorrow merupakan pilihan agar selalu dilakukan pengecekan database sebelum mengambil koneksi database dari pool
	d. Baris konfigurasi spring.datasource.validationQuery merupakan query validasi, dalam hal ini MySQL menggunakan SELECT 1 sebagai query validasi nya
3. Baris konfigurasi server.port akan bernilai port yang digunakan untuk meng-akses web FWD, nilai default nya 8080
4. Baris konfigurasi fwd.path.image merupakan folder rujukan untuk menempatkan file- file yang di upload, contoh : C:/Users/riza/Documents/NetBeansProjects/FWD/trunk/upload/
	a. Untuk folder upload ini silahkan persiapkan sebuah folder yang berisi 3 folder avatar, icon dan image
	b. Kemudian ubah nilai baris konfigurasi fwd.path.image dengan path absolute dimana folder tersebut berada
5. Kemudian jalankan file run.bat hingga pada cmd muncul Started FWDPortalWebApplication in XX.XX seconds
6. Masukkan record data ke database secara manual dengan menggunakan file fwd_backup.sql