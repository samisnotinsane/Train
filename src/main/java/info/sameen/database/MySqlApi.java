package info.sameen.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class MySqlApi {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public MySqlApi() throws SQLException {
        String url = "jdbc:sqlite:C://sqlite/db/train.db";
        connect = DriverManager.getConnection(url);
    }

    public void insert_delay(String train_id, String station, String departure_time, String departure_lateness) {
        throw new NotImplementedException();
    }
}
