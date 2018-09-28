package info.sameen.train.database;

import info.sameen.train.model.Departure;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DelayTable {

    private DatabaseAPI db;
    private List<Departure> rows;

    public DelayTable() {
        this.db = new DatabaseAPI();
        this.rows = new ArrayList<>();
        loadRowsFromDb();
    }

    private void loadRowsFromDb() {
        try {
            List<String[]> rawRows = this.db.getAllDelayRows();
            for (String[] rawRow : rawRows) {
                this.rows.add(
                        new Departure(
                                rawRow[0], rawRow[1], rawRow[2], null, rawRow[3]
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public Departure getRow(int i) {
        throw new NotImplementedException();
    }
}
