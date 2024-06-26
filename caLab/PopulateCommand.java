package caLab;

import mvc.Command;
import mvc.Model;

public class PopulateCommand extends Command {
    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        ((Grid) model).repopulate(true);
    }
}
