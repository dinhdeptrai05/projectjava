<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lab 7 - CRUD MVC</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
        }
        body {
            background: linear-gradient(135deg, #e0e7ff 0%, #f3f4f6 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .card {
            background: #ffffff;
            width: 100%;
            max-width: 440px;
            padding: 32px 28px;
            border-radius: 16px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.08), 0 8px 10px -6px rgba(0, 0, 0, 0.01);
        }
        .title {
            color: #1e293b;
            font-size: 1.25rem;
            font-weight: 700;
            margin-bottom: 24px;
            text-align: center;
            line-height: 1.4;
        }
        .menu-list {
            list-style: none;
            display: flex;
            flex-direction: column;
            gap: 12px;
        }
        .menu-item a {
            display: flex;
            align-items: center;
            gap: 10px;
            padding: 14px 20px;
            background-color: #f8fafc;
            color: #334155;
            text-decoration: none;
            font-weight: 600;
            font-size: 0.95rem;
            border-radius: 10px;
            border: 1px solid #e2e8f0;
            transition: all 0.25s ease;
        }
        .menu-item a:hover {
            background-color: #4f46e5;
            color: #ffffff;
            border-color: #4f46e5;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(79, 70, 229, 0.25);
        }
        .menu-item.login a {
            background-color: #e0e7ff;
            color: #3730a3;
            border-color: #c7d2fe;
            margin-top: 6px;
        }
        .menu-item.login a:hover {
            background-color: #4338ca;
            color: #ffffff;
            border-color: #4338ca;
        }
    </style>
</head>
<body>
<div class="card">
    <h2 class="title">Lab 7 - CRUD bằng Servlet + JSP (MVC)</h2>
    <ul class="menu-list">
        <li class="menu-item">
            <a href="${pageContext.request.contextPath}/sinh-vien">👨‍🎓 Quản lý sinh viên</a>
        </li>
        <li class="menu-item">
            <a href="${pageContext.request.contextPath}/sach">📚 Quản lý sách</a>
        </li>
        <li class="menu-item">
            <a href="${pageContext.request.contextPath}/san-pham">📦 Quản lý sản phẩm</a>
        </li>
        <li class="menu-item login">
            <a href="${pageContext.request.contextPath}/login.jsp">🔑 Đăng nhập</a>
        </li>
    </ul>
</div>
</body>
</html>