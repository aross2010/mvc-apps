package simstation_sugarScape;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;
import simstation_flocking.FlockingSimulation;

public class SugarScapeFactory extends SimStationFactory {

    @Override
    public Model makeModel() {
        return new SugarScape();
    }

    @Override
    public View makeView(Model model) {
        return new SugarScapeView(model);
    }

    @Override
    public String getTitle() {
        return "SugarScape";
    }

}
