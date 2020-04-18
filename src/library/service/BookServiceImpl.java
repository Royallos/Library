package library.service;

import library.entity.Book;
import library.repository.BookRepository;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getBooks() throws SQLException {
        List<Book> books = bookRepository.getBooks();
        return books;
    }

    @Override
    public Book addBook(Book book) throws SQLException {
        bookRepository.addBook(book);
        return null;
    }

    @Override
    public void deleteBook() throws SQLException {
        bookRepository.deleteBook();

    }
}
