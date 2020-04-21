package library.repository;

import library.entity.Book;

import java.sql.SQLException;

public interface GenreRepository {
    public void addGenre(Book book) throws SQLException;
}
