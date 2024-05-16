package simstation_prisonersDilemma;

import mvc.AppPanel;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PrisonerSimulation extends Simulation {
    private final int INITIALPOPULATION = 40;
    private int sumPopulation;
    private int sumFitCoop;
    private int sumFitCheat;
    private int sumFitRanCoop;
    private int sumFitTit4Tat;

    public PrisonerSimulation(){
        sumFitCoop = 0;
        sumFitCheat = 0;
        sumFitRanCoop = 0;
        sumFitTit4Tat = 0;
    }

    public void updateSumFitCoop(int amt){
        sumFitCoop += amt;
    }

    public void updateSumFitCheat(int amt){
        sumFitCheat += amt;
    }

    public void updateSumFitRanCoop(int amt){
        sumFitRanCoop += amt;
    }

    public void updateSumFitTit4Tat(int amt){
        sumFitTit4Tat += amt;
    }

    public void populate() {
        int quarter = INITIALPOPULATION / 4;
        for (int i = 0; i < quarter; i ++) {
            Prisoner prison = new Prisoner();
            prison.setStrategy(new Cheat(prison));
            addAgent(prison);
            sumPopulation++;
        }
        for (int i = 0; i < quarter; i ++) {
            Prisoner prison = new Prisoner();
            prison.setStrategy(new Cooperate(prison));
            addAgent(prison);
            sumPopulation++;
        }
        for (int i = 0; i < quarter; i ++) {
            Prisoner prison = new Prisoner();
            prison.setStrategy(new RandomlyCooperate(prison));
            addAgent(prison);
            sumPopulation++;
        }
        for (int i = 0; i < quarter; i ++) {
            Prisoner prison = new Prisoner();
            prison.setStrategy(new Tit4Tat(prison));
            addAgent(prison);
            sumPopulation++;
        }
    }

    @Override
    public void start() {
        sumFitCoop = 0;
        sumFitCheat = 0;
        sumFitRanCoop = 0;
        sumFitTit4Tat = 0;
        super.start();
    }
    public void updateWorld(Prisoner p) {
        if (p.getStrategy() instanceof Cooperate) {
            this.updateSumFitCoop(p.getFitness());
        } else if (p.getStrategy() instanceof Cheat) {
            this.updateSumFitCheat(p.getFitness());
        } else if (p.getStrategy() instanceof RandomlyCooperate) {
            this.updateSumFitRanCoop(p.getFitness());
        } else if (p.getStrategy() instanceof Tit4Tat) {
            this.updateSumFitTit4Tat(p.getFitness());
        } else {
            throw new IllegalStateException("Unexpected value: " + p.getStrategy());
        }
    }


    @Override
    public String[] getStats() {
        int quarter = sumPopulation / 4;
        String[] stats = {"Cooperate avg fitness: " + String.valueOf(sumFitCoop / quarter),
                "Cheat avg fitness: " + String.valueOf(sumFitCheat / quarter),
                "RandomlyCooperate avg fitness: " + String.valueOf(sumFitRanCoop / quarter),
                "Tit4Tat avg fitness: " + String.valueOf(sumFitTit4Tat / quarter)};
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
