package info.sameen.train.client;

import info.sameen.train.model.TrainFeed;

import java.io.IOException;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            TrainFeed trainFeed = new TrainFeed();

            System.out.println("Train type, Gear: ");
            String[] trainTypeGear = input.nextLine()
                    .trim()
                    .split(",");

            String maxSpeedStr = trainFeed.maxSpeedStr(trainTypeGear[0],
                    Integer.parseInt(trainTypeGear[1].trim()));
            System.out.println("Maximum speed: " + maxSpeedStr);
            System.out.println("------");

            System.out.println("Gear: ");
            int gear = Integer.parseInt(input.nextLine());
            String minEnergyStr = trainFeed.minEnergyStr(gear);
            System.out.println("Train with lowest energy consumption: " + minEnergyStr);
            System.out.println("------");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
