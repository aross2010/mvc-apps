package simstation_plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    public static int INITIALINFECTED = 10; //chance of a plague agent to be initially infected
    public static int CONTAGIOUSVALUE = 30; // how contagious is the disease
    private final int NUM_AGENTS = 71;

    public void populate() {
        for (int i = 1; i < NUM_AGENTS; i++) {
            Plague plagueAgent = new Plague();
            addAgent(plagueAgent);
            if ((Utilities.rng.nextInt(100) + 1) <= INITIALINFECTED) plagueAgent.setInfected(true);
        }
    }
   public double percentInfected() {
      double hit = 0;
      double safe = 0;
      double percentHit = 0;
      for (Agent agent: agents) {
          Plague p = (Plague) agent;
          if (p.getInfected()) hit++;
          else safe ++;
          percentHit = (hit / (safe + hit)) * 100;
       }
       double adjustedPercentHit = Double.parseDouble(String.format("%.2f", percentHit)); // rounds it to 2 decimal points
       return adjustedPercentHit;
   }
    public String[] getStats() {
        String[] stats = {"agents = " + String.valueOf(agents.size()), "clock = " + String.valueOf(clock), "Infected = " + percentInfected() + "%"};
        return stats;
    }

    public static void main(String[] args) {
            AppPanel panel = new SimulationPanel(new PlagueFactory());
            panel.display();
    }
}