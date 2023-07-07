<b style="font-size: 36px;">Hotel manager</b>

<i>Các file chứa dòng "This file is not allowed to be edited" thì không được phép chỉnh sửa thay đổi file đó</i>

<b style="font-size: 24px;">Thông tin về các đối tượng</b>

<span>Phòng: mã phòng, loại phòng(có thể là phòng đơn, phòng đôi, phòng VIP), giá phòng, số phòng và ghi chú</span>

<span>Khách hàng: mã KH, tên KH, địa chỉ, số điện thoại, email và ghi chú</span>

<span>Dịch vụ: mã dịch vụ, tên dịch vụ, giá dịch vụ</span>

<span>Hóa đơn: mã hóa đơn, thông tin KH, thông tin về phòng đã đặt, thông tin về các dịch vụ đã sử dụng, tổng tiền thanh toán</span>

<i>Dữ liệu đã được tạo sẵn trong trong object AllDataForExam, các lớp đối tượng về "Phòng", "Khách Hàng", và "Dịch vụ" đã được tạo(không được phép chỉnh sửa)</i>

<b style="font-size: 24px;">Yêu cầu bài tập</b>

<i>Yêu cầu sử dụng callback và try catch để xử lý ngoại lệ</i>

<i>Yêu cầu dùng interface và generic để xử lý chung cho việc CRUD</i>

<span>Viết chương trình có Menu như sau</span>

<span>0. Trở lại menu </span>

<span>1. In ra màn hình danh sách. Yêu cầu nhập loại danh sách</span>

<span style="margin-left: 20px">    1: danh sách "Phòng" </span>

<span style="margin-left: 20px">    2: danh sách "Khách hàng" </span>

<span style="margin-left: 20px">    3: danh sách "Dịch vụ" </span>

<span>In ra màn hình danh sách được chọn và hiện lên danh sách tùy chọn cách sắp xếp danh sách được chọn(cách sắp xếp tùy các em chọn - yêu cầu dùng lamda)</span>

<span>Hiển thị danh sách đã được sắp xếp</span>

<span>2. Tìm kiếm và chỉnh sửa thông tin. Yêu cầu nhập loại danh sách</span>

<span style="margin-left: 20px">    1: danh sách "Phòng" </span>

<span style="margin-left: 20px">    2: danh sách "Khách hàng" </span>

<span style="margin-left: 20px">    3: danh sách "Dịch vụ" </span>

<span>In ra màn hình danh sách được chọn và hiển lên danh sách tùy chọn thuộc tính tìm kiếm</span>

<span>Nhập thông tin tìm kiếm, và hiện thị ra đối tượng tìm kiếm, hiển thị danh sách tùy chọn thuộc tính cần thay đổi, nếu không cần thay đổi thuộc tính nào bấm 0 để trở lại menu</span>

<span>3. Đặt phòng.</span>

<span>Nhập tên KH => hiển thị danh sách KH có tên như đã nhập => chọn KH phù hợp(nhập id KH), nếu chưa có KH đó trong danh sách thì phải thêm mới KH => hiển thị danh sách phòng => chọn phòng theo yêu cầu(nhập id "Phòng") => Hiển thị danh sách dịch vụ => Chọn các dịch vụ như KH yêu cầu(nhập chuỗi các id của dịch vụ) => chọn lưu lại hoặc 0 để trở lại menu mà không lưu lại => nếu chọn lưu lại thì hiển thị danh sách Booking(đầy đủ thông tin)</span>

