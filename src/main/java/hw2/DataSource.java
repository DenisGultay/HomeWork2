package hw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Користувач on 03.07.2017.
 */
public class DataSource {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/homework1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
