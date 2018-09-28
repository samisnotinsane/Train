package info.sameen.train.database;

import info.sameen.train.model.Departure;
import info.sameen.train.model.TrainJourney;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverTable {

    private DatabaseAPI db;
    private List<TrainJourney> rows;

    public DriverTable() {
        // Read all rows from driver_details table and store them in <code>rows</code>.
        this.rows = new ArrayList<>();
        this.db = new DatabaseAPI();
        loadRowsFromDb();
    }

    private void loadRowsFromDb() {
        try {
            List<String[]> rawRows = this.db.getAllDriverDetailsRow(); // connects to db automatically
            for (String[] rawRow : rawRows) {
                // rawRow: [train_id, from_station, to_station, driver_name, journey_status]
                this.rows.add(
                        new TrainJourney(
                                rawRow[0], rawRow[1], rawRow[2],
                                null, rawRow[3], null,
                                rawRow[4]
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TrainJourney getRow(int i) {
        int index = 0;
        for(TrainJourney row : this.rows) {
            if(index == i)
                return row;
            index++;
        }
        return null;
    }

    /**
     * @deprecated
     * @param d
     */
    public void insertDbDelay(Departure d) {
        String train_id = d.getTrainId();
        String station = d.getStation();
        String departure_time = d.getDepartureTime();
        String departure_lateness = d.getDepartureLateness();
//        this.db.insert_delay(train_id, station, departure_time, departure_lateness);
    }


    public void initialiseDbConn() throws SQLException {
        this.db = new DatabaseAPI();
    }

    public void insertTrainJourney(TrainJourney journey) {
        String[] record = new String[5];
        record[0] = journey.getTrainId();
        record[1] = journey.getStation();
        record[2] = journey.getToStation();
        record[3] = journey.getDriverName();
        record[4] = journey.getJourneyStatus();
        try {
            this.db.putDriverDetailsRow(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}