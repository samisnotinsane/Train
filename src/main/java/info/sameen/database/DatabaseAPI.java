package info.sameen.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(URL);
            this.isConnected = true;
        }
        return isConnected;
    }

    public boolean disconnect() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
            this.isConnected = false;
        }
        return this.isConnected;
    }

    public List<String[]> getAllDriverDetailsRows() throws SQLException {
        List<String[]> rows = new ArrayList<>();

        this.connect();
        String sqlString = "SELECT train_id, station, driver_name, journey_status FROM train_driver_details";
        try(Connection connection = this.connection;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlString)) {

            while(resultSet.next()) {
                String[] row = new String[4];

                String trainId = resultSet.getString("train_id");
                String station = resultSet.getString("station");
                String driverName = resultSet.getString("driver_name");
                String journeyStatus = resultSet.getString("journey_status");

                row[0] = trainId;
                row[1] = station;
                row[2] = driverName;
                row[3] = journeyStatus;

                rows.add(row);
            }
        }

        return rows;
    }

    public void insert_delay(String train_id, String station, String departure_time, String departure_lateness) {
        throw new NotImplementedException();
    }
}
