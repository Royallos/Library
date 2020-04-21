package library.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBook")
public class AddBooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id= Integer.parseInt(req.getParameter("id"));
        String book=req.getParameter("Title");
        String author=req.getParameter("Author");
        String genre=req.getParameter("Genre");
        String ISBN=req.getParameter("ISBN");

        req.setAttribute("id",id);
        req.setAttribute("Book",book);
        req.setAttribute("Author",author);
        req.setAttribute("Genre",genre);
        req.setAttribute("ISBN",ISBN);

        getServletContext().getRequestDispatcher("/add.jsp").include(req,resp);
    }
}
