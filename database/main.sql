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

CREATE TABLE product_data
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    image           VARCHAR(255) NOT NULL,
    name            VARCHAR(100) NOT NULL,
    price           DOUBLE       NOT NULL,
    selled          INT          NOT NULL,
    image_options   VARCHAR(255) NOT NULL,
    discount_top    INT          NOT NULL,
    discount_bottom INT          NOT NULL,
    is_empty        BOOLEAN      NOT NULL
);

# Update
# Tạo bảng "users" để lưu thông tin người dùng:
CREATE TABLE users
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    first_name   VARCHAR(50)  NOT NULL,
    last_name    VARCHAR(50)  NOT NULL,
    address      VARCHAR(100) NOT NULL,
    phone_number VARCHAR(10)  NOT NULL,
    user_role    INT          NOT NULL,
    is_empty     BOOLEAN      NOT NULL DEFAULT TRUE
);

# Tạo bảng "orders" để lưu thông tin về các đơn hàng
CREATE TABLE orders
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    user_id      INT,
    order_date   DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

# Tạo bảng "order_items" để lưu chi tiết đơn hàng (sản phẩm và số lượng)
CREATE TABLE order_items
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    order_id     INT,
    product_name VARCHAR(255) NOT NULL,
    quantity     INT,
    price        DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES orders (id)
);

# Tạo bảng "addresses" để lưu trữ thông tin địa chỉ
CREATE TABLE addresses
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    user_id        INT,
    street_address VARCHAR(255) NOT NULL,
    city           VARCHAR(255) NOT NULL,
    state          VARCHAR(255) NOT NULL,
    postal_code    VARCHAR(10)  NOT NULL,
    country        VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

