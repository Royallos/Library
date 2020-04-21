package library.repository;

import library.entity.Book;
import library.util.DataSourceUtil;

import java.sql.*;

public class GenreRepositoryImpl  implements GenreRepository {

    private final String addGenreQuery = "INSERT INTO genre (name) Values (?)";
    private final String checkGenre = "Select * from genre where name in ('";


    @Override
    //    Fill the genre table
    public void addGenre(Book book) throws SQLException {
        Connection connect = DataSourceUtil.getConnection();
        PreparedStatement prst2 = connect.prepareStatement(addGenreQuery);
        prst2.setString(1, book.getGenreName());
        if (checkGenreName(book)) {
            prst2.executeUpdate();
        }
        DataSourceUtil.closeConnection(connect);
    }
    //    Check contain of genre table. If new genre doesnt exist -> add new row
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
        DataSourceUtil.closeConnection(connect);
        return res;
    }

}
