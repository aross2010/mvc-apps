package mvc_stackCalculator;

import mvc.Model;
import mvc.Utilities;

import java.util.*;

// main class of package, contains all data and performs all operations on data
public class StackCalc extends Model {

    // the main stack of the program
    protected Stack<Double> stack = new Stack<>();

    // check if there are enough elements in the stack to perform an operation
    private boolean isValidOperation() {
        if (stack.size() < 2) {
            Utilities.error("Not enough elements on stack to perform operation.");
            return false;
        }
        return true;
    }

    // perform subtraction on the top two elements in stack
    protected void sub() {
        if (!isValidOperation()) return;

        double operand1 = stack.pop();
        double operand2 = stack.pop();

        double result = operand1 - operand2;

        // push result to main stack
        stack.push(result);

        // changed notifies subscribers
        changed();
    }

    // perform an addition on the top two elements in stack
    protected void add() {
      if (!isValidOperation()) return;

        double operand1 = stack.pop();
        double operand2 = stack.pop();

        double result = operand1 + operand2;

        // push result to main stack
        stack.push(result);

        // changed notifies subscribers
        changed();
    }

    // perform a multiplication on the top two elements in stack
    protected void mul() {
        if (!isValidOperation()) return;

        double operand1 = stack.pop();
        double operand2 = stack.pop();

        double result = operand1 * operand2;

        // push result to main stack
        stack.push(result);

        // changed notifies subscribers
        changed();
    }

    // push a new element to main stack
    protected void push(Double value) {

        // push user input to main stack
        stack.push(value);

        // changed notifies subscribers
        changed();

    }

    // pop element from main stack
    protected void pop() {
        if (stack.isEmpty()) {
            Utilities.error("No elements on stack to perform pop operation.");
            return;
        }

        stack.pop();

        // changed notifies subscribers
        changed();

    }



}
