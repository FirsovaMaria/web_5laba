<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.time.*, java.time.format.*, classes.News, classes.User" %>
<%
    List<News> news = (List<News>) request.getAttribute("news");
    LocalDateTime serverTime = (LocalDateTime) request.getAttribute("serverTime");
    Long visits = (Long) request.getAttribute("visits");
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    
    User currentUser = (User) session.getAttribute("currentUser");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Новости</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

     <div class="header-panel">
        <% if (currentUser != null) { %>
            <!-- Если залогинен -->
            <a href="<%= request.getContextPath() %>/profile" class="profile-link">
                <% if (currentUser.getAvatar() != null) { %>
                    <img src="<%= request.getContextPath() %>/uploads/<%= currentUser.getAvatar() %>" class="avatar-small" alt="Аватар">
                <% } %>
                <span><%= currentUser.getLogin() %></span>
            </a>
            <a href="<%= request.getContextPath() %>/logout" class="btn btn-danger">Выйти</a>
        <% } else { %>
            <!-- Если НЕ залогинен -->
            <a href="<%= request.getContextPath() %>/login.jsp" class="btn">Войти</a>
        <% } %>
    </div>

    <!-- основной контент -->
    <div class="main-content">
        <h1>Новости</h1>
        <div class="top-info">
            <span><b>Время сервера:</b> <%= (serverTime != null ? serverTime.format(fmt) : "нет данных") %></span>
            <span><b>Посещений:</b> <%= (visits != null ? visits : 0) %></span>
        </div>
        <hr>

        <% if (news != null) {
            for (News n : news) { %>
                <article class="news-item">
                    <h2><%= n.getTitle() %></h2>
                    <p style="white-space: pre-line;"><%= n.getText() %></p>
                    <small>Автор: <%= n.getAuthor() %> | Дата: <%= n.getPublicationDate().format(fmt) %></small>
                </article>
        <%  }
           } else { %>
            <p>Новостей пока нет.</p>
        <% } %>
    </div>

</body>
</html>