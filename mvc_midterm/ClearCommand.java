package mvc_midterm;

import mvc.Command;
import mvc.Model;

public class ClearCommand extends Command {

    public ClearCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {

        ((Midterm) model).clear();
    }
}
