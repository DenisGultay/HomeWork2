package hw2;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Користувач on 29.06.2017.
 */
public class Main {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/homework1";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Driver not connect");
        }

    }
}
