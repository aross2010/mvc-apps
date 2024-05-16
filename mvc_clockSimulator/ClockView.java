package mvc_clockSimulator;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class ClockView extends View {
    public static int VIEW_SIZE = 250;
    private int originXC;
    private int originYC;

    public ClockView(Model m) {
        super(m);
        originXC = VIEW_SIZE/2;
        originYC = VIEW_SIZE/2;
    }

    public void paintComponent(Graphics gc) {
        Clock clock = (Clock)model;
        int hour = clock.getHour();
        // if hour = 3, then angle = 0 radians
        double angle = Math.PI/2 - hour * Math.PI/6;
        Point end = new Point(Math.cos(angle), Math.sin(angle)); // see below for Point
        Point end2 = end.transform(VIEW_SIZE);
        double handXC = end2.getXc();
        double handYC = end2.getYc();
        gc.drawLine(originXC, originYC,(int)handXC, (int)handYC);
    }
}
