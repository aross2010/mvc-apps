package echo_math;

import echo.RequestHandler;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class MathHandler extends RequestHandler {

    public MathHandler(Socket s) {
        super(s);
    }

    public MathHandler() {
        super();
    }

    private String add(Queue<Double> operands) {

        Double sum = operands.poll();

        while (!operands.isEmpty()) sum += operands.poll();

        return sum.toString();
    }

    private String sub(Queue<Double> operands) {

        Double difference = operands.poll();

        while (!operands.isEmpty()) difference -= operands.poll();

        return difference.toString();
    }

    private String mul(Queue<Double> operands) {

        Double product = operands.poll();

        while (!operands.isEmpty()) product *= operands.poll();

        return product.toString();
    }


    private String div(Queue<Double> operands) {

        Double quotient = operands.poll();

        while (!operands.isEmpty()) quotient /= operands.poll();

        return quotient.toString();
    }


    @Override
    public String response(String request) {

        // split when one or more white space characters
        String[] cmmds = request.split("\\s+");
        Queue<Double> operands = new LinkedList<>();

        String operation = cmmds[0];

        if (operation == null) return "Must provide an operation.";

        try {
            for (int i = 1; i < cmmds.length; i++) operands.offer(Double.parseDouble(cmmds[i]));
        } catch (NumberFormatException ex) {
            return ex.getMessage();
        }


        if (operands.size() < 2) {
            return "Two operands required.";
        }

        if (operation.equalsIgnoreCase("add")) return add(operands);
        else if (operation.equalsIgnoreCase("sub")) return sub(operands);
        else if (operation.equalsIgnoreCase("mul")) return mul(operands);
        else if (operation.equalsIgnoreCase("div")) return div(operands);
        else return String.format("Operation: " + operation + " is not a valid operation. Add, Sub, Mul, Div, are all valid operations.");


    }

}
