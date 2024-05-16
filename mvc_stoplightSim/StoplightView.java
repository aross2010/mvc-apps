package mvc_stoplightSim;

import tools_old.Subscriber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StoplightView extends JPanel implements Subscriber {
    private Stoplight light;

    public StoplightView(Stoplight light) {
        this.light = light;
        light.subscribe(this);
        setSize(500, 1000);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        setBorder(blackline);
        setBackground(Color.RED);
    }

    public void update() {
        repaint();
    }

    public void setLight(Stoplight newLight) {
        light.unsubscribe(this);
        light = newLight;
        light.subscribe(this);
        repaint();
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        StoplightComponent lightComponent = new StoplightComponent(light);
        lightComponent.paintComponent(gc);
        gc.setColor(oldColor);
    }
}
