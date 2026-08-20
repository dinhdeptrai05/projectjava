<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <style>
        :root {
            --primary: #4f46e5;
            --primary-hover: #4338ca;
            --danger: #ef4444;
            --success: #10b981;
            --text-main: #1e293b;
            --text-muted: #64748b;
            --bg-body: #f1f5f9;
            --border: #e2e8f0;
        }
        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: var(--bg-body);
            color: var(--text-main);
            padding: 30px 20px;
            margin: 0;
            display: flex;
            justify-content: center;
        }
        .container {
            background: #ffffff;
            width: 100%;
            max-width: 1000px;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.05);
        }
        h2 { margin-top: 0; color: #0f172a; font-size: 1.5rem; margin-bottom: 20px; }

        .toolbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            flex-wrap: wrap;
            gap: 15px;
        }
        .search-form { display: flex; gap: 8px; }
        .search-form input {
            padding: 10px 14px;
            border: 1px solid var(--border);
            border-radius: 8px;
            outline: none;
            width: 250px;
            transition: border-color 0.2s;
        }
        .search-form input:focus { border-color: var(--primary); }

        .btn {
            padding: 10px 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            font-weight: 500;
            font-size: 0.9rem;
            transition: all 0.2s;
        }
        .btn-primary { background: var(--primary); color: white; }
        .btn-primary:hover { background: var(--primary-hover); }
        .btn-success { background: var(--success); color: white; display: flex; align-items: center;}
        .btn-success:hover { background: #059669; }

        .table-responsive { overflow-x: auto; }
        table { width: 100%; border-collapse: collapse; min-width: 700px; }
        th, td { padding: 14px 16px; text-align: left; border-bottom: 1px solid var(--border); }
        th { background-color: #f8fafc; font-weight: 600; color: var(--text-muted); font-size: 0.9rem; text-transform: uppercase;}
        tr:hover { background-color: #f8fafc; }

        .name-link { color: var(--primary); text-decoration: none; font-weight: 500; }
        .name-link:hover { text-decoration: underline; }

        .action-links a { text-decoration: none; font-size: 0.9rem; font-weight: 500; padding: 4px 8px; border-radius: 4px;}
        .action-links a.edit { color: var(--primary); background: #e0e7ff; margin-right: 5px;}
        .action-links a.delete { color: var(--danger); background: #fee2e2; }
        .action-links a:hover { opacity: 0.8; }
    </style>
</head>
<body>
<div class="container">
    <h2>Danh sách sinh viên</h2>

    <div class="toolbar">
        <form method="get" action="${pageContext.request.contextPath}/sinh-vien" class="search-form">
            <input type="text" name="keyword" placeholder="Tìm theo tên hoặc lớp..." value="${param.keyword}">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </form>
        <a href="${pageContext.request.contextPath}/sinh-vien?action=new" class="btn btn-success">+ Thêm sinh viên</a>
    </div>

    <div class="table-responsive">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Mã SV</th>
                <th>Họ tên</th>
                <th>Email</th>
                <th>Lớp</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sv" items="${dsSinhVien}">
                <tr>
                    <td>${sv.id}</td>
                    <td>${sv.maSinhVien}</td>
                    <td><a href="${pageContext.request.contextPath}/sinh-vien?action=detail&id=${sv.id}" class="name-link">${sv.hoTen}</a></td>
                    <td>${sv.email}</td>
                    <td>${sv.lop}</td>
                    <td class="action-links">
                        <a href="${pageContext.request.contextPath}/sinh-vien?action=edit&id=${sv.id}" class="edit">Sửa</a>
                        <a href="${pageContext.request.contextPath}/sinh-vien?action=delete&id=${sv.id}" class="delete" onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên: ${sv.hoTen}?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty dsSinhVien}">
                <tr>
                    <td colspan="6" style="text-align: center; color: var(--text-muted); padding: 30px;">Không tìm thấy sinh viên nào.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>