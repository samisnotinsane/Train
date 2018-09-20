package info.sameen.model;

import java.time.LocalDateTime;

public class DepartureFeed {

    private String trainId;
    private String station;
    private LocalDateTime departureTime; // actual time
    private String driverName;
    private int departureLateness; // in seconds

    public DepartureFeed() {

    }


}
