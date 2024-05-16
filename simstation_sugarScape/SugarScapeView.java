package simstation_sugarScape;

import mvc.Model;
import mvc.View;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationView;

import java.awt.*;

public class SugarScapeView  extends SimulationView {

    SugarScape sim;

    public SugarScapeView(Model model) {
        super(model);
        sim = ((SugarScape) model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color oldColor = g.getColor();
        g.setColor(Color.GRAY);

        for (Agent agent : Simulation.agents) {
            g.setColor(Color.GREEN);
            g.fillOval(agent.xc, agent.yc, ((Ant)agent).fitness, ((Ant)agent).fitness);
        }

        for (Point point : sim.sugarPods) {
            g.setColor(Color.RED);
            g.fillOval(point.xc, point.yc, 3, 3);
        }

        g.setColor(oldColor);

    }

}
