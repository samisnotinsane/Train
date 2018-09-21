package info.sameen.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepartureFeed {

    private List<Departure> departures;

    public DepartureFeed() {
        this.departures = new ArrayList<>();

        loadFileData(new File("dat/DriverAndDelayDetails.txt"));

        for (Departure departure : this.departures) {
            System.out.println(departure.toString());
        }
    }

    public List<Departure> lateDepartures() {
        List<Departure> lateDepartures = new ArrayList<>();

        for(Departure d : this.departures) {
            if (!d.getDepartureLateness().equals("NA")) {
                lateDepartures.add(d);
            }
        }

        return lateDepartures;
    }

    /**
     * Caution: This method is not yet functional.
     * @deprecated
     * @return
     */
    public List<Departure> completedJourneys() {
        List<Departure> completedJourneys = new ArrayList<>();
        for (Departure departure : this.departures) {
            for (Departure dep : this.departures) {

                // Stuck: not sure how I can determine
                // a train journey is complete given the data in DriverAndDelayDetails.txt
                throw new NotImplementedException();

            }
        }
        return completedJourneys;
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


}
