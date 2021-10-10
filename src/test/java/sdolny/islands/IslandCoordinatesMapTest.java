package sdolny.islands;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class IslandCoordinatesMapTest {
    @Test
    public void should_Correctly_Associate_Coordinate() {
        var map = new IslandCoordinatesMap();

        Island firstIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(10, 10), firstIsland);
        map.associateCoordinateWithIsland(new Coordinate(11, 10), firstIsland);

        assertThat(map.numberOfIslands()).isEqualTo(1);

        Island secondIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(20, 20), secondIsland);

        assertThat(map.numberOfIslands()).isEqualTo(2);
    }

    @Test
    public void should_Find_Adjacent_Islands_Correctly() {
        var map = new IslandCoordinatesMap();

        Island firstIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(10, 10), firstIsland);
        map.associateCoordinateWithIsland(new Coordinate(11, 10), firstIsland);

        Island secondIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(10, 12), secondIsland);
        map.associateCoordinateWithIsland(new Coordinate(11, 12), secondIsland);

        var adjacentIslands = map.findAdjacentIslands(new Coordinate(10, 11));

        assertThat(adjacentIslands).contains(firstIsland, secondIsland);
    }

    @Test
    public void should_Join_Islands() {
        var map = new IslandCoordinatesMap();

        Island firstIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(10, 10), firstIsland);
        map.associateCoordinateWithIsland(new Coordinate(11, 10), firstIsland);

        Island secondIsland = map.createNewIsland();
        map.associateCoordinateWithIsland(new Coordinate(10, 12), secondIsland);
        map.associateCoordinateWithIsland(new Coordinate(11, 12), secondIsland);

        Island resultIsland = map.joinIslands(Set.of(firstIsland, secondIsland));

        assertThat(resultIsland).isNotNull();
        assertThat(map.numberOfIslands()).isEqualTo(1);
    }
}
