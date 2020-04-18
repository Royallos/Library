package library.repository;

import library.entity.Book;
import library.util.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryImpl implements BookRepository {

    private final String  getBooksQuery = "Select * from books";
    private final String addBookQuery = "INSERT INTO books (title, ISBN, author_id, genre_id) values (?, ?, ?, ?)";
    private final String delete = "DELETE from books WHERE id = '";
    private final String addAuthorQuery = "INSERT INTO author (name, surname) Values (?, ?)";
    private final String addGenreQuery = "INSERT INTO genre (name) Values (?)";
    private final String checkAuthor = "Select * from author where name in ('";
    private final String checkGenre = "Select * from genre where name in ('";
    private final String findAuthorName = "Select * from author where name in ('";
    private final String findAuthorSurname = "') and surname in ('";
    private final String findGenreName = "Select * from genre where name in ('";
    protected int authorId;
    protected int genreId;

    @Override
    public List<Book> getBooks() throws SQLException {

        Connection connect = DataSourceUtil.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(getBooksQuery);
        List<Book> book = new ArrayList<>();
        book.addAll(getListBook(rs));
        return book;
    }
    private List<Book> getListBook(ResultSet rs) throws SQLException {

        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            books.add(getBook(rs));
        }

        return books;
    }

    private Book getBook(ResultSet rs) throws SQLException {

        Book book = new Book();

        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setISBN(rs.getString("ISBN"));

        return book;
    }

    @Override
    public Book addBook(Book book) throws SQLException {

        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst = connect.prepareStatement(addBookQuery, Statement.RETURN_GENERATED_KEYS);
        prst.setString(1, book.getTitle());
        prst.setString(2, book.getISBN());
        prst.setInt(3, authorId);
        prst.setInt(4, genreId);
        prst.executeUpdate();
        checkAuthor(book);
        checkGenre(book);
        addAuthorGenreId(book);
        return null;
    }
    public void checkAuthor(Book book) throws SQLException {
        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst1 = connect.prepareStatement(addAuthorQuery);
        prst1.setString(1,book.getAuthorName());
        prst1.setString(2,book.getAuthorSurname());
        if (checkAuthorName(book)) {
            prst1.executeUpdate();
        }

    }

    public void checkGenre(Book book) throws SQLException {
        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst2 = connect.prepareStatement(addGenreQuery);
        prst2.setString(1, book.getGenreName());
        if (checkGenreName(book)) {
            prst2.executeUpdate();
        }
    }
    private boolean checkAuthorName(Book book) throws SQLException {

        boolean res = true;
        Connection connect = DataSourceUtil.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(checkAuthor + book.getAuthorName() + "')");

        while (rs.next()) {
            if (rs.getString("name").equals(book.getAuthorName()) && rs.getString("surname").equals(book.getAuthorSurname())) {

                res = false;
            }
        }
        return res;
    }
    private boolean checkGenreName(Book book) throws SQLException {

        boolean res = true;
        Connection connect = DataSourceUtil.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(checkGenre + book.getGenreName() + "')");

        while (rs.next()) {
            if (rs.getString("name").equals(book.getGenreName())) {

                res = false;
            }
        }
        return res;
    }

    private void addAuthorGenreId(Book book) throws SQLException {

        Connection conn = DataSourceUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(findAuthorName + book.getAuthorName() + findAuthorSurname + book.getAuthorSurname() +"')");

        while (rst.next()) {
            authorId = rst.getInt("id");
        }

        Statement stmt1 = conn.createStatement();
        ResultSet rst1 = stmt1.executeQuery(findGenreName + book.getGenreName() + "')");

        while (rst1.next()) {
            genreId = rst1.getInt("id");
        }

    }

    @Override
        public void deleteBook () throws SQLException {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id of book");
            int id = scan.nextInt();
            Connection connect = DataSourceUtil.getConnection();
            Statement st = connect.createStatement();
            st.executeUpdate(delete + id + "'");
        }
}