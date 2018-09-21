package info.sameen.model;

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
