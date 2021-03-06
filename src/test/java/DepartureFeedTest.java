import info.sameen.train.database.DatabaseAPI;
import info.sameen.train.model.Departure;
import info.sameen.train.model.DepartureFeed;
import info.sameen.train.model.TrainJourney;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DepartureFeedTest {

    private DepartureFeed feed; // text file data
    private DatabaseAPI db; // JDBC DAO

    @Before
    public void setUp() {
        this.feed = new DepartureFeed();
        this.db = new DatabaseAPI();
        this.feed.loadFeed();
    }

    @Test
    public void testTrainId() {

        assertEquals("2F29",
                feed.getDepartures().get(0).getTrainId());
    }

    @Test
    public void testTrainStation() {

        assertEquals("Vauxhall",
                feed.getDepartures().get(1).getStation());
    }

    @Test
    public void testTrainDepartureTime() {

        assertEquals("2018-09-04T14:32:00",
                feed.getDepartures().get(2).getDepartureTime());
    }

    @Test
    public void testTrainDriverName() {

        assertEquals("Andrew Lees",
                feed.getDepartures().get(4).getDriverName());
    }

    @Test
    public void testDepartureLateness() {

        assertEquals("120",
                feed.getDepartures().get(6).getDepartureLateness());
    }

    @Test
    public void testDriverDBApiStation() {
        String[] row = new String[4]; // [train_id, station, driver_name, journey_status]
        try {
            row = this.db.getAllDriverRow().get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals("London Waterloo", row[1]);
    }

    @Test
    public void testDriverDBStation() {

        assertEquals("London Waterloo",
                feed.getDriverTable().getRow(0).getStation());
    }

    @Test
    public void testDriverDBName() {

        assertEquals("John Scott",
                feed.getDriverTable().getRow(0).getDriverName());
    }

    @Test
    public void testDriverTableTrainIdRetrival() {
        TrainJourney journey = this.feed.getDriverTable().getRow(0);

        assertEquals("2F29", journey.getTrainId());
    }

    @Test
    public void testDriverTableFromStationRetrival() {
        TrainJourney journey = this.feed.getDriverTable().getRow(0);

        assertEquals("London Waterloo", journey.getStation());
    }

    @Test
    public void testDriverTableToStationRetrival() {
        TrainJourney journey = this.feed.getDriverTable().getRow(12);

        assertEquals("Guildford", journey.getToStation());
    }

    @Test
    public void testDriverTableDriverNameRetrival() {
        TrainJourney journey = this.feed.getDriverTable().getRow(0);

        assertEquals("John Scott", journey.getDriverName());
    }

    @Test
    public void testDriverTableJourneyStatusRetrival() {
        TrainJourney journey = this.feed.getDriverTable().getRow(0);

        assertEquals("INCOMPLETE", journey.getJourneyStatus());
    }

    @Test
    public void testDelayTableReadTrainId() {
        Departure departure = this.feed.getDelayTable().getRow(0);

        assertEquals("2F29", departure.getTrainId());
    }


}
