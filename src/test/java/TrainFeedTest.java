import info.sameen.TrainDetail;
import info.sameen.TrainFeed;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class TrainFeedTest {

    private TrainFeed feed;

    @Before
    public void setUp() {
        try {
            feed = new TrainFeed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTrainType() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals("156A", td.getTrainType());
    }

    @Test
    public void testGear() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals(1, td.getGear());
    }

    @Test
    public void testSpeed() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals(10, td.getSpeed());
    }

    @Test
    public void testTrainEnergy() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals(50, td.getEnergy());
    }

    @Test
    public void testMaxSpeedStrInvalid() {

        assertEquals("No details found", feed.maxSpeedStr("1111", -1));
    }

    @Test
    public void testMaxSpeedStrValidOne() {

        assertEquals("45", feed.maxSpeedStr("201V", 2));
    }

    @Test
    public void testMaxSpeedStrValidTwo() {

        assertEquals("40", feed.maxSpeedStr("201V", 1));
    }

    @Test
    public void testMaxSpeedStrValidThree() {

        assertEquals("50", feed.maxSpeedStr("157P", 2));
    }

    @Test
    public void testMinEnergyInvalid() {

        assertEquals("No details found", feed.minEnergyStr(0));
    }

    @Test
    public void testMinEnergyByGearOne() {

        assertEquals("157P", feed.minEnergyStr(1)); // energy rating: 40
    }

    @Test
    public void testMinEnergyByGearTwo() {

        assertEquals("156A", feed.minEnergyStr(2)); // energy rating: 80
    }

}
