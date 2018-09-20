package info.sameen.client;

import info.sameen.model.Demand;
import info.sameen.model.DemandTable;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sameen on 20/09/2018.
 */
public class Two {

    public static void main(String[] args) {
        new Two();
    }

    private DemandTable demandTable;

    public Two() {
        this.demandTable = new DemandTable();
        Scanner input = new Scanner(System.in);

        System.out.println("Number of station pairs: ");
        String strNoStn = input.nextLine();
        int noStn = Integer.parseInt(strNoStn);
        for(int i=0; i<noStn; i++) {
            String[] orgDestDem = getOriginDestDemand(input); // size is always 3 (origin, dest, demandValue)
            Demand d = new Demand(orgDestDem[0]); // passes origin
            d.addDemand(orgDestDem[1], Integer.parseInt(orgDestDem[2]));
            demandTable.add(d);
        }

        System.out.println("--------");

        for(Demand d : demandTable.getDemands() ) {
            String origin = d.getOrigin();
            String destination = d.getDestination();
            int demand = d.getDemand();
            System.out.println(origin + " -> " + destination + " [" + demand + "]" );
        }

        System.out.println("--------");

        List<Demand> maxDems = demandTable.maxDemand();
        if (maxDems != null) {
            for (Demand d : maxDems) {
                System.out.println("Maximum demand is between " + d.getOrigin() +
                        " to " + d.getDestination() + " (" + d.getDemand() + ")");
            }
        }

        System.out.println("--------");

        System.out.println("Minimum demand for investigation: ");
        int minThresh = Integer.parseInt(input.nextLine());
        List<Demand> ivgDemands = demandTable.investigate(minThresh);
        if (ivgDemands.isEmpty()) {
            System.out.println("No results");
        } else {
            for (Demand d : ivgDemands) {
                System.out.println(d.getOrigin() + " to " + d.getDestination() + " - " + d.getDemand());
            }
        }


    }

    public static String[] getOriginDestDemand(Scanner input) {
        String[] result = new String[3];
        System.out.println("origin -> destination: ");
        String orgDestStr = input.nextLine();
        String[] orgDestParsed = orgDestStr.split("->");
        System.out.println("demandValue: ");
        String strDemand = input.nextLine();

        result[0] = orgDestParsed[0].trim();
        result[1] = orgDestParsed[1].trim();
        result[2] = strDemand.trim();
        return result;
    }
}
