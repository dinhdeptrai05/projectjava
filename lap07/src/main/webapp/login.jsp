<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập hệ thống</title>
    <style>
        :root {
            --primary: #4f46e5;
            --primary-hover: #4338ca;
            --bg-color: #f3f4f6;
            --text-main: #1f2937;
        }
        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: var(--bg-color);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .login-card {
            background: #ffffff;
            padding: 40px 35px;
            border-radius: 16px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 380px;
        }
        .login-card h2 {
            margin: 0 0 25px;
            color: var(--text-main);
            text-align: center;
            font-size: 1.6rem;
        }
        .form-group {
            margin-bottom: 18px;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #4b5563;
            font-size: 0.95rem;
        }
        .form-group input {
            width: 100%;
            padding: 12px 14px;
            border: 1px solid #d1d5db;
            border-radius: 8px;
            outline: none;
            font-size: 1rem;
            box-sizing: border-box;
            transition: border-color 0.2s;
        }
        .form-group input:focus {
            border-color: var(--primary);
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.15);
        }
        .btn-login {
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
            margin-top: 15px;
        }
        .btn-login:hover {
            background-color: var(--primary-hover);
        }
        .error-msg {
            color: #ef4444;
            background-color: #fee2e2;
            padding: 10px;
            border-radius: 6px;
            font-size: 0.9rem;
            margin-bottom: 20px;
            text-align: center;
            border: 1px solid #fca5a5;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 25px;
            color: #6b7280;
            text-decoration: none;
            font-size: 0.9rem;
        }
        .back-link:hover { color: var(--primary); text-decoration: underline; }
    </style>
</head>
<body>
<div class="login-card">
    <h2>Đăng Nhập Quản Trị</h2>

    <%-- Khối hiển thị thông báo lỗi nếu đăng nhập sai --%>
    <% if(request.getAttribute("error") != null) { %>
    <div class="error-msg">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label>Tài khoản</label>
            <input type="text" name="username" placeholder="Nhập admin" required>
        </div>
        <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" name="password" placeholder="Nhập admin123" required>
        </div>
        <button type="submit" class="btn-login">Đăng Nhập</button>
    </form>

    <a href="${pageContext.request.contextPath}/index.jsp" class="back-link">← Quay về trang chủ</a>
</div>
</body>
</html>