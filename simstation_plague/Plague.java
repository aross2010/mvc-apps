package simstation_plague;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

import java.awt.*;

import static simstation_plague.PlagueSimulation.*;

public class Plague extends Agent
{


    boolean infected = false;
    public void setInfected(boolean infected)
    {
        this.infected = infected;
    }
    public boolean getInfected()
    {
        return infected;
    }
    public Plague() {
        super();
        heading = Heading.random();
    }
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
        Agent agent = world.getNeighbor(this, CONTAGIOUSVALUE);
        if (agent != null && ((Plague) agent).getInfected() == true)
        {
            if (((Utilities.rng.nextInt(100) + 1) <= VIRULENCE) && ((Utilities.rng.nextInt(100) + 1) > RESISTANCE))
            {
                infected = true;
            }
        }
        if (infected)
        {
            color = Color.RED; //color of infected
        }
        else
        {
            color = Color.GREEN; //color of uninfected
        }

    }
}
