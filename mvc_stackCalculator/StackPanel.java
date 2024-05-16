package mvc_stackCalculator;

import mvc.AppPanel;
import mvc.AppFactory;

import javax.swing.*;
import java.awt.*;

// basically the control panel for the app
public class StackPanel extends AppPanel {

    public StackPanel(AppFactory factory) {
        // construct an AppPanel
        super(factory);

        controls.setLayout(new GridLayout(1, 4));


        // create identical functioning buttons as those in the edit menu
        // except there are displayed inside the main view

        JButton push = new JButton("Push");
        addControl(push);

        JButton pop = new JButton("Pop");
        addControl(pop);

        JButton add = new JButton("Add");
        addControl(add);

        JButton sub = new JButton("Sub");
        addControl(sub);

        JButton mul = new JButton("Mul");
        addControl(mul);


    }

    private void addControl(JButton control){
        // add actionLister to panel, panel implements action listener
        control.addActionListener(this);

        JPanel holder = new JPanel();
        holder.add(control);
        // add control to controls JPanel
        controls.add(holder);
    }

    // use factory to create an app panel
    public static void main(String[] args) {
        AppFactory factory = new StackFactory();
        StackPanel panel = new StackPanel(factory);
        panel.display();

    }

}
