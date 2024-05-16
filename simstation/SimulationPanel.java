package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {

    public SimulationPanel(AppFactory factory) {
        super(factory);
        controls.setLayout(new GridLayout(5, 1));

        JButton start = new JButton("Start");
        addControl(start);

        JButton suspend = new JButton("Suspend");
        addControl(suspend);

        JButton resume = new JButton("Resume");
        addControl(resume);

        JButton stop = new JButton("Stop");
        addControl(stop);

        JButton stats = new JButton("Stats");
        addControl(stats);
    }

    private void addControl(JButton control){
        control.addActionListener(this);
        JPanel holder = new JPanel();
        holder.add(control);
        controls.add(holder);
    }

}
