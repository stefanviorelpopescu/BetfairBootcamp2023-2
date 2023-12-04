package org.digitalstack.databases;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        loadDriver();

        callSelect(70);

    }

    private static void callSelect(int age) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from authors where age > ?"))
        {
            statement.setInt(1, age);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name") + " : " + resultSet.getString("phone"));
                }
            }
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException|IllegalAccessException|ClassNotFoundException e){
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() {
        try {
            String url = "jdbc:" +
                    "postgresql" + // “mysql” / “db2” / “mssql” / “oracle” / ...
                    "://" +
                    "localhost" +
                    ":" +
                    "5432" +
                    "/" +
                    "postgres" +
                    "?user=" +
                    "postgres" +
                    "&password=" +
                    "root";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
            throw new RuntimeException();
        }
    }

}
