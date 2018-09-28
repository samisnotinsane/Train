package info.sameen.train.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demand {

    private String origin;
    private Map<String, Integer> demandMap;

    public Demand() {
        this.origin = null;
        this.demandMap = new HashMap<String, Integer>();
    }

    public Demand(String origin) {
        this.origin = origin;
        this.demandMap = new HashMap<String, Integer>();
    }

    public void addDemand(String dest, int d) {
        demandMap.put(dest, d);
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        Set<String> keySet = this.demandMap.keySet();
        return keySet.iterator().next();
    }

    public int getDemand() {
        return this.demandMap.get(this.getDestination());
    }

    @Override
    public String toString() {
        return "Demand{" +
                "origin='" + origin + '\'' +
                ", demandMap=" + demandMap +
                '}';
    }
}
