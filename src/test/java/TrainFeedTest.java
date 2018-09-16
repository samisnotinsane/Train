import info.sameen.TrainDetail;
import info.sameen.TrainFeed;
import org.junit.*;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by sameen on 15/09/2018.
 */
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

    @After
    public void tearDown() {

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
        TrainDetail td = feed.getFeed().get(0);

        assertEquals("No details found", feed.maxSpeedStr("1111", -1));
    }

    @Test
    public void testMaxSpeedStrValidOne() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals("45", feed.maxSpeedStr("201V", 2));
    }

    @Test
    public void testMaxSpeedStrValidTwo() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals("40", feed.maxSpeedStr("201V", 1));
    }

    @Test
    public void testMaxSpeedStrValidThree() {
        TrainDetail td = feed.getFeed().get(0);

        assertEquals("50", feed.maxSpeedStr("157P", 2));
    }

}
