package simstation_flocking;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

import java.awt.*;

public class Bird extends Agent {
    public static final int MAX_SPEED = 5;
    private final int RADIUS = 10;

    protected int speed;

    public Bird() {
        super();
        speed = Utilities.rng.nextInt(MAX_SPEED) + 1;
        heading = Heading.random();
    }


    @Override
    public void update() {
        Agent agent = world.getNeighbor(this, RADIUS);
        if (agent != null) {
            speed = ((Bird) agent).speed;
            heading = ((Bird) agent).heading;
            move(speed);
        }

    }

}
