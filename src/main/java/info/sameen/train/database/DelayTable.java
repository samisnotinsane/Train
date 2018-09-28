package info.sameen.train.database;

import info.sameen.train.model.Departure;

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

    }


}
