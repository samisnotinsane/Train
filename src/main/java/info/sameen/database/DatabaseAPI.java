package info.sameen.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseAPI {

    private final String URL = "jdbc:sqlite:dat/train.db";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private boolean isConnected;

    public DatabaseAPI() {
        this.isConnected = false;
    }

    public boolean connect() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.isConnected = true;
        return isConnected;
    }

    public boolean disconnect() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
            this.isConnected = false;
        }
        return this.isConnected;
    }

    public void insert_delay(String train_id, String station, String departure_time, String departure_lateness) {
        throw new NotImplementedException();
    }
}
