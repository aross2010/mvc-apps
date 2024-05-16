package simstation_prisonersDilemma;
import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Prisoner extends Agent {
    private int fitness;
    private boolean partnercheated;
    private Strategy strategy;

    public Prisoner(){
        super();
        fitness = 0;
        heading = Heading.random();
        partnercheated = false;
    }

    public boolean cooperate(){
        return strategy.cooperate();
    }

    public void update(){
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        PrisonerSimulation myWorld = ((PrisonerSimulation)world);
        Prisoner partner = (Prisoner)myWorld.getNeighbor(this, 10);
        if (partner != null && partner != this){
            playGame(partner);
            myWorld.updateWorld(this);
            myWorld.updateWorld(partner);
        }
    }

    public void updateFitness(int amt){
        fitness += amt;
    }
    public int getFitness(){
        return this.fitness;
    }

    public void setStrategy(Strategy strat){
        this.strategy = strat;
    }

    public Strategy getStrategy(){
        return this.strategy;
    }

    public boolean getCheated(){
        return this.partnercheated;
    }

    public void playGame(Prisoner partner){
        if (partner.cooperate() && this.cooperate()){
            this.updateFitness(3);
            partner.updateFitness(3);
            this.partnercheated = false;
            partner.partnercheated = false;
        }

        else if (!partner.cooperate() && this.cooperate()){
            partner.updateFitness(5);
            this.partnercheated = true;
            partner.partnercheated = false;
        }

        else if (partner.cooperate() && !this.cooperate()){
            this.updateFitness(5);
            this.partnercheated = false;
            partner.partnercheated = true;
        }

        else{
            this.updateFitness(1);
            partner.updateFitness(1);
            this.partnercheated = true;
            partner.partnercheated = true;
        }
        System.out.println(this.getStrategy() + "  " + partner.getStrategy() + " " + this.getFitness() + " " + partner.getFitness());
    }
}