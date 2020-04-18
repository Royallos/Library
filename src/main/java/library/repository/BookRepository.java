package library.repository;

import library.entity.Book;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> getBooks() throws SQLException;
    Book addBook(Book book) throws SQLException;
    void deleteBook() throws SQLException;
}
