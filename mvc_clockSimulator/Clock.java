package mvc_clockSimulator;

import mvc.Model;

public class Clock extends Model {
    private int hour = 0;
    public void incHour() {
        hour = (hour + 1) % 12;
        changed();
    }
    public int getHour() { return hour; }
}
