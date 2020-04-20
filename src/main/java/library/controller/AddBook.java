package library.controller;

import library.entity.Book;
import library.repository.BookRepositoryImpl;
import library.service.BookService;
import library.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/addBook")
public class AddBook extends HttpServlet {
    private  final static BookService bookService=new BookServiceImpl(new BookRepositoryImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        try {
            bookService.addBook(book);
            req.setAttribute("book", book);
            req.setAttribute("books", bookService.getBooks());
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("addBook.jsp").forward(req,resp);
    }
}
