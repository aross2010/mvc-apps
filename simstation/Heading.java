package simstation;

import mvc.Utilities;

public enum Heading {
    NORTH, EAST, SOUTH, WEST;


    public static Heading parse(String heading) {
        if (heading.equalsIgnoreCase("north")) return NORTH;
        else if (heading.equalsIgnoreCase("east")) return EAST;
        else if (heading.equalsIgnoreCase("south")) return SOUTH;
        else if (heading.equalsIgnoreCase("west")) return WEST;
        else return null;
    }

    public static Heading random() {
        int randomNum = Utilities.rng.nextInt(4) + 1;

        if (randomNum == 1) return NORTH;
        else if (randomNum == 2) return WEST;
        else if (randomNum == 3) return SOUTH;
        else if (randomNum == 4) return EAST;
        else return null;
    }


}
