package info.sameen.model;



public class Departure {

    private String trainId;
    private String station;
    private String departureTime; // actual time
    private String driverName;
    private String departureLateness; // in seconds

    public Departure(String trainId, String station, String departureTime, String driverName,
                     String departureLateness) {
        this.trainId = trainId;
        this.station = station;
        this.departureTime = departureTime;
        this.driverName = driverName;
        this.departureLateness = departureLateness;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getStation() {
        return station;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDepartureLateness() {
        return departureLateness;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "trainId='" + trainId + '\'' +
                ", station='" + station + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", driverName='" + driverName + '\'' +
                ", departureLateness=" + departureLateness +
                '}';
    }
}
