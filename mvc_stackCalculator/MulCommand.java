package mvc_stackCalculator;

import mvc.Command;
import mvc.Model;

public class MulCommand extends Command {

    public MulCommand(Model model) {
        super(model);
    }


    @Override
    public void execute() throws Exception {
        ((StackCalc) model).mul();
    }

}
