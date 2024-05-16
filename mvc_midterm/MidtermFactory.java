package mvc_midterm;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class MidtermFactory implements AppFactory {
    @Override
    public View makeView(Model m) {
        return new MidtermView(m);
    }

    @Override
    public Model makeModel() {
        return new Midterm();
    }

    @Override
    public String getTitle() {
        return "Midterm";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Help is here."};
    }

    @Override
    public String about() {
        return "This is the midterm for CS 151.";
    }

    @Override
    public String[] getEditCommands() {
        // TODO - Place command strings here
        return new String[]{"Add", "Mul", "Clear"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // TODO - If (type.equals("___") return new ___Command(model);
        if (type.equals("Add")) return new AddCommand(model);
        else if (type.equals("Mul")) return new MulCommand(model);
        else if (type.equals("Clear")) return new ClearCommand(model);
        return null;
    }
}
