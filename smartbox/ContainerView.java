package smartbox;
import mvc.*;

import java.util.Collection;


public class ContainerView extends View {

    private java.awt.List components;

    public ContainerView(Model model) {
        super(model);
        components = new java.awt.List(10);
        this.add(components);

        Collection<Component> componentList = ((Container) model).getComponents();

        for (Component comp: componentList) {
            components.add(comp.toString());
        }

    }

    @Override
    public void update() {
        components.removeAll();
        Collection<Component> componentList = ((Container) model).getComponents();
        for (Component comp: componentList) {
            components.add(comp.toString());
        }
    }

}

