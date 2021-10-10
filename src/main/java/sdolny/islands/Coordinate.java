package sdolny.islands;

import java.util.Objects;

public class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate up() {
        return new Coordinate(x, y-1);
    }

    public Coordinate down() {
        return new Coordinate(x, y+1);
    }

    public Coordinate left() {
        return new Coordinate(x-1, y);
    }

    public Coordinate right() {
        return new Coordinate(x+1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
