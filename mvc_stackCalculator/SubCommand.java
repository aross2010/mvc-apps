package mvc_stackCalculator;

import mvc.Command;
import mvc.Model;

public class SubCommand extends Command {

    public SubCommand(Model model) {
        super(model);
    }


    @Override
    public void execute() throws Exception {
        ((StackCalc) model).sub();
    }
}
