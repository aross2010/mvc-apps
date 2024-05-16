package mvc_stackCalculator;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class StackFactory implements AppFactory {

    // creates main app view
    @Override
    public View makeView(Model m) {
        return new StackView(m);
    }

    // creates main model
    @Override
    public Model makeModel() {
        return new StackCalc();
    }

    @Override
    public String getTitle() {
        return "Stack Calculator";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Click push to add a new element to the stack.", "Click Pop to remove an element from stack", "Click add to replace the top two elements in the stack with its sum.", "Click sub to replace the top two elements in the stack with their difference."};
    }

    @Override
    public String about() {
        return "This is a stack calculator to prep for midterm.";
    }

    // all the edit commands in top menu
    @Override
    public String[] getEditCommands() {
        return new String[]{"Push", "Pop", "Add", "Sub"};
    }

    // perform actions from the edit menu
    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // this will be where if type.equals("Push") return PushCommand -> example of commands as objects
        if (type.equals("Push")) return new PushCommand(model);
        else if (type.equals("Pop")) return new PopCommand(model);
        else if (type.equals("Add")) return new AddCommand(model);
        else if (type.equals("Sub")) return new SubCommand(model);
        else if (type.equals("Mul")) return new MulCommand(model);
        return null;
    }
}
