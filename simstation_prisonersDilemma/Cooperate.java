package simstation_prisonersDilemma;

public class Cooperate extends Strategy{
    public Cooperate(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public boolean cooperate() {
        return true;
    }
}
