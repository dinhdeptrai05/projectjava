<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Form sinh viên</title>
    <style>
        :root {
            --primary: #4f46e5;
            --primary-focus: rgba(79, 70, 229, 0.15);
            --border: #d1d5db;
            --text-main: #1f2937;
        }
        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: #f3f4f6;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
        }
        .form-card {
            background: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 450px;
        }
        h2 {
            margin-top: 0;
            margin-bottom: 25px;
            color: #111827;
            text-align: center;
            font-size: 1.5rem;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #374151;
            font-size: 0.95rem;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 12px;
            border: 1px solid var(--border);
            border-radius: 8px;
            outline: none;
            font-size: 1rem;
            box-sizing: border-box;
            transition: all 0.2s;
        }
        input:focus {
            border-color: var(--primary);
            box-shadow: 0 0 0 3px var(--primary-focus);
        }
        .btn-submit {
            width: 100%;
            padding: 12px;
            background-color: var(--primary);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.2s;
            margin-top: 10px;
        }
        .btn-submit:hover { background-color: #4338ca; }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #6b7280;
            text-decoration: none;
            font-size: 0.9rem;
        }
        .back-link:hover {
            color: var(--primary);
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="form-card">
    <!-- Đổi tiêu đề linh hoạt theo việc thêm mới hay sửa -->
    <h2>${empty sv.id or sv.id == 0 ? 'Thêm Sinh Viên Mới' : 'Cập Nhật Sinh Viên'}</h2>

    <form method="post" action="${pageContext.request.contextPath}/sinh-vien">
        <input type="hidden" name="id" value="${sv.id}">

        <div class="form-group">
            <label>Mã SV:</label>
            <input type="text" name="maSinhVien" value="${sv.maSinhVien}" placeholder="VD: SV001" required>
        </div>

        <div class="form-group">
            <label>Họ tên:</label>
            <input type="text" name="hoTen" value="${sv.hoTen}" placeholder="Nhập họ và tên" required>
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="email" value="${sv.email}" placeholder="abc@gmail.com">
        </div>

        <div class="form-group">
            <label>Lớp:</label>
            <input type="text" name="lop" value="${sv.lop}" placeholder="VD: CNTT1">
        </div>

        <button type="submit" class="btn-submit">Lưu thông tin</button>
    </form>

    <a href="${pageContext.request.contextPath}/sinh-vien" class="back-link">← Quay lại danh sách</a>
</div>
</body>
</html>