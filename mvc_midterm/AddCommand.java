package mvc_midterm;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class AddCommand extends Command {

    public AddCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {

        // prompt for user input
        String input = Utilities.ask("Enter a number:");
        Double value = Double.parseDouble(input);

        ((Midterm) model).add(value);
    }
}
