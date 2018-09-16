package info.sameen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameen on 15/09/2018.
 */
public class TrainFeed {

    private List<TrainDetail> feed;

    public TrainFeed() throws IOException {
        this.feed = new ArrayList<TrainDetail>();
        File trainFile = new File("dat/TrainDetailsFeed.txt");
        BufferedReader br = new BufferedReader(new FileReader(trainFile));
        br.readLine(); // consume header line
        String line = "";
        while( ( line = br.readLine() ) != null ) {
            String[] data = line.split("-");
            feed.add(new TrainDetail(data[0], Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
    }

    private boolean isValidGear(int gear) {
        return gear > 0;
    }

    private boolean isValidTrainType(String trainType) {
        return trainType.length() == 4;
    }

    private int maxSpeed(String trainType, int gear) {
        int highestSpeedSoFar = -1;
        for(TrainDetail detail : feed) {
            if( (detail.getTrainType().equals(trainType)) && (detail.getGear() == gear)) {
                int speed = detail.getSpeed();
                if(speed > highestSpeedSoFar) {
                    highestSpeedSoFar = speed;
                }
            }
        }
        return highestSpeedSoFar;
    }

    public String maxSpeedStr(String trainType, int gear) {
        if(isValidTrainType(trainType) && isValidGear(gear)) {
            int maxSpeed = maxSpeed(trainType, gear);
            if(maxSpeed != -1) {
                return Integer.toString(maxSpeed);
            } else {
                return "No details found";
            }

        }
        return "No details found";
    }

    public List<TrainDetail> getFeed() {
        return feed;
    }
}
