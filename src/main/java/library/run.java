package library;

import library.entity.Author;
import library.entity.Book;
import library.entity.Genre;
import library.repository.*;
import library.service.BookService;
import library.service.BookServiceImpl;

import java.sql.SQLException;

public class run {
    public static void main(String[] args) throws SQLException {

        Author tolkien = new Author(1, "John", "Tolkien");
        Genre fantasy = new Genre(1, "fantasy");
        Book hobbit = new Book(1, "123123", "hobbit", tolkien, fantasy);

        BookRepository br = new BookRepositoryImpl();
        AuthorRepository authorRepository = new AuthorRepositoryImpl();
        GenreRepository genreRepository = new GenreRepositoryImpl();
        ConnectTablesRepository connectTablesRepository = new ConnectTablesRepositoryImpl();
        BookService bs = new BookServiceImpl(br, authorRepository, genreRepository, connectTablesRepository);

        bs.addBook(hobbit);
//        bs.deleteBook();



    }
}
