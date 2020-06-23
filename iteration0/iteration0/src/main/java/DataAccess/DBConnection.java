package DataAccess;

import java.sql.*;

public class DBConnection {

    private static DBConnection databaseConnection;

    private Connection connection = null;
    private static Statement statement = null;
    private String password = ""; //insert password
    private String dbName = "city_building";

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, "root", password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DBConnection();
        }
        return databaseConnection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Exception during connection close: " + ex);
        }
    }
}
