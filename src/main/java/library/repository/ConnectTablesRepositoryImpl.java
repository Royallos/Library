package library.repository;

import library.entity.Book;
import library.util.DataSourceUtil;

import java.sql.*;

public class ConnectTablesRepositoryImpl implements ConnectTablesRepository {

    private final String findAuthorName = "Select * from author where name = ('";
    private final String findAuthorSurname = "') and surname = ('";
    protected int authorId;
    private final String findGenreName = "Select * from genre where name = ('";
    protected int genreId;
    private final String findBookTitle = "Select * from books where title = ('";
    private final String findBookISBN = "') and ISBN = ('";
    protected int bookId;
    private final String addAuthor = "INSERT INTO book_author (book_id, author_id) values (?, ?)";
    private final String addGenre = "INSERT INTO book_genre (book_id, genre_id) values (?, ?)";


    @Override
    //    Fill the book_author and book_genre tables
    public void addAuthorAndGenre(Book book) throws SQLException {
        getAuthorId(book);
        getGenreId(book);
        getBookId(book);
        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst = connect.prepareStatement(addAuthor);
        prst.setInt(1, bookId);
        prst.setInt(2, authorId);
        prst.executeUpdate();
        PreparedStatement prst1 = connect.prepareStatement(addGenre);
        prst1.setInt(1, bookId);
        prst1.setInt(2, genreId);
        prst1.executeUpdate();
        DataSourceUtil.closeConnection(connect);

    }
//    Get id of author from author table
    private void getAuthorId(Book book) throws SQLException {

        Connection conn = DataSourceUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(findAuthorName + book.getAuthorName() + findAuthorSurname + book.getAuthorSurname() + "')");

        while (rst.next()) {
            authorId = rst.getInt("id");
        }
        DataSourceUtil.closeConnection(conn);
    }
    //    Get id of genre from genre table
    private void getGenreId(Book book) throws SQLException {

        Connection conn = DataSourceUtil.getConnection();
        Statement stmt1 = conn.createStatement();
        ResultSet rst1 = stmt1.executeQuery(findGenreName + book.getGenreName() + "')");

        while (rst1.next()) {
            genreId = rst1.getInt("id");
        }
        DataSourceUtil.closeConnection(conn);
    }
    //    Get id of book from books table
    private void getBookId(Book book) throws SQLException {

        Connection conn = DataSourceUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(findBookTitle + book.getTitle() + findBookISBN + book.getISBN() + "')");

        while (rst.next()) {
            bookId = rst.getInt("id");
        }
        DataSourceUtil.closeConnection(conn);
    }
}
