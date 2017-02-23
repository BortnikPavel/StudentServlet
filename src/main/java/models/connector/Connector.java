package models.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
    private static final String HOST = "jdbc:mysql://localhost:3306/stud";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static volatile Connection connectionDB;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnectionDB(){
        Connection localInstance = connectionDB;
        if (localInstance == null) {
            synchronized (Connector.class) {
                localInstance = connectionDB;
                if (localInstance == null) {
                    try {
                        connectionDB = localInstance = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
                        //System.out.println("Connection is open");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return localInstance;
    }
}
