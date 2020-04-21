package library.repository;

import library.entity.Book;
import library.util.DataSourceUtil;

import java.sql.*;

public class AuthorRepositoryImpl implements AuthorRepository {

    private final String checkAuthor = "Select * from author where name in ('";
    private final String addAuthorQuery = "INSERT INTO author (name, surname) Values (?, ?)";


    @Override
//    Fill the books table
    public void addAuthor(Book book) throws SQLException {
        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst1 = connect.prepareStatement(addAuthorQuery);
        prst1.setString(1, book.getAuthorName());
        prst1.setString(2, book.getAuthorSurname());
        if (checkAuthorName(book)) {
            prst1.executeUpdate();
        }
        DataSourceUtil.closeConnection(connect);
    }
//    Check contain of author table. If new author doesnt exist -> add new row
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
        DataSourceUtil.closeConnection(connect);
        return res;
    }

}
