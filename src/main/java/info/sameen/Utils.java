package info.sameen;

import java.io.*;

/**
 * Created by sameen on 14/09/2018.
 */
public class Utils {

    public static void main(String[] args) {
        TrainFeed feed = loadTrainDetails();

    }

    private static TrainFeed loadTrainDetails() {
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
}
