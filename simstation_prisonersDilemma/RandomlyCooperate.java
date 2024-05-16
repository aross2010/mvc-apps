package simstation_prisonersDilemma;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy{

    public RandomlyCooperate(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public boolean cooperate() {
        int randomNum = Utilities.rng.nextInt(2);
        return randomNum == 0;
    }
}