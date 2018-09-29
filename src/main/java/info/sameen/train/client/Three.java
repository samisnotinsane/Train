package info.sameen.train.client;

import info.sameen.train.model.Departure;
import info.sameen.train.model.DepartureFeed;

import java.util.ArrayList;
import java.util.List;

public class Three {

    public static void main(String[] args) {
        // Caution: JDBC methods are not yet implemented,
        // this code is not yet functional.

        DepartureFeed depFeed = new DepartureFeed();
//        List<Departure> lateDepartures = depFeed.lateDepartures();

        // Only keep [train_id, station, departure_time, departure_lateness] fields
        List<String> filteredFields = new ArrayList<>();
//        try {
//            depFeed.initialiseDbConn();
//            for (Departure lateDep : lateDepartures) {
//                depFeed.insertDbDelay(lateDep);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
