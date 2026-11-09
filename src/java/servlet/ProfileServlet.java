/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 *
 * @author masha
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Проверяем, залогинен ли пользователь
        HttpSession session = req.getSession(false); // просит у сервера текущую сессию пользователя (чтобы проверить, залогинен ли он). false означает: «если сессии нет, верни null, а не создавай новую».
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");//Если человек не вводил логин и пароль — мы его возвращаем обратно на страницу входа
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);//getRequestDispatcher - ищет файл внутри веб-приложения, forward - передает ему управление и данные
    }
}