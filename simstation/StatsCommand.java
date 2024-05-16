package simstation;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;


public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        // TODO - Override in customization
        Utilities.inform(((Simulation)model).getStats());
    }

}
