package mvc_stackCalculator;


import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.Stack;

import javax.swing.*;

// the display component to the app
public class StackView extends View {
    // keep a pointer to the main stack to retrieve values to display
    private Stack<Double> stack;

    // Jlist to display a list of the double values in the stack
    private JList<String> stackOperands;
    private DefaultListModel<String> listModel;



    public StackView(Model model) {
        // construct a View object
        super(model);

        // point stack to the main stack
        stack = ((StackCalc) model).stack;

        // create and display the jList

        listModel = new DefaultListModel<>();

        for (int i = stack.size()-1; i != -1 && !stack.isEmpty(); i--) {
            listModel.addElement("" + stack.get(i));
        }

        stackOperands = new JList<>(listModel);
        setLayout(new BorderLayout());
        add(stackOperands);

    }

    @Override
    public void update() {

        // repaint not working, so clear the list and re-add all elements to get newest version from updates
        listModel.clear();
        for (int i = stack.size()-1; i != -1 && !stack.isEmpty() ; i--) {
            listModel.addElement("" + stack.get(i));
        }


    }


}
