USE [QuanLi]
GO
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT001        ', N'Le Van Phuoc                                      ', N'Nam', N'24IT ', N'VKU                                               ', N'KV2  ', N'TN', N'tester01            ', N'123456                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT002        ', N'Nguyen Van Anh                                    ', N'Nu ', N'24IT ', N'VKU                                               ', N'KV1  ', N'XH', N'tester02            ', N'123123                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT003        ', N'Tran Van Binh                                     ', N'Nam', N'24IT ', N'VKU                                               ', N'KV2  ', N'TN', N'tester03            ', N'456789                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT004        ', N'Le Thi Hoa                                        ', N'Nu ', N'24IT ', N'VKU                                               ', N'KV2  ', N'TN', N'tester04            ', N'654321                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT005        ', N'Nguyen Minh Tam                                   ', N'Nam', N'24IT ', N'VKU                                               ', N'KV1  ', N'XH', N'tester05            ', N'987654                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT006        ', N'Pham Thi Lan                                      ', N'Nu ', N'24IT ', N'VKU                                               ', N'KV1  ', N'XH', N'tester06            ', N'543210                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT007        ', N'Do Van Minh                                       ', N'Nam', N'24IT ', N'VKU                                               ', N'KV3  ', N'TN', N'tester07            ', N'321098                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT008        ', N'Hoang Thi Hanh                                    ', N'Nu ', N'24IT ', N'VKU                                               ', N'KV3  ', N'XH', N'tester08            ', N'789012                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT009        ', N'Do Quang Trung                                    ', N'Nam', N'24IT ', N'VKU                                               ', N'KV1  ', N'TN', N'tester09            ', N'209347                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT010        ', N'Nguyen Cong Duc                                   ', N'Nam', N'24IT ', N'VKU                                               ', N'KV3  ', N'TN', N'tester10            ', N'234572                        ')
INSERT [dbo].[HocSinh] ([HocSinhID], [TenHocSinh], [GioiTinh], [Lop], [Truong], [UuTienID], [ToHopID], [Account], [Password]) VALUES (N'24IT011        ', N'ahgsd                                             ', N'Nam', N'24IT ', N'VKU                                               ', N'KV2  ', N'XH', N'                    ', N'                              ')
GO
INSERT [dbo].[ToHop] ([ToHopID], [TenToHop]) VALUES (N'TN', N'Tu Nhien  ')
INSERT [dbo].[ToHop] ([ToHopID], [TenToHop]) VALUES (N'XH', N'Xa Hoi    ')
GO
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'anh       ', N'Anh văn                                           ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'dia       ', N'Địa lý                                            ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'gdcd      ', N'Giáo dục Công dân                                 ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'hoa       ', N'Hóa Học                                           ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'ly        ', N'Vật lý                                            ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'sinh      ', N'Sinh Học                                          ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'su        ', N'Lịch Sử                                           ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'toan      ', N'Toán                                              ')
INSERT [dbo].[MonHoc] ([MonID], [TenMon]) VALUES (N'van       ', N'Ngữ Văn                                           ')
GO
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'anh       ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'hoa       ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'ly        ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'sinh      ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'toan      ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'TN', N'van       ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'anh       ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'dia       ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'gdcd      ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'su        ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'toan      ')
INSERT [dbo].[ToHopChiTiet] ([ToHopID], [MonHocID]) VALUES (N'XH', N'van       ')
GO
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'toan      ', N'TN', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'van       ', N'TN', 6.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'anh       ', N'TN', 6.4)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'ly        ', N'TN', 8.2)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'hoa       ', N'TN', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT004        ', N'sinh      ', N'TN', 7.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'toan      ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'van       ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'anh       ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'su        ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'dia       ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT011        ', N'gdcd      ', N'XH', 0)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'toan      ', N'TN', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'van       ', N'TN', 6.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'anh       ', N'TN', 6.4)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'ly        ', N'TN', 8.2)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'hoa       ', N'TN', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT001        ', N'sinh      ', N'TN', 7.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'toan      ', N'TN', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'van       ', N'TN', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'anh       ', N'TN', 6.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'ly        ', N'TN', 7.9)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'hoa       ', N'TN', 8.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT003        ', N'sinh      ', N'TN', 8.2)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'toan      ', N'TN', 8.7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'van       ', N'TN', 7.4)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'anh       ', N'TN', 7.9)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'ly        ', N'TN', 8.1)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'hoa       ', N'TN', 9)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT007        ', N'sinh      ', N'TN', 8.3)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'toan      ', N'XH', 6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'van       ', N'XH', 6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'anh       ', N'XH', 6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'dia       ', N'XH', 6.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'gdcd      ', N'XH', 6.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT002        ', N'su        ', N'XH', 7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'toan      ', N'XH', 6.3)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'van       ', N'XH', 7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'anh       ', N'XH', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'dia       ', N'XH', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'gdcd      ', N'XH', 7.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT005        ', N'su        ', N'XH', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'toan      ', N'XH', 6.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'van       ', N'XH', 6.7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'anh       ', N'XH', 7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'dia       ', N'XH', 8.1)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'gdcd      ', N'XH', 7.9)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT006        ', N'su        ', N'XH', 8.3)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'toan      ', N'XH', 7)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'van       ', N'XH', 6.9)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'anh       ', N'XH', 7.5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'dia       ', N'XH', 7.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'gdcd      ', N'XH', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT008        ', N'su        ', N'XH', 8.2)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'toan      ', N'TN', 8.2)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'van       ', N'TN', 6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'anh       ', N'TN', 5)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'ly        ', N'TN', 8.8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'hoa       ', N'TN', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT009        ', N'sinh      ', N'TN', 4)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'toan      ', N'TN', 8)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'van       ', N'TN', 5.6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'anh       ', N'TN', 7.3)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'ly        ', N'TN', 8.6)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'hoa       ', N'TN', 8.4)
INSERT [dbo].[Diem] ([HocSinhID], [MonID], [ToHopID], [Diem]) VALUES (N'24IT010        ', N'sinh      ', N'TN', 8.2)
GO
