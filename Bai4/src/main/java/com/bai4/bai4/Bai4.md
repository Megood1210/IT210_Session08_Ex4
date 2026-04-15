Phần 1 – Phân tích & đề xuất 
*Input / Output
-Input (DTO):
+username: String
+password: String
+confirmPassword: String
-Output:
+Hợp lệ thì cho đăng ký
+Không hợp lệ thì báo lỗi “Mật khẩu không khớp”
*Giải pháp 1: IF-ELSE trong Controller
if (!password.equals(confirmPassword)) {
result.rejectValue("confirmPassword", "error", "Mật khẩu không khớp");
}
*Giải pháp 2: Custom Validation (Class-Level)
-Ý tưởng:
+Tạo annotation gắn lên class DTO
+Validator sẽ lấy cả 2 field để so sánh

Phần 2 - So sánh
| Tiêu chí               | IF-ELSE Controller |Custom Annotation |
| ---------------------- | -------------------|----------------- |
| Boilerplate            | Nhiều              | Ít               |
| Tái sử dụng            | Không              | Cao              |
| Clean Code             | Vi phạm            | Chuẩn            |
| Separation of Concerns | Sai                | Đúng             |
| An toàn null           | Dễ lỗi             | Kiểm soát tốt    |
-Kết luận:
+Chọn Custom Class-Level Annotation