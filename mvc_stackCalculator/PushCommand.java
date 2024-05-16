package mvc_stackCalculator;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class PushCommand extends Command {

    public PushCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {

        // prompt for user input
        String input = Utilities.ask("Insert a value to be pushed to the stack");
        Double value = Double.parseDouble(input);

        ((StackCalc) model).push(value);
    }
}
