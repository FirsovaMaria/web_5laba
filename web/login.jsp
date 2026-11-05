<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход на портал</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body class="login-page">

    <div class="login-container">
        <h2>Вход на портал</h2>
        
        <!-- вывод ошибки, если пароль неверный -->
        <% if (request.getParameter("error") != null) { %>
            <div class="error-message">Неверный логин или пароль!</div>
        <% } %>

        <form action="login" method="POST">
            <div class="form-group">
                <label for="login">Логин:</label>
                <input type="text" id="login" name="login" class="form-control" required placeholder="Введите логин">
            </div>
            
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" class="form-control" required placeholder="Введите пароль">
            </div>
            
            <button type="submit" class="btn btn-block">Войти</button>
        </form>
        
        <div style="text-align: center; margin-top: 20px;">
            <a href="news" style="color: #BC8F8F; text-decoration: none; font-size: 20px; text-decoration: underline;">Вернуться к новостям</a>
        </div>
    </div>

</body>
</html>