package library;

import library.entity.Author;
import library.entity.Book;
import library.entity.Genre;
import library.repository.BookRepository;
import library.repository.BookRepositoryImpl;
import library.service.BookService;
import library.service.BookServiceImpl;

import java.sql.SQLException;

public class LibraryMain {
    private static java.util.Date Date;

    public static void main(String[] args) throws SQLException {

        Author tolkien = new Author(1, "Henry", "John");
        Genre fantasy = new Genre(1, "Fantasy");
        Book hobbit = new Book(1, "Tolkien", "Fantasy", tolkien, fantasy);

        BookRepository br = new BookRepositoryImpl();
        BookService bs = new BookServiceImpl(br);

        bs.addBook(hobbit);

//       bs.deleteBook();



    }

    }

