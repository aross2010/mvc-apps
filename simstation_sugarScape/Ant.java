package simstation_sugarScape;

import simstation.Agent;
import simstation.Heading;


public class Ant extends Agent {

    protected int fitness;

    public Ant() {
        super();
        fitness = 3;
        heading = Heading.random();
    }

    @Override
    public void update() {
        SugarScape simulation = ((SugarScape)world);
        Point location = new Point(xc, yc);
        // must use a synchronized block if checking contains and removing
        synchronized (simulation) {
            if (simulation.sugarPods.contains(location)) {
                simulation.sugarPods.remove(location);
                fitness++;
                // increase the speed of the agent
                move(fitness);
            }
            heading = Heading.random();
            move(fitness);
        }
    }
}
