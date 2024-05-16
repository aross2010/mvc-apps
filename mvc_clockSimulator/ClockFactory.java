package mvc_clockSimulator;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class ClockFactory implements AppFactory {

    public Model makeModel() { return new Clock(); }
    public String[] getEditCommands() { return new String[] { "Tick" }; }
    public View makeView(Model m) {
        return new ClockView(m);
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        Command cmmd = null;
        if(type.equals("Tick")) { cmmd = new TickCommand(model); }
        return cmmd;
    }

    public String getTitle() { return "Clock Simulator"; }
    public String[] getHelp() { return new String[] { "Tick to advance clock one hour" }; }
    public String about() {
        return "Clock Simulator version 1.0. Copyright 2020 by Cyberdellic Designs";
    }
}
