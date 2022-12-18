create database DangKyDeTai
go

use DangKyDeTai
go

create table TaiKhoan(
	Username nvarchar(20) primary key,
	MatKhau nvarchar(20),
	Quyen nvarchar(20)
)
go

create table BoMon(
	MaBoMon nvarchar(20) primary key,
	TenBoMon nvarchar(20),
)
go

create table HoiDong(
	MaHoiDong nvarchar(20) primary key,
	TenHoiDong nvarchar(30)
)
go

create table GiangVien(
	MaGV nvarchar(20) primary key,
	TenGV nvarchar(50),
	TaiKhoan nvarchar(20),
	BoMon nvarchar(20) references BoMon(MaBoMon),
	HoiDong nvarchar(20) references HoiDong(MaHoiDong) on delete set null,
	TruongBoMon int check(TruongBoMon=0 or TruongBoMon=1)
	foreign key (TaiKhoan) references TaiKhoan(Username) on delete set null
)
go

create table Admin(
	Id nvarchar(20) primary key,
	Ten nvarchar(50),
	TaiKhoan nvarchar(20),
	foreign key(TaiKhoan) references TaiKhoan(Username)
)
go

create table NhomSV(
	MaNhom int identity primary key,
	TenNhom nvarchar(30),
	BoMon nvarchar(20),
	LienHe nvarchar(50),
	foreign key(BoMon) references BoMon(MaBoMon)
)
go



create table SinhVien(
	MSSV nvarchar(20) primary key,
	Hoten nvarchar(50),
	BoMon nvarchar(20) references BoMon(MaBoMon),
	TaiKhoan nvarchar(20),
	Nhom int references NhomSV(MaNhom),
	NhomTruong int check(NhomTruong=0 or NhomTruong=1),
	foreign key (TaiKhoan) references TaiKhoan(Username) on delete set null
)
go


create table DeTai(
	MaDeTai int identity primary key,
	TenDeTai nvarchar(100),
	GiangVien nvarchar(20),
	foreign key (GiangVien) references GiangVien(MaGV)
)
go


create table DKDeTai(
	MaNhom int ,
	DeTai int,
	TrangThai int check(TrangThai=0 or TrangThai=1),
	foreign key(MaNhom) references NhomSV(MaNhom),
	foreign key(DeTai) references DeTai(MaDeTai) ,
	primary key(MaNhom, DeTai)
)
go

create table PhanBien(
	DeTai int primary key,
	MaGV nvarchar(20),
	foreign key(MaGV) references GiangVien(MaGV),
	foreign key(DeTai) references DeTai(MaDeTai),
)
go
create table DotDangKi(
	NhomNguoi nvarchar(20) primary key,
	TrangThai int  check(TrangThai=0 or TrangThai=1)
)
go
insert into TaiKhoan values('20110613','123456', N'Sinh Viên')
insert into TaiKhoan values('GV1','123456', N'Giảng Viên')
insert into TaiKhoan values('GV2', '123456', N'Giảng Viên')
insert into TaiKhoan values('Admin1','123456', N'Admin')
insert into TaiKhoan values('20110704', '123456', N'Sinh Viên')
insert into TaiKhoan values('20110743', '123456', N'Sinh Viên')
insert into TaiKhoan values('20110652', '123456', N'Sinh Viên')
insert into TaiKhoan values('20110777', '123456', N'Sinh Viên')
insert into TaiKhoan values('GV3', '123456', N'Giảng Viên')
go 

insert into BoMon values
('BM01', N'Công nghệ phần mềm'),
('BM02', N'Hệ thống thông tin'),
('BM03', N'An minh mạng')
go

insert into GiangVien values
('GV0003', N'Nguyễn Thị N', 'GV3', 'BM02', null, 0),
('GV0001', N'Nguyễn Văn A', 'GV1', 'BM01', null, 1),
('GV0002', N'Trần Văn B', 'GV2', 'BM01', null, 0)
go

insert into NhomSV values
(N'Nhóm demo', 'BM02', '')
go

insert into SinhVien values
('20110777', N'Lý A', 'BM02', '20110777', null, null),
('20110652', N'Trần Văn E', 'BM02', '20110652', null, null),
('20110613', N'Lê Đình Bảo', 'BM01', '20110613', null, null),
('20110704', N'Nguyễn Văn C', 'BM02', '20110704', 1, 1),
('20110767', N'Trần Văn D', 'BM02', '20110743', 1, 0)
go

insert into DotDangKi values
(N'Sinh Viên', 1),
(N'Giảng Viên', 1)
go

insert into DeTai values
(N'Xây dụng hệ thống quản lý bãi xe', 'GV0003'),
(N'Xây dựng hệ thống quản lý thư viện', 'GV0003'),
(N'Lập trình website bán sách', 'GV0001'),
(N'Lập trình phần mềm quản lý cửa hàng', 'GV0002')
go