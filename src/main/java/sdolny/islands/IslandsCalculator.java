package sdolny.islands;

import java.util.Set;
import java.util.function.Consumer;

public class IslandsCalculator implements Consumer<Coordinate> {
    private final IslandCoordinatesMap islandCoordinatesMap = new IslandCoordinatesMap();

    @Override
    public void accept(Coordinate coordinate) {
        Set<Island> adjacentIslands = islandCoordinatesMap.findAdjacentIslands(coordinate);
        Island targetIsland = adjacentIslands.isEmpty() ? islandCoordinatesMap.createNewIsland() : islandCoordinatesMap.joinIslands(adjacentIslands);
        islandCoordinatesMap.associateCoordinateWithIsland(coordinate, targetIsland);
    }

    public int getNumberOfIslands() {
        return islandCoordinatesMap.numberOfIslands();
    }
}
