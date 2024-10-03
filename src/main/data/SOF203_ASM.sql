--DROP DATABASE IF EXISTS SOF203_ASM
--CREATE DATABASE SOF203_ASM;
USE SOF203_ASM;

DROP TABLE IF EXISTS CATEGORIES;
CREATE TABLE CATEGORIES (
    Id int IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    Id int IDENTITY(1,1) PRIMARY KEY,
	Username NVARCHAR(255) not null unique,
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
    Id int IDENTITY(1,1) PRIMARY KEY,
    Title NVARCHAR(255) NOT NULL,
    Content NVARCHAR(MAX),
    Image NVARCHAR(255),
    PostedDate DATE,
    Author int,
    ViewCount INT DEFAULT 0,
    CategoryId int,
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
INSERT INTO CATEGORIES (Name) VALUES
(N'Văn hoá'),
(N'Pháp luật'),
(N'Thể thao'),
(N'Du lịch');

INSERT INTO USERS (Username, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES
('user001','123456', N'Nguyễn Đàm Hoàng Linh', '1985-05-15', 1, '0905123456', 'ndhl@example.com', 1),
('user002','123', N'Lê Thị Nhàng', '1990-07-10', 0, '0906789123', 'ltn@example.com', 0),
('user003','123', N'Trần Văn Công', '1992-03-22', 1, '0908765432', 'tvc@example.com', 0),
('user004','123', N'Phạm Minh Dương', '1988-11-30', 1, '0909876543', 'pmd@example.com', 0),
('user005','123456', N'Nguyễn Phan Lâm Hùng', '1986-04-16', 1, '0906543210', 'nplh@example.com', 1),
('user006','123', N'Võ Văn Toàn', '1995-09-12', 1, '0905432123', 'vvt@example.com', 0),
('user007','123', N'Đỗ Thị Giang Anh', '1991-06-05', 0, '0902123456', 'dtga@example.com', 0),
('user008','123', N'Lý Văn Hiệp', '1987-01-21', 1, '0909876123', 'lvh@example.com', 1),
('user009','123', N'Ngô Thị Thu Nhi', '1993-02-18', 0, '0908761234', 'nttn@example.com', 0),
('user010','123', N'Bùi Văn Quyết', '1994-12-03', 1, '0906549876', 'bvq@example.com', 0);

INSERT INTO NEWS (Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) VALUES
(N'Làn sóng sa thải Gen Z Mỹ', N'Báo cáo tháng 8 của hãng nghiên cứu thị trường lao động Intelligent.com cho thấy các công ty đang cắt giảm nhân sự Gen Z "nhiều đến mức đáng lo ngại" sau vài tháng tuyển dụng.', N'culture1.jpg', '2024-09-01', 1, 120, 1, 1),
(N'Vì sao một số người mãi độc thân?', N'Thuật ngữ "chronically single" mô tả tình trạng một người độc thân trong nhiều năm đang nhận được sự quan tâm với hơn 10 triệu lượt xem trên mạng xã hội.', N'culture2.jpg', '2024-09-02', 2, 300, 1, 1),
(N'5 thói quen tiết kiệm "bất di bất dịch" của triệu phú tự thân', N'Dù sở hữu tài sản hơn một triệu USD nhưng Jonathan Sanchez vẫn duy trì những thói quen tiết kiệm mà ông khẳng định không bao giờ từ bỏ.', N'culture3.jpg', '2024-09-03', 3, 500, 1, 1),
(N'TP HCM tiêu huỷ 1,3 tấn ma túy bằng lò thiêu', N'Cục Thi hành án dân sự TP HCM phối hợp công an, VKS cùng các ban ngành tiêu huỷ 1,3 tấn ma túy - vật chứng của 126 vụ án hình sự, bằng lò thiêu.', N'law1.jpg', '2024-09-04', 4, 80, 2, 0),
(N'Bà Trương Mỹ Lan phủ nhận sử dụng 445.748 tỷ đồng của SCB', N'Chủ tịch Vạn Thịnh Phát nhiều lần nhắc lại quan điểm "tôn trọng cáo trạng truy tố", song cho rằng không sử dụng số tiền 445.748 tỷ đồng của SCB cho cá nhân hay tập đoàn.', N'law2.jpg', '2024-09-05', 5, 230, 2, 1),
(N'Lời khai của tài xế bà Trương Mỹ Lan về việc chở 108.000 tỷ đồng tiền mặt', N'Bùi Văn Dũng, 60 tuổi, khai mỗi buổi chiều bà Trương Mỹ Lan kêu "có tiền, qua ngân hàng nhận" là lái ôtô qua tầng hầm trụ sở SCB, chở các thùng tiền đã được đóng sẵn.', N'law3.jpg', '2024-09-06', 6, 150, 2, 0),
(N'Vinicius bị miệt thị là "cặn bã"', N'Theo cựu chủ tịch của Valencia Paco Roig, màu da không phải là lý do khiến Vinicius bị tẩy chay ở Tây Ban Nha.', N'sport1.jpg', '2024-09-07', 7, 400, 3, 1),
(N'Lê Tuấn Minh - người hùng thầm lặng của Việt Nam ở Olympiad cờ vua', N'Đại kiện tướng Lê Tuấn Minh lần đầu dự Olympiad cờ vua ở tuổi 28, nhưng đoạt HC đồng và nhiều lần giành điểm quyết định cho Việt Nam.', N'sport2.jpg', '2024-09-08', 8, 90, 3, 0),
(N'Pháp, Iran bị tố "không muốn thắng" để gặp Thái Lan ở Futsal World Cup', N'Pháp và Iran bị chỉ trích về thái độ thi đấu, khi gặp nhau ở lượt cuối bảng F FIFA futsal World Cup 2024 ở Uzbekistan tối 22/9.', N'sport3.jpg', '2024-09-09', 9, 270, 3, 1),
(N'Tân binh Mazraoui: "Man Utd danh tiếng hơn Bayern"', N'Hậu vệ Noussair Mazraoui giải thích việc chia tay Bayern Munich sau hai năm để chuyển tới Man Utd vì muốn tìm kiếm thử thách mới.', N'sport4.jpg', '2024-09-10', 10, 180, 3, 0),
(N'Quyết Chiến, Phương Vinh ra quân World Championship', N'Các cơ thủ hàng đầu Việt Nam sẽ ra quân ở giải billiards carom 3 băng vô địch thế giới - World Championship 2024 tại Phan Thiết, hôm nay.', N'sport5.jpg', '2024-09-11', 3, 620, 3, 1),
(N'Thưởng thức món Thái Michelin trên xe buýt ở Bangkok', N'Tour xe buýt ở Bangkok thu hút khách quốc tế nhờ kết hợp vừa tham quan vừa thưởng thức những món Thái nổi tiếng, được Michelin tuyển chọn.', N'travel1.jpg', '2024-09-12', 4, 50, 4, 0),
(N'Đi máy bay riêng đắt thế nào', N'Chuyến bay riêng tư được nhiều du khách cân nhắc vì các lợi ích như tránh đông đúc, thuận tiện nhưng chi phí lên tới 15.000 USD mỗi giờ.', N'travel2.jpg', '2024-09-13', 5, 240, 4, 1),
(N'Quê Hồ Xuân Hương được công nhận là điểm du lịch', N'Làng Quỳnh Đôi - quê hương "bà chúa thơ Nôm" Hồ Xuân Hương, được công nhận là điểm du lịch nhằm phát huy giá trị điểm đến, phục vụ khách tốt hơn.', N'travel3.jpg', '2024-09-14', 6, 110, 4, 0);

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