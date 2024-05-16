package mvc_midterm;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class MidtermPanel extends AppPanel {

    public MidtermPanel(AppFactory factory) {

        super(factory);

        controls.setLayout(new GridLayout(1, 4));

        JButton add = new JButton("Add");
        addControl(add);

        JButton mul = new JButton("Mul");
        addControl(mul);

        JButton clear = new JButton("Clear");
        addControl(clear);

//        controls.setBackground(Color.RED);


    }

    private void addControl(JButton control){
        // add actionLister to panel, panel implements action listener
        control.addActionListener(this);

        JPanel holder = new JPanel();
        holder.add(control);
        // add control to controls JPanel
        controls.add(holder);
    }

    public static void main(String[] args) {
        AppFactory factory = new MidtermFactory();
        MidtermPanel panel = new MidtermPanel(factory);
        panel.display();
    }

}
