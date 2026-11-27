package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String url;
    private String user;
    private String password;
    private Connection connection;

    private DatabaseConnection() throws SQLException{
        this.url = "jdbc:mysql://localhost:3306/tp_bank" ;
        this.user = "tp_bank";
        this.password = "eragat'14ta";

        connect();
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection() throws SQLException{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }
}

