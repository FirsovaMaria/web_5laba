<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="classes.User" %>
<%
    User user = (User) session.getAttribute("currentUser");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body class="login-page">

    <div class="login-container" style="width: 400px;">
        <h2>Личный кабинет</h2>
        
        <div style="text-align: center; margin-bottom: 20px;">
            <% if (user.getAvatar() != null) { %>
                <img src="<%= request.getContextPath() %>/uploads/<%= user.getAvatar() %>" 
                     style="width: 120px; height: 120px; border-radius: 50%; object-fit: cover; border: 3px solid #DB7093; box-shadow: 0 4px 10px rgba(0,0,0,0.1);">
                <br>
                <a href="<%= request.getContextPath() %>/delete-avatar" class="btn btn-danger" style="padding: 5px 15px; font-size: 12px; margin-top: 10px; display: inline-block;">Удалить фото</a>
            <% } else { %>
                <p style="color: #999; font-style: italic;">Аватар не загружен</p>
            <% } %>
        </div>

        <div style="margin-bottom: 20px; font-size: 16px; color: #333; text-align: center;">
            <p style="margin: 5px 0;">Логин: <b><%= user.getLogin() %></b></p>
            <p style="margin: 5px 0;">Роль: <b><%= user.getRole() %></b></p>
        </div>

        <hr style="border: 0; border-top: 1px solid #eee; margin: 20px 0;">

        <form action="upload" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label>Загрузить новый аватар:</label>
                <input type="file" name="avatarFile" accept="image/*" required class="form-control" style="padding: 8px;">
            </div>
            <button type="submit" class="btn btn-block">Загрузить</button>
        </form>
        
        <div style="text-align: center; margin-top: 25px; display: flex; justify-content: space-between;">
            <a href="news" class="btn">На главную</a>
            <a href="logout" class="btn btn-danger">Выйти</a>
        </div>
    </div>

</body>
</html>