package mvc_clockSimulator;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class ClockPanel extends AppPanel {
    private JLabel display;
    public ClockPanel(AppFactory factory) {
        super(factory);
        JButton button = new JButton("Tick");
        button.addActionListener(this);
        controls.add(button);
        display = new JLabel("Hour: " + ((Clock)model).getHour());
        controls.add(display);
    }

    public void update() {
        display.setText(("Clock: " + ((Clock)model).getHour()));
    }

    public static void main(String[] args) {
        AppPanel panel = new ClockPanel(new ClockFactory());
        panel.display();
    }
}
