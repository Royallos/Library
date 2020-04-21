package library.repository;

import library.entity.Book;

import java.sql.SQLException;

public interface AuthorRepository {
    public void addAuthor(Book book) throws SQLException;
}
