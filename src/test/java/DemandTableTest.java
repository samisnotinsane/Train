import info.sameen.model.Demand;

import info.sameen.model.DemandTable;
import org.junit.*;

import static org.junit.Assert.*;

public class DemandTableTest {

    private DemandTable demandTable;

    private String[] stations = {
            "Waterloo", "Surbiton", "Esher", "Hersham", "Walton-on-Thames", "Woking"
    };
    private int[][] demands = {
            // From...
            // Waterloo
            {       0, // To... Waterloo
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
        this.demandTable = new DemandTable();
        for(int i=0; i<stations.length; i++) {
            Demand d = new Demand(stations[i]); // Waterloo
            for(int j=0; j<stations.length; j++) {
                d.addDemand(stations[j], demands[i][j]); // (Waterloo, 0)
            }
            demandTable.add(d);
        }
    }

    @Test
    public void testWaterlooToSurbitonDemand() {

        assertEquals(400, demandTable.demandValue("Waterloo", "Surbiton"));
    }

    @Test
    public void testHershamToEsherDemand() {

        assertEquals(220, demandTable.demandValue("Hersham", "Esher"));
    }

    @Test
    public void testWokingToWokingDemand() {

        assertEquals(0, demandTable.demandValue("Woking", "Woking"));
    }
}
