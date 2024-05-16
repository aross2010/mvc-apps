package simstation_sugarScape;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;
import simstation_flocking.FlockingFactory;

import java.util.HashSet;
import java.util.Set;

public class SugarScape extends Simulation {
    protected Set<Point> sugarPods;
    private final int NUM_SUGAR_PODS = 50;
    private final int NUM_ANTS = 100;

    public SugarScape() {
        super();
        sugarPods = new HashSet<>();
        for (int i = 0; i < NUM_SUGAR_PODS; i++) {
            sugarPods.add(new Point(Utilities.rng.nextInt(Agent.MAX_XC), Utilities.rng.nextInt(Agent.MAX_YC)));
        }
    }

    public void populate() {
        for (int i = 0; i < NUM_ANTS; i++) {
            addAgent(new Ant());
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new SugarScapeFactory());
        panel.display();
    }


}
