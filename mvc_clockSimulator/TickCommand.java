package mvc_clockSimulator;

import mvc.Command;
import mvc.Model;

public class TickCommand extends Command {

    public TickCommand(Model model) {super(model);}
    public void execute() {
        Clock clock = (Clock)model;
        clock.incHour();
    }

}
