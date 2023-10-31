CREATE DATABASE IF NOT EXISTS quan_ly_de_an CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci';

USE quan_ly_de_an;
CREATE TABLE IF NOT EXISTS congviec
(
    MADA          int(11)     NOT NULL,
    STT           int(11)     NOT NULL,
    TEN_CONG_VIEC varchar(50) NOT NULL,
    PRIMARY KEY (MADA, STT)
) ENGINE = INNODB;

INSERT INTO congviec
VALUES (1, 1, "Thiết kế sản phẩm X"),
       (1, 2, "Thử nghiệm sản phẩm X "),
       (2, 1, "Sản xuất sản phẩm Y "),
       (2, 2, "Quảng cáo sản phẩm Y "),
       (3, 1, "Khuyến mãi sản phẩm Z "),
       (10, 1, "Tin học hóa nhân sự tiền lương "),
       (10, 2, "Tin hoc hóa phòng Kinh doanh "),
       (20, 1, "Lắp đặt cáp quang "),
       (30, 1, "Đào tạo nhân viên Marketing "),
       (30, 2, "Đào  tạo chuyên viên thiết kế ");



CREATE TABLE IF NOT EXISTS dean
(
    TENDA    varchar(15),
    MADA     int(11)     NOT NULL,
    DDIEM_DA varchar(15) NOT NULL,
    PHONG    int(11)     NOT NULL,
    PRIMARY KEY (MADA)
) ENGINE = INNODB;


INSERT INTO dean (TENDA, MADA, DDIEM_DA, PHONG)
VALUES ("San pham X ", 1, "Vũng Tàu ", 5),
       ("San pham Y ", 2, "Nha Trang ", 5),
       ("San pham Z ", 3, "TP HCM ", 5),
       ("Tin hoc hoa ", 10, "Hà Nội ", 4),
       ("Cap quang ", 20, "TP HCM ", 1),
       ("Dao tao ", 30, "Hà Nội ", 4);


CREATE TABLE IF NOT EXISTS diadiem_phg
(
    MAPHG   int(11)     NOT NULL,
    DIADIEM varchar(15) NOT NULL,
    PRIMARY KEY (MAPHG, DIADIEM)
) ENGINE = INNODB;

INSERT INTO diadiem_phg (MAPHG, DIADIEM)
VALUES (1, "TP HCM "),
       (4, "Hà Nội "),
       (5, "NHA TRANG "),
       (5, "TAU "),
       (5, "TP HCM ");


CREATE TABLE IF NOT EXISTS nhanvien
(
    HONV   varchar(15) NOT NULL,
    TENLOT varchar(15) NOT NULL,
    TENNV  varchar(15) NOT NULL,
    MANV   varchar(9)  NOT NULL,
    NGSINH date        NOT NULL,
    DCHI   varchar(30) NOT NULL,
    PHAI   varchar(3)  NOT NULL,
    LUONG  double      NOT NULL,
    MA_NQL varchar(9)  NOT NULL,
    PHG    int(11)     NOT NULL,
    PRIMARY KEY (MANV)
) ENGINE = INNODB;

INSERT INTO nhanvien (HONV, TENLOT, TENNV, MANV, NGSINH, DCHI, PHAI, LUONG, MA_NQL, PHG)
VALUES ("Lê ", "Quỳnh ", "Như ", "001 ", "1967-02-02 ", "291 Hồ Văn Huê, TpHCM ", "Nữ ", 43000, "006 ", 4),
       ("Trần ", "Thanh ", "Tâm ", "003 ", "1957-05-04 ", "34 Mai Thị Lự, Tp HCM ", "Nam ", 25000, "005 ", 5),
       ("Nguyễn ", "Mạnh ", "Hùng ", "004 ", "1967-03-04 ", "95 Bà Rịa, Vũng Tàu ", "Nam ", 38000, "005 ", 5),
       ("Nguyễn ", "Thanh ", "Tùng ", "005 ", "1962-08-20 ", "222 Nguyễn Văn Cừ, Tp HCM ", "Nam ", 40000, "006 ", 5),
       ("Phạm ", "Văn ", "Vinh ", "006 ", "1965-01-01 ", "45 Trưng Vương, Hà Nội ", "Nam ", 55000, "001 ", 1),
       ("Bùi ", "Ngọc  ", "Hằng ", "007 ", "1954-03-11 ", "332 Nguyễn Thái Học, TpHCM ", "Nữ ", 25000, "001 ", 4),
       ("Trần  ", "Hồng ", "Quang ", "008 ", "1967-09-01 ", "80 Lê Hồng Phong, Tp HCM ", "Nam ", 25000, "001 ", 4),
       ("Đinh ", "Bá ", "Tiên ", "009 ", "1960-02-11 ", "119 Cống Quỳnh, Tp HCM ", "Nam ", 30000, "005 ", 5);

CREATE TABLE IF NOT EXISTS phancong
(
    MA_NVIEN varchar(9)   NOT NULL,
    MADA     int(11)      NOT NULL,
    STT      int(11)      NOT NULL,
    THOIGIAN double(5, 1) NOT NULL,
    PRIMARY KEY (MA_NVIEN, MADA, STT)
) ENGINE = INNODB;

INSERT INTO phancong (MA_NVIEN, MADA, STT, THOIGIAN)
VALUES ("001 ", 20, 1, 15.0),
       ("001 ", 30, 1, 20.0),
       ("003 ", 1, 2, 20.0),
       ("003 ", 2, 1, 20.0),
       ("004 ", 3, 1, 40.0),
       ("005 ", 3, 1, 10.0),
       ("005 ", 10, 2, 10.0),
       ("005 ", 20, 1, 10.0),
       ("006 ", 20, 1, 30.0),
       ("007 ", 10, 2, 10.0),
       ("007 ", 30, 2, 30.0),
       ("008 ", 10, 1, 35.0),
       ("008 ", 30, 2, 5.0),
       ("009 ", 1, 1, 32.0),
       ("009 ", 2, 2, 8.0);

CREATE TABLE IF NOT EXISTS phongban
(
    TENPHG      varchar(15) NOT NULL,
    MAPHG       int(11)     NOT NULL,
    TRPHG       varchar(9)  NOT NULL,
    NG_NHANCHUC date        NOT NULL,
    PRIMARY KEY (MAPHG)
) ENGINE = INNODB;

INSERT INTO phongban (TENPHG, MAPHG, TRPHG, NG_NHANCHUC)
VALUES ("Quản lý ", 1, "006 ", "1971-06-19 "),
       ("Điều hành ", 4, "008 ", "1980-01-01 "),
       ("Nghiên cứu ", 5, "005 ", "1978-05-22 ");

CREATE TABLE IF NOT EXISTS thannhan
(
    MA_NVIEN varchar(9)  NOT NULL,
    TENTN    varchar(15) NOT NULL,
    PHAI     varchar(3)  NOT NULL,
    NGSINH   date        NOT NULL,
    QUANHE   varchar(15) NOT NULL,
    PRIMARY KEY (MA_NVIEN, TENTN)
) ENGINE = INNODB;

INSERT INTO thannhan (MA_NVIEN, TENTN, PHAI, NGSINH, QUANHE)
VALUES ("001 ", "Minh ", "Nam ", "1932-02-29 ", "Vợ chồng "),
       ("005 ", "Khang ", "Nam ", "1073-10-25 ", "Con trai "),
       ("005 ", "Phương ", "Nữ ", "1948-05-03 ", "Vợ chồng "),
       ("005 ", "Trinh ", "Nữ ", "1976-04-05 ", "Con gái "),
       ("009 ", "Châu ", "Nữ ", "1978-12-30 ", "Con gái "),
       ("009 ", "Phương ", "Nữ ", "1957-05-05 ", "Vợ chồng "),
       ("009 ", "Tiến ", "Nam ", "1978-01-01 ", "Con trai ");

ALTER TABLE nhanvien
    ADD FOREIGN KEY (MA_NQL) REFERENCES nhanvien (MANV);
ALTER TABLE nhanvien
    ADD CONSTRAINT FOREIGN KEY (PHG) REFERENCES phongban (MAPHG);

ALTER TABLE phongban
    ADD FOREIGN KEY (TRPHG) REFERENCES nhanvien (MANV);

ALTER TABLE thannhan
    ADD FOREIGN KEY (MA_NVIEN) REFERENCES nhanvien (MANV);

ALTER TABLE congviec
    ADD FOREIGN KEY (MADA) REFERENCES dean (MADA);

ALTER TABLE phancong
    ADD FOREIGN KEY (MADA) REFERENCES congviec (MADA);

ALTER TABLE dean
    ADD FOREIGN KEY (PHONG) REFERENCES phongban (MAPHG);

ALTER TABLE diadiem_phg
    ADD FOREIGN KEY (MAPHG) REFERENCES phongban (MAPHG);

# Bài làm
# Bai 1
SELECT *
FROM nhanvien
WHERE PHG = 4;

# Bai 2
SELECT *
FROM nhanvien
WHERE LUONG > 30000;

#Bai 3
SELECT *
FROM nhanvien
WHERE (LUONG > 25000 AND PHG = 4)
   OR (LUONG > 30000 AND PHG = 5);

#Bai 4
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE DCHI LIKE '%TP HCM%';

#Bai 5
SELECT HONV, TENLOT, TENNV
FROM nhanvien
WHERE HONV LIKE 'N%';

#Bai 6
SELECT NGSINH, DCHI
FROM nhanvien
WHERE HONV = 'Đinh'
  AND TENLOT = 'Bá'
  AND TENNV = 'Tiên';

#Bai 7
SELECT *
FROM nhanvien
WHERE YEAR(NGSINH) BETWEEN 1960 AND 1965;

#Bai 8
SELECT *, YEAR(NGSINH)
FROM nhanvien;

#Bai 9
SELECT *, ROUND(DATEDIFF(NOW(), NGSINH) / 365, 0)
FROM nhanvien;

#Bai 10
SELECT pb.TENPHG, dd.DIADIEM
FROM phongban pb,
     diadiem_phg dd
WHERE pb.MAPHG = dd.MAPHG;

# SELECT pb.TENPHG,diadiem_phg.DIADIEM
# FROM phongban pb
# NATURAL JOIN diadiem_phg;
#
# SELECT pb.TENPHG,dp.DIADIEM
# FROM phongban pb
# JOIN diadiem_phg dp ON pb.MAPHG = dp.MAPHG;

#Bai 11
SELECT nv.TENNV
FROM nhanvien nv,
     phongban pb
WHERE nv.MANV = pb.TRPHG;

#Bai 12
SELECT TENNV, DCHI
FROM nhanvien
WHERE PHG = (SELECT MAPHG
             FROM phongban
             WHERE TENPHG = 'Nghiên cứu');

#Bai 13
SELECT da.TENDA, pb.TENPHG, nv.HONV, nv.TENLOT, nv.TENNV, pb.NG_NHANCHUC
FROM dean da
         JOIN phongban pb ON da.PHONG = pb.MAPHG
         JOIN nhanvien nv ON pb.TRPHG = nv.MANV
WHERE da.DDIEM_DA = 'Hà Nội';

#Bài 14
SELECT nv.TENNV, tn.TENTN
FROM nhanvien nv, thannhan tn
WHERE nv.PHAI = 'Nữ ';

#Bài 15
SELECT CONCAT(nv1.HONV, ' ', nv1.TENLOT, ' ', nv1.TENNV) AS NHANVIEN,
       CONCAT(nv2.HONV, ' ', nv2.TENLOT, ' ', nv2.TENNV) AS NGUOIQUANLY
FROM nhanvien nv1
JOIN nhanvien nv2 ON nv1.MA_NQL = nv2.MANV;

#Bai 16
SELECT CONCAT(nv.HONV, ' ', nv.TENLOT, ' ', nv.TENNV)    AS NHANVIEN,
       CONCAT(tp.HONV, ' ', tp.TENLOT, ' ', tp.TENNV)    AS TRUONGPHONG,
       CONCAT(nql.HONV, ' ', nql.TENLOT, ' ', nql.TENNV) AS NGUOIQTL
FROM nhanvien nv
         JOIN phongban pb ON nv.PHG = pb.MAPHG
         JOIN nhanvien tp ON tp.MANV = pb.TRPHG
         JOIN nhanvien nql ON nv.MA_NQL = nql.MANV;

#Bai 17
SELECT nv.HONV, nv.TENLOT, nv.TENNV
FROM nhanvien nv
         JOIN phancong pc ON nv.MANV = pc.MA_NVIEN
         JOIN congviec cv ON pc.MADA = cv.MADA
         JOIN dean d ON cv.MADA = d.MADA
         JOIN phongban pb ON d.PHONG = pb.MAPHG
WHERE pb.MAPHG = 5
  AND cv.TEN_CONG_VIEC = 'Thiết kế sản phẩm X'
  AND nv.MA_NQL = '005';