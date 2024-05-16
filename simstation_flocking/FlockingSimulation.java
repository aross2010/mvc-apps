package simstation_flocking;

import mvc.AppPanel;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class FlockingSimulation extends Simulation {
    private final int NUM_OF_BIRDS = 100;

    @Override
    public void populate() {
        for(int i = 0; i < NUM_OF_BIRDS; i++)
            addAgent(new Bird());
    }

    @Override
    public String[] getStats(){
        int[] stats = new int[Bird.MAX_SPEED];
        for (Agent agent: agents) {
            int speed = ((Bird)agent).speed;
            switch(speed) {
                case 1: {
                    stats[0]++;
                    break;
                }
                case 2: {
                    stats[1]++;
                    break;
                }
                case 3: {
                    stats[2]++;
                    break;
                }
                case 4: {
                    stats[3]++;
                    break;
                }
                case 5: {
                    stats[4]++;
                    break;
                }
            }
        }

        String[] statsMessage = new String[Bird.MAX_SPEED];
        
        for (int i = 0; i < statsMessage.length; i++) {
            statsMessage[i] = String.format("# of birds at Speed %d: %d", i+1, stats[i]);
        }

        return statsMessage;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }


}
