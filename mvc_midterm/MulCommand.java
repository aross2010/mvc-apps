package mvc_midterm;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class MulCommand extends Command{

    public MulCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {

        // prompt for user input
        String input = Utilities.ask("Enter a number:");
        Double value = Double.parseDouble(input);

        ((Midterm) model).mul(value);
    }

}
