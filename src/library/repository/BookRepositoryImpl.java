package library.repository;

import library.entity.Book;
import library.entity.Product;
import library.util.DataSourceUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryImpl implements BookRepository {

    private final String  getBooksQuery = "Select * from books";
    private final String addBookQuery = "Insert into books (id, title, author, genre, ISBN) values (?, ?, ?, ?, ?)";
    private final String delete = "DELETE from books WHERE author = '";

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
        book.setAuthor(rs.getString("author"));
        book.setGenre(rs.getString("genre"));
        book.setISBN(rs.getString("ISBN"));

        return book;
    }

    @Override
    public Book addBook(Book book) throws SQLException {

        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst = connect.prepareStatement(addBookQuery, Statement.RETURN_GENERATED_KEYS);
        prst.setString(2 ,book.getTitle());
        prst.setString(3 ,book.getAuthor());
        prst.setString(4 ,book.getGenre());
        prst.setString(5 ,book.getISBN());
        prst.setInt(1 ,book.getId());
        prst.executeUpdate();
        ResultSet rsKeys = prst.getGeneratedKeys();

        if (rsKeys.next()) {
            book.setId(rsKeys.getInt(1));
        }

        return null;
    }

    @Override
        public void deleteBook () throws SQLException {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter id of book");
            String author = scan.nextLine();
            Connection connect = DataSourceUtil.getConnection();
            Statement st = connect.createStatement();
            st.executeUpdate(delete + author + "'`");
        }
}
