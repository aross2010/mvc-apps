package mvc_stackCalculator;

import mvc.Command;
import mvc.Model;

public class PopCommand extends Command {

    public PopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        ((StackCalc) model).pop();
    }
}
