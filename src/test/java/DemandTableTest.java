import info.sameen.Demand;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;

public class DemandTableTest {

    private List<Demand> lstDemand;
    private String[] stations = {
            "Waterloo", "Surbiton", "Esher", "Hersham", "Walton-on-Thames", "Woking"
    };
    private int[][] demands = {
            // Waterloo
            {       0, // Waterloo
                    400, // Surbiton
                    500, // Esher
                    650, // Hersham
                    450, // Walton-on-Thames
                    200 // Woking
            },

            // Surbiton
            {
                    450, // Waterloo
                    0, // Surbiton
                    235, // Esher
                    350, // Hersham
                    250, // Walton-on-Thames
                    250 // Woking
            },

            // Esher
            {
                    250, // Waterloo
                    350, // Surbiton
                    0, // Esher
                    200, // ...
                    340,
                    150
            },

            // Hersham
            {
                    150,
                    230,
                    220,
                    0,
                    310,
                    350
            },

            // Walton-on-Thames
            {
                    230,
                    150,
                    320,
                    225,
                    0,
                    320
            },

            // Woking
            {
                    250,
                    340,
                    95,
                    245,
                    230,
                    0
            }
    };


    @Before
    public void setUp() {
        lstDemand = new ArrayList<Demand>();

        for(int i=0; i<stations.length; i++) {
            for(int j=0; j<stations.length; j++) {
                lstDemand.add(Demand.originToDestination(stations[i], stations[j], demands[i][j]));
            }
        }
    }

    @Test
    public void testWaterlooToSurbitonDemand() {

        assertEquals(400, Demand.searchOriginToDestination("Waterloo", "Surbiton"));
    }

    @Test
    public void testHershamToEsherDemand() {

        assertEquals(220, Demand.searchOriginToDestination("Hersham", "Esher"));
    }

    @Test
    public void testWokingToWokingDemand() {

        assertEquals(0, Demand.searchOriginToDestination("Woking", "Woking"));
    }
}
