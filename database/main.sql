CREATE DATABASE shopee;

USE shopee;

CREATE TABLE category_data
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    image    VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    link     VARCHAR(255) NULL,
    is_empty BOOLEAN      NOT NULL
);

CREATE TABLE slider_banner_data
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(70)  NOT NULL,
    image    VARCHAR(255) NOT NULL,
    is_empty BOOLEAN      NOT NULL
);