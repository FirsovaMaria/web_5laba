package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Получает текущую сессию (если она есть)
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Полностью уничтожает сессию
        }
        // Перенаправляет на главную страницу
        resp.sendRedirect(req.getContextPath() + "/news");
    }
}