package library.repository;

import library.entity.Book;

import java.sql.SQLException;

public interface ConnectTablesRepository {

    void addAuthorAndGenre(Book book) throws SQLException;
}
