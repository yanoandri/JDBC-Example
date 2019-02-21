package id.academy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    private static final String DATABASE_URL = "JDBC:mysql://localhost:3306/perpustakaan";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public  static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
