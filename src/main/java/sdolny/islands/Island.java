package sdolny.islands;

import java.util.Objects;

public class Island {
    private final Integer id;

    Island(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Island island = (Island) o;
        return Objects.equals(id, island.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
