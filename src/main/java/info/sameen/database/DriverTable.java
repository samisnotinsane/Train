package info.sameen.database;

import info.sameen.model.Departure;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverTable {

    private DatabaseAPI db;
    private List<Departure> rows;

    public DriverTable() {
        // Read all rows from driver_details table and store them in <code>rows</code>.
        this.rows = new ArrayList<>();
        loadRowsFromDb();
    }

    private void loadRowsFromDb() {


    }

    public Departure getRow(int i) {
        int index = 0;
        for(Departure row : this.rows) {
            if(index == i)
                return row;
            index++;
        }
        return null;
    }

    public void insertDbDelay(Departure d) {
        String train_id = d.getTrainId();
        String station = d.getStation();
        String departure_time = d.getDepartureTime();
        String departure_lateness = d.getDepartureLateness();

        this.db.insert_delay(train_id, station, departure_time, departure_lateness);
    }


    public void initialiseDbConn() throws SQLException {
        this.db = new DatabaseAPI();
    }

}
