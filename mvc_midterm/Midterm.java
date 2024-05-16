package mvc_midterm;

import mvc.Model;


public class Midterm extends Model {

    Double accumulator = 0.0;

    // TODO - Add all business logic here (commands, main variables)


    protected void add(Double value) {
        accumulator += value;
        changed();
    }

    protected void mul(Double value) {
        accumulator *= value;
        changed();
    }

    protected void clear() {
        accumulator = 0.0;
        changed();
    }

//    public static void main(String[] args) {
//        AppFactory factory = new MidtermFactory();
//        MidtermPanel panel = new MidtermPanel(factory);
//        panel.display();
//    }
}
