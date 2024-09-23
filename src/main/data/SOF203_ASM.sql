USE SOF203_ASM

DROP TABLE IF EXISTS CATEGORIES;
CREATE TABLE CATEGORIES (
    Id NVARCHAR(50) PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    Id NVARCHAR(50) PRIMARY KEY,
    Password NVARCHAR(255) NOT NULL,
    Fullname NVARCHAR(255),
    Birthday DATE,
    Gender BIT,
    Mobile NVARCHAR(50),
    Email NVARCHAR(255),
    Role BIT -- true là quản trị, false là phóng viên
);

DROP TABLE IF EXISTS NEWS;
CREATE TABLE NEWS (
    Id NVARCHAR(50) PRIMARY KEY,
    Title NVARCHAR(255) NOT NULL,
    Content NVARCHAR(MAX),
    Image NVARCHAR(255),
    PostedDate DATE,
    Author NVARCHAR(50),
    ViewCount INT DEFAULT 0,
    CategoryId NVARCHAR(50),
    Home BIT,
    FOREIGN KEY (Author) REFERENCES USERS(Id),
    FOREIGN KEY (CategoryId) REFERENCES CATEGORIES(Id)
);

DROP TABLE IF EXISTS NEWSLETTERS;
CREATE TABLE NEWSLETTERS (
    Email NVARCHAR(255) PRIMARY KEY,
    Enabled BIT -- true là còn hiệu lực
);

-- INSERT DATA --
-----------------
INSERT INTO CATEGORIES (Id, Name) VALUES
('C01', N'Văn hoá'),
('C02', N'Pháp luật'),
('C03', N'Thể thao'),
('C04', N'Du lịch');

INSERT INTO USERS (Id, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES
('U01', '123456', N'Nguyễn Đàm Hoàng Linh', '1985-05-15', 1, '0905123456', 'ndhl@example.com', 1),
('U02', '123', N'Lê Thị Nhàng', '1990-07-10', 0, '0906789123', 'ltn@example.com', 0),
('U03', '123', N'Trần Văn Công', '1992-03-22', 1, '0908765432', 'tvc@example.com', 0),
('U04', '123', N'Phạm Minh Dương', '1988-11-30', 1, '0909876543', 'pmd@example.com', 0),
('U05', '123456', N'Nguyễn Phan Lâm Hùng', '1986-04-16', 1, '0906543210', 'nplh@example.com', 1),
('U06', '123', N'Võ Văn Toàn', '1995-09-12', 1, '0905432123', 'vvt@example.com', 0),
('U07', '123', N'Đỗ Thị Giang Anh', '1991-06-05', 0, '0902123456', 'dtga@example.com', 0),
('U08', '123', N'Lý Văn Hiệp', '1987-01-21', 1, '0909876123', 'lvh@example.com', 1),
('U09', '123', N'Ngô Thị Thu Nhi', '1993-02-18', 0, '0908761234', 'nttn@example.com', 0),
('U10', '123', N'Bùi Văn Quyết', '1994-12-03', 1, '0906549876', 'bvq@example.com', 0);

INSERT INTO NEWS (Id, Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) VALUES
(N'N01', N'Sự kiện Văn hóa Việt Nam', N'Nội dung bài viết về sự kiện văn hóa.', N'image1.jpg', '2024-09-01', N'U01', 120, N'C01', 1),
(N'N02', N'Luật Giao Thông mới', N'Chi tiết về luật giao thông mới.', N'image2.jpg', '2024-09-02', N'U02', 300, N'C02', 1),
(N'N03', N'Chiến thắng của đội tuyển bóng đá', N'Thông tin về trận đấu bóng đá.', N'image3.jpg', '2024-09-03', N'U03', 500, N'C03', 1),
(N'N04', N'Cẩm nang du lịch mùa hè', N'Hướng dẫn về các điểm du lịch.', N'image4.jpg', '2024-09-04', N'U04', 80, N'C04', 0),
(N'N05', N'Sự kiện âm nhạc lớn', N'Nội dung về sự kiện âm nhạc.', N'image5.jpg', '2024-09-05', N'U05', 230, N'C01', 1),
(N'N06', N'Cập nhật mới nhất về pháp luật', N'Thông tin về các quy định mới.', N'image6.jpg', '2024-09-06', N'U06', 150, N'C02', 0),
(N'N07', N'Giải Marathon quốc tế', N'Thông tin về giải đấu Marathon.', N'image7.jpg', '2024-09-07', N'U07', 400, N'C03', 1),
(N'N08', N'Khám phá điểm du lịch mới', N'Giới thiệu về điểm du lịch.', N'image8.jpg', '2024-09-08', N'U08', 90, N'C04', 0),
(N'N09', N'Triển lãm nghệ thuật quốc tế', N'Nội dung về triển lãm nghệ thuật.', N'image9.jpg', '2024-09-09', N'U09', 270, N'C01', 1),
(N'N10', N'Phân tích về pháp luật quốc tế', N'Chi tiết về luật pháp quốc tế.', N'image10.jpg', '2024-09-10', N'U10', 180, N'C02', 0),
(N'N11', N'Trận chung kết bóng đá', N'Nội dung về trận chung kết.', N'image11.jpg', '2024-09-11', N'U03', 620, N'C03', 1),
(N'N12', N'Hướng dẫn du lịch tiết kiệm', N'Mẹo du lịch tiết kiệm.', N'image12.jpg', '2024-09-12', N'U04', 50, N'C04', 0),
(N'N13', N'Liên hoan phim quốc tế', N'Chi tiết về liên hoan phim.', N'image13.jpg', '2024-09-13', N'U05', 240, N'C01', 1),
(N'N14', N'Luật mới về môi trường', N'Nội dung luật môi trường mới.', N'image14.jpg', '2024-09-14', N'U06', 110, N'C02', 0),
(N'N15', N'Sự kiện thể thao thế giới', N'Thông tin về các sự kiện thể thao.', N'image15.jpg', '2024-09-15', N'U07', 450, N'C03', 1),
(N'N16', N'Khám phá văn hoá dân gian', N'Giới thiệu về văn hoá dân gian.', N'image16.jpg', '2024-09-16', N'U01', 130, N'C01', 0),
(N'N17', N'Hướng dẫn pháp luật cho doanh nghiệp', N'Quy định pháp luật cho doanh nghiệp.', N'image17.jpg', '2024-09-17', N'U02', 320, N'C02', 0),
(N'N18', N'Giải vô địch bóng chuyền', N'Thông tin về giải đấu bóng chuyền.', N'image18.jpg', '2024-09-18', N'U03', 500, N'C03', 1),
(N'N19', N'Điểm du lịch mới tại Đà Nẵng', N'Khám phá địa điểm du lịch tại Đà Nẵng.', N'image19.jpg', '2024-09-19', N'U04', 95, N'C04', 1),
(N'N20', N'Thảo luận về pháp luật quốc tế', N'Nội dung về thảo luận pháp luật.', N'image20.jpg', '2024-09-20', N'U06', 210, N'C02', 0);

INSERT INTO NEWSLETTERS (Email, Enabled) VALUES
('email1@example.com', 1),
('email2@example.com', 1),
('email3@example.com', 0),
('email4@example.com', 1),
('email5@example.com', 1),
('email6@example.com', 0),
('email7@example.com', 1),
('email8@example.com', 1),
('email9@example.com', 0),
('email10@example.com', 1),
('email11@example.com', 1),
('email12@example.com', 0),
('email13@example.com', 1),
('email14@example.com', 1),
('email15@example.com', 0),
('email16@example.com', 1),
('email17@example.com', 1),
('email18@example.com', 0),
('email19@example.com', 1),
('email20@example.com', 1);
