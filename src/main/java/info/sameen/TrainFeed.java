package info.sameen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainFeed {

    private final List<TrainDetail> feed;

    public TrainFeed() throws IOException {
        this.feed = new ArrayList<TrainDetail>();
        File trainFile = new File("dat/TrainDetailsFeed.txt");
        BufferedReader br = new BufferedReader(new FileReader(trainFile));
        br.readLine(); // consume header line
        String line;
        while( ( line = br.readLine() ) != null ) {
            String[] data = line.split("-");
            feed.add(new TrainDetail(data[0], Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
    }

    public List<TrainDetail> getFeed() {
        return feed;
    }

    private boolean isValidGear(int gear) {
        return gear > 0;
    }

    private boolean isValidTrainType(String trainType) {
        return trainType.length() == 4;
    }

    private int maxSpeed(String trainType, int gear) {
        int highestSpeedSoFar = Integer.MIN_VALUE;
        for(TrainDetail detail : feed) {
            if( (detail.getTrainType().equals(trainType)) && (detail.getGear() == gear)) {
                int speed = detail.getSpeed();
                if(speed > highestSpeedSoFar) {
                    highestSpeedSoFar = speed;
                }
            }
        }
        if(highestSpeedSoFar == Integer.MIN_VALUE) {
            return -1;
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

    private String trainTypeByMinEnergy(int gear) {
        String trainType = null;
        int minEnergySoFar = Integer.MAX_VALUE;
        for(TrainDetail detail : feed) {
            int selGear = detail.getGear();
            if (selGear == gear) {
                int energy = detail.getEnergy();
                if(energy < minEnergySoFar) {
                    minEnergySoFar = energy;
                    trainType = detail.getTrainType();
                }
            }
        }
        return trainType;
    }

    public String minEnergyStr(int gear) {
        if(isValidGear(gear)) {
            String trainType = trainTypeByMinEnergy(gear);
            if (trainType != null) {
                return trainType;
            }
        }
        return "No details found";
    }

}
