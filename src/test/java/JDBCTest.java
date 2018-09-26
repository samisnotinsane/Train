import info.sameen.model.Departure;
import info.sameen.model.DepartureFeed;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class JDBCTest {

    DepartureFeed feed;

    @Before
    public void setUp() {
        this.feed = new DepartureFeed();
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
    public void testDriverDBStation() {

        assertEquals("London Waterloo",
                feed.getDriverTable().getRow(0).getStation());
    }

    @Test
    public void testDriverDBName() {

        assertEquals("John Scott",
                feed.getDriverTable().getRow(0).getDriverName());
    }





}
