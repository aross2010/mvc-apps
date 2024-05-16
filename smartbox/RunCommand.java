package smartbox;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class RunCommand extends Command {

    public RunCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        String componentName = Utilities.ask("Component Name?");
        ((Container) model).launch(componentName);
    }
}
