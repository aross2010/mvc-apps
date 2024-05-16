package smartbox;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class ContainerFactory implements AppFactory {
    @Override
    public View makeView(Model m) {
        return new ContainerView(m);
    }

    @Override
    public Model makeModel() {
        return new Container();
    }

    @Override
    public String getTitle() {
        return "SmartBox";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Add to add a new component. Rem to remove a component. Run to execute most recently added component."};
    }

    @Override
    public String about() {
        return "SmartBox Calculator. CS 151 by Alex Ross.";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Add", "Rem", "Run"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Add")) return new AddCommand(model);
        else if (type.equals("Rem")) return new RemCommand(model);
        else if (type.equals("Run")) return new RunCommand(model);
        else return null;
    }
}
