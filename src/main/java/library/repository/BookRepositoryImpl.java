package library.repository;

import library.entity.Book;
import library.util.DataSourceUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryImpl implements BookRepository {

    private final String getBooksQuery = "Select * from books";
    private final String addBookQuery = "INSERT INTO books (title, ISBN) values (?, ?)";
    private final String delete = "DELETE from books WHERE id = '";


    @Override
//    Get list of book
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
//    Fill the books table
    public Book addBook(Book book) throws SQLException {

        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst = connect.prepareStatement(addBookQuery);
        prst.setString(1, book.getTitle());
        prst.setString(2, book.getISBN());
        prst.executeUpdate();
        DataSourceUtil.closeConnection(connect);
        return null;
    }

    @Override
//    Delete book from books table
        public void deleteBook () throws SQLException {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id of book");
            int id = scan.nextInt();
            Connection connect = DataSourceUtil.getConnection();
            Statement st = connect.createStatement();
            st.executeUpdate(delete + id + "'");
        DataSourceUtil.closeConnection(connect);
        }
}