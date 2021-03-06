package controllers;

import org.apache.log4j.Logger;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("onget");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("on post");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if(UserService.authorize(login, password)){
                logger.trace("true");
                resp.sendRedirect("/students/list");
            }else{
                logger.trace("false");
                req.getRequestDispatcher("/students").forward(req, resp);
            }
        } catch (Exception e) {
            logger.error(e);
            resp.sendRedirect("/students/error.jsp");
        }
    }
}