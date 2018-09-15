package info.sameen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sameen on 15/09/2018.
 */
public class TrainFeed {

    private String trainType;
    private int gear;
    private int speed;
    private int energy;

    public static TrainFeed load() {
        TrainFeed tf = null;
        File trainFile = new File("dat/TrainDetailsFeed.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(trainFile));

            String line = "";
            while( ( line = br.readLine() ) != null ) {
                String[] data = line.split("-");
                tf = new TrainFeed(data[0], Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            }
        } catch (IOException e) {
            System.err.print("File not found!");
        }
        return tf;
    }

    public TrainFeed() {
    }

    public TrainFeed(String trainType, int gear, int speed, int energy) {
        this.trainType = trainType;
        this.gear = gear;
        this.speed = speed;
        this.energy = energy;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
