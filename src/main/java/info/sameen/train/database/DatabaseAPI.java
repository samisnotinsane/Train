package info.sameen.train.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAPI {

    private final String URL = "jdbc:sqlite:dat/train.db";

    private Connection connection = null;
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

    public List<String[]> getAllDriverRow() throws SQLException {
        List<String[]> rows = new ArrayList<>();
        this.connect(); // initiate connection to db if not already connected.

        String sqlString = "SELECT train_id, from_station, to_station, driver_name, journey_status " +
                        "FROM train_driver_details";

        Connection connection = this.connection;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlString);

        while(resultSet.next()) {
            String[] row = new String[5];

            String trainId = resultSet.getString("train_id");
            String fromStation = resultSet.getString("from_station");
            String toStation = resultSet.getString("to_station");
            String driverName = resultSet.getString("driver_name");
            String journeyStatus = resultSet.getString("journey_status");

            row[0] = trainId;
            row[1] = fromStation;
            row[2] = toStation;
            row[3] = driverName;
            row[4] = journeyStatus;

            rows.add(row);
        }
        return rows;
    }

    public void putDriverRow(String[] record) throws SQLException {
        String sqlString = "INSERT INTO train_driver_details(train_id, from_station, to_station, " +
                "driver_name, journey_status) VALUES(?,?,?,?,?)";

        this.connect();

        Connection connection = this.connection;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
        preparedStatement.setString(1, record[0]); // train_id
        preparedStatement.setString(2, record[1]); // from_station
        preparedStatement.setString(3, record[2]); // to_station
        preparedStatement.setString(4, record[3]); // driver_name
        preparedStatement.setString(5, record[4]); // journey_status

        preparedStatement.executeUpdate();
    }

    public List<String[]> getAllDelayRows() throws SQLException {
        List<String[]> rows = new ArrayList<>();
        this.connect();

        String sqlString = "SELECT train_id, station, departure_time_at_station, departure_lateness_in_seconds " +
                "FROM train_delay_details";
        Connection connection = this.connection;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlString);
        while (resultSet.next()) {
            String[] row = new String[4];

            String trainId = resultSet.getString("train_id");
            String station = resultSet.getString("station");
            String depTime = resultSet.getString("departure_time_at_station");
            String depLate = resultSet.getString("departure_lateness_in_seconds");

            row[0] = trainId;
            row[1] = station;
            row[2] = depTime;
            row[3] = depLate;

            rows.add(row);
        }
        return rows;
    }

    public void putDelayRow(String[] record) throws SQLException {
        String sqlString = "INSERT INTO train_delay_details(train_id, station, departure_time_at_station, departure_lateness_in_seconds) VALUES(?,?,?,?)";
        this.connect();
        Connection connection = this.connection;
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
        preparedStatement.setString(1, record[0]);
        preparedStatement.setString(2, record[1]);
        preparedStatement.setString(3, record[2]);
        preparedStatement.setString(4, record[3]);

        preparedStatement.executeUpdate();
    }
}
