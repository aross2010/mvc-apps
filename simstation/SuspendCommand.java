package simstation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {

    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        // TODO
        Simulation a = (Simulation) model;
        a.suspend();
    }
}
