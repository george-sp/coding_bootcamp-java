CREATE TABLE `bootcamp_db`.`student_table` (
 `am` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
 `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
 `surname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
 `username` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
 `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
 PRIMARY KEY (`am`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;