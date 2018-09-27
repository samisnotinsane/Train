package info.sameen.model;

public class TrainJourney extends Departure {

    private String toStation;
    private String journeyStatus;

    public TrainJourney(String trainId, String station, String toStation,
                        String departureTime, String driverName, String departureLateness,
                        String journeyStatus) {
        super(trainId, station, departureTime, driverName, departureLateness);
        this.toStation = toStation;
        this.journeyStatus = journeyStatus;
    }

    public String getToStation() {
        return toStation;
    }

    public String getJourneyStatus() {
        return journeyStatus;
    }
}
