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
import java.util.List;

@WebServlet("/getBooks")
public class GetBooks extends HttpServlet {
     final static BookService bookService=new BookServiceImpl(new BookRepositoryImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            List<Book> books=bookService.getBooks();
            req.setAttribute("book",books);
            req.getRequestDispatcher("getBook.jsp").forward(req,resp);
        }catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | SQLException e){
            e.printStackTrace();
        }
    }

}
