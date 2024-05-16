package mvc_midterm;

import mvc.Model;
import mvc.View;

import javax.swing.*;

public class MidtermView extends View {
    JLabel label = new JLabel("Accumulator");
    JTextField accumulatorField = new JTextField("" + ((Midterm) model).accumulator, 10);

    public MidtermView(Model model) {
        super(model);
        // TODO - Display all elements here
        add(accumulatorField);
        add(label);


    }

    @Override
    public void update() {
        // TODO - updated to newest form of all elements
        accumulatorField.setText("" + ((Midterm) model).accumulator);
        repaint();
    }

}
