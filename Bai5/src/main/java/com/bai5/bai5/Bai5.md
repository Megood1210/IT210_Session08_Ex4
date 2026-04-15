Phần 1
-Danh sách các công cụ/Annotation sẽ sử dụng cho từng quy tắc nghiệp vụ ở trên:
| Quy tắc             | Giải pháp          |
| ------------------- | ------------------ |
| tourCode format     | `@Pattern` (chuẩn) |
| giá > 0             | `@Min`             |
| child ≤ adult       | Custom Class-level |
| startDate ≥ today   | Custom Field-level |
| endDate > startDate | Custom Class-level |
-Flow xử lý:
User nhập form → Submit
↓
Controller (@Valid)
↓
Bean Validation chạy:
- @Pattern
- @Min
- Custom Validator
  ↓
  Nếu lỗi → BindingResult có lỗi
  ↓
  Return lại Thymeleaf form
  ↓
  Hiển thị lỗi đỏ + giữ dữ liệu cũ

Phần 3
-3 bộ dữ liệu (Test Cases) "độc hại" mà người dùng có thể cố tình gửi lên:
+Case 1: TourCode sai format
+Case 2: childPrice > adultPrice
+Case 3: endDate < startDate
-Cách hệ thống của bạn đã chống chịu và chặn các bộ dữ liệu này mà không bị 500 Crash Server:
+Case 1 bị chặn bởi @Pattern
+Case 2 bị chặn bởi @ValidPrice (class-level)
+Case 3 bị chặn bởi @ValidDateRange