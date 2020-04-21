package library.service;

import library.entity.Book;
import library.repository.AuthorRepository;
import library.repository.BookRepository;
import library.repository.ConnectTablesRepository;
import library.repository.GenreRepository;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final ConnectTablesRepository connectTablesRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository, ConnectTablesRepository connectTablesRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.connectTablesRepository = connectTablesRepository;
    }
    @Override
    public List<Book> getBooks() throws SQLException {
        List<Book> books = bookRepository.getBooks();
        return books;
    }

    @Override
    public Book addBook(Book book) throws SQLException {
        bookRepository.addBook(book);
        authorRepository.addAuthor(book);
        genreRepository.addGenre(book);
        connectTablesRepository.addAuthorAndGenre(book);
        return null;
    }

    @Override
    public void deleteBook() throws SQLException {
        bookRepository.deleteBook();

    }
}
