package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Start")) return new StartCommand(model);
        else if (type.equals("Suspend")) return new SuspendCommand(model);
        else if (type.equals("Resume")) return new ResumeCommand(model);
        else if (type.equals("Stop")) return new StopCommand(model);
        else if (type.equals("Stats")) return new StatsCommand(model);
        else return null;
    }

    @Override
    public String getTitle() {
        // Override in each customization
        return null;
    }

    @Override
    public String[] getHelp() {
        // Override in each customization
        return new String[] {"Press start to start the simulation", "Press suspend to pause the simulation", "Press resume to resume the simulation", "Press stop to end the simulation", "" +
                "Press stats to view statistics about the simulation"};
    }

    @Override
    public String about() {
        // Override in each customization
        return "CS151 assignment by Minh Phong Do, Alex Ross, and Yossef Eini. 2024";
    }
}
