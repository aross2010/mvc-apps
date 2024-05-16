package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class SimulationView extends View {

    public SimulationView(Model model) {
        super(model);
        setBackground(Color.GRAY);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color oldColor = g.getColor();

        g.setColor(Color.GRAY);

        // turn off if overriden
//        for (Agent agent : Simulation.agents){
//            g.setColor(agent.color);
//            g.fillOval(agent.xc, agent.yc, 5,5);
//        }

        g.setColor(oldColor);

    }


}
