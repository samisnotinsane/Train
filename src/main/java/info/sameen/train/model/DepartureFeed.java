package info.sameen.train.model;

import info.sameen.train.database.DelayTable;
import info.sameen.train.database.DriverTable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepartureFeed {

    private List<Departure> departures;
    private DriverTable driverTable;
    private DelayTable delayTable;

    public DepartureFeed() {
        this.departures = new ArrayList<>();
    }

    private List<TrainJourney> computeTrainJourneys() {
        List<TrainJourney> trainJourneys = new ArrayList<>();
        for (Departure departure : this.departures) {
            String toStation = "";
            String journeyStatus;
            if (departure.getDepartureLateness().equals("NA")) {
                toStation = departure.getStation();
                journeyStatus = "COMPLETE";
            } else {
                journeyStatus = "INCOMPLETE";
            }
            TrainJourney trainJourney = new TrainJourney(departure, toStation, journeyStatus);
            trainJourneys.add(trainJourney);
        }
        return trainJourneys;
    }

    public void insertDriverFeed() {
        List<TrainJourney> journeys = this.computeTrainJourneys();
        this.getDriverTable().writeFeed(journeys);
    }

    public void insertDelayFeed() {
        this.getDelayTable().writeFeed(this.departures);
    }

    public DepartureFeed loadFeed() {
        if (this.departures.isEmpty()) {
            loadFileData(new File("dat/DriverAndDelayDetails.txt"));
        }
        return this;
    }

    private void loadFileData(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();

            String line;
            while( (line = br.readLine()) != null ) {
                String[] data = line.split("\\|");
                this.departures.add(new Departure(data[0], data[1], data[2], data[3], data[4]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Departure> getDepartures() {
        return departures;
    }

    public DriverTable getDriverTable() {
        if(this.driverTable == null) {
            this.driverTable = new DriverTable();
        }
        return this.driverTable;
    }

    public DelayTable getDelayTable() {
        if (this.delayTable == null) {
            this.delayTable = new DelayTable();
        }
        return this.delayTable;
    }

}
