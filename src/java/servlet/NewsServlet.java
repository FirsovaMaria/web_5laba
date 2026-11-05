package servlet;

import classes.VisitCounter;
import classes.NewsData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/news")                      
public class NewsServlet extends HttpServlet {
    private final NewsData data = new NewsData();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //получаем данные
        req.setAttribute("news", data.findAll());
        req.setAttribute("serverTime", LocalDateTime.now());
        
        req.setAttribute("visits", VisitCounter.increment());
        
        //передаем в JSP
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}