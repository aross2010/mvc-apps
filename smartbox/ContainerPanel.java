package smartbox;
import java.awt.GridLayout;

import javax.swing.*;
import mvc.*;

public class ContainerPanel extends AppPanel {
    java.awt.List components;

    public ContainerPanel(AppFactory factory) {

        // construct an AppPanel
        super(factory);

        controls.setLayout(new GridLayout(3,1));

        JButton push = new JButton("Add");
        addControl(push);

        JButton pop = new JButton("Rem");
        addControl(pop);

        JButton add = new JButton("Run");
        addControl(add);

    }

    // this override needed to re-initialize component fields table:
    public void setModel(Model m) {
        super.setModel(m);
        ((Container) m).initContainer(); // restore fields of components
    }

    private void addControl(JButton control) {
        // add actionLister to panel, panel implements action listener
        control.addActionListener(this);

        JPanel holder = new JPanel();
        holder.add(control);
        // add control to controls JPanel
        controls.add(holder);
    }

    public static void main(String[] args) {
        AppPanel panel = new ContainerPanel(new ContainerFactory());
        panel.display();
    }
}