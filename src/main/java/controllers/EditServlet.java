package controllers;

import models.pojo.Student;
import org.apache.log4j.Logger;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmitrii on 23.02.17.
 */
public class EditServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(EditServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("TRACE");
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);
        Student student = StudentService.getStudentById(id);
        req.setAttribute("stud", student);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("TRACE");
        Student student = new Student();
        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setBirthday(req.getParameter("birthday"));
        student.setSex(req.getParameter("sex"));
        student = StudentService.updateStudent(student);
        if(student!=null){
            resp.sendRedirect("/students/list");
        }
        else{
            resp.sendRedirect("/students/error.jsp");
        }
    }
}