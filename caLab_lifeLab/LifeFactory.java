package caLab_lifeLab;

import caLab.GridFactory;
import mvc.Model;

public class LifeFactory extends GridFactory {

    public Model makeModel() {
       return new Society();
    }

}
