package library.controller;


import library.entity.Author;
import library.entity.Book;
import library.entity.Genre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/book")
public class BooksServlet extends HttpServlet {
    private static Author author=new Author(1,"Pol","Acmen");
    private static Genre genre=new Genre(1,"1452");
    private static Book book=new Book(1,"2","3",author,genre);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("id",book.getId());
        req.setAttribute("Book",book.getTitle());
        req.setAttribute("Author",author.getName());
        req.setAttribute("Genre",genre.getName());
        req.setAttribute("ISBN",book.getISBN());

        getServletContext().getRequestDispatcher("/add.jsp").forward(req,resp);

    }

}