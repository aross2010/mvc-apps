package mvc_stackCalculator;

import mvc.Command;
import mvc.Model;

public class AddCommand extends Command{

    public AddCommand(Model model) {
        super(model);
    }


    @Override
    public void execute() throws Exception {
        ((StackCalc) model).add();
    }
}
