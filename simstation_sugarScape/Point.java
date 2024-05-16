package simstation_sugarScape;

public class Point {

    protected int xc;
    protected int yc;

    public Point(int xc, int yc) {
        this.xc = xc;
        this.yc = yc;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + xc;
        result = prime * result + yc;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        if (xc != other.xc) return false;
        if (yc != other.yc) return false;
        return true;
    }
}

