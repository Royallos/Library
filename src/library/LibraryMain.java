package library;

import library.entity.Book;
import library.entity.Product;
import library.repository.BookRepository;
import library.repository.BookRepositoryImpl;
import library.service.BookService;
import library.service.BookServiceImpl;
import library.util.DataSourceUtil;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LibraryMain {
    private static java.util.Date Date;

    public static void main(String[] args) throws SQLException {

        Book hobbit = new Book(1, "Tolkien", "Fantasy", "1231231", "Hobbit");

        BookRepository br = new BookRepositoryImpl();
        BookService bs = new BookServiceImpl(br);

        bs.addBook(hobbit);



    }

    }

