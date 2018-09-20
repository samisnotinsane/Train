package info.sameen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sameen on 20/09/2018.
 */
public class DemandTable {

    private List<Demand> demands;

    public DemandTable() {
        this.demands = new ArrayList<Demand>();
    }

    public List<Demand> investigate(int minThreshold) {
        List<Demand> toInvestigate = new ArrayList<Demand>();
        for (Demand d : this.demands) {
            if(d.getDemand() > minThreshold) {
                toInvestigate.add(d);
            }
        }
        return toInvestigate;
    }

    public List<Demand> maxDemand() {
        List<Demand> maxDems = new ArrayList<Demand>();
        Demand maxDem = null;

        // Find the highest demand value
        int highestSoFar = Integer.MIN_VALUE;
        for(Demand d : this.demands) {
            int curDem = d.getDemand();
            if (curDem > highestSoFar) {
                highestSoFar = curDem;
                maxDem = d;
            }
        }

        // Look for other records with the highest demand value
        for(Demand d : this.demands) {
            if (d.getDemand() == highestSoFar)
                maxDems.add(d);
        }

        if (highestSoFar == Integer.MIN_VALUE)
            return null;

        return maxDems;
    }

    public void add(Demand d) {
        demands.add(d);
    }

    public int demandValue(String origin, String destination) {
        for(Demand d : demands) {
            if(d.getOrigin().equals(origin)) {
                return d.getDemand();
            }
        }
        return -1;
    }

    public List<Demand> getDemands() {
        return demands;
    }
}
