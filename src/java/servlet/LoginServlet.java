/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import classes.User;
import classes.UserData;

/**
 *
 * @author masha
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = UserData.getUser(login);

        if (user != null && user.getPassword().equals(password)) {
            // если пароль верный, то создаем сессию
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            resp.sendRedirect(req.getContextPath() + "/news"); // Успех, идем на новости
        } else {
            // если ошибка, то возвращает обратно к форме
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=1");
        }
    }
}