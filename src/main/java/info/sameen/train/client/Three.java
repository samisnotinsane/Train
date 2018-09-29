package info.sameen.train.client;

import info.sameen.train.model.Departure;
import info.sameen.train.model.DepartureFeed;

import java.util.ArrayList;
import java.util.List;

public class Three {

    public static void main(String[] args) {
        System.out.print("Loading feed from text file...");
        DepartureFeed feed = new DepartureFeed().loadFeed();
        System.out.print("[OK]\n");
        System.out.print("Inserting data into train_driver_details table in db...");
        feed.insertDriverFeed();
        System.out.print("[OK]\n");
        System.out.print("Inserting data into train_delay_details table in db...");
        feed.insertDelayFeed();
        System.out.print("[OK]\n");
        System.out.print("Complete!\n");
    }

}
