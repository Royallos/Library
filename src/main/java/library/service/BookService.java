package library.service;

import library.entity.Book;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface BookService {

    List<Book> getBooks() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException;
    Book addBook(Book book) throws SQLException;
    void deleteBook() throws SQLException;
}
