package sdolny.islands;

import java.util.*;
import java.util.stream.Collectors;

public class IslandCoordinatesMap {
    private final HashMap<Coordinate, Island> islandsMap = new HashMap<>();
    private final HashMap<Island, Set<Coordinate>> islandToCoordinateMap = new HashMap<>();

    private int lastIslandNumber = 1;

    public Island createNewIsland() {
        return new Island(lastIslandNumber++);
    }

    public void associateCoordinateWithIsland(Coordinate coordinate, Island island) {
        removeAssociationIfExists(coordinate);
        insertNewAssociation(coordinate, island);
    }

    private void removeAssociationIfExists(Coordinate coordinate) {
        if(islandsMap.containsKey(coordinate)) {
            Island island = islandsMap.get(coordinate);
            islandToCoordinateMap.get(island).remove(coordinate);
            removeIslandIfEmpty(island);
        }
    }

    private void removeIslandIfEmpty(Island island) {
        islandToCoordinateMap.computeIfPresent(island, (key, coordinates) -> coordinates.isEmpty() ? null : coordinates);
    }

    private void insertNewAssociation(Coordinate coordinate, Island island) {
        islandToCoordinateMap.putIfAbsent(island, new HashSet<>());
        islandToCoordinateMap.get(island).add(coordinate);

        islandsMap.put(coordinate, island);
    }

    public Island joinIslands(Set<Island> islands) {
        // Find island that will be used as result of joining
        Island selectedIsland = islands.stream().findFirst().get();

        // Walk through all other islands and associate its coordinates with the selected island
        islands.stream()
                .filter(island -> !island.equals(selectedIsland))
                .forEach(island -> moveCoordinatesToIsland(island, selectedIsland));

        return selectedIsland;
    }

    private void moveCoordinatesToIsland(Island inputIsland, Island outputIsland) {
        Set<Coordinate> inputIslandCoordinates = new HashSet<>(islandToCoordinateMap.get(inputIsland));
        inputIslandCoordinates.forEach(coordinate -> associateCoordinateWithIsland(coordinate, outputIsland));
    }

    public Set<Island> findAdjacentIslands(Coordinate coordinate) {
        Coordinate[] adjacentCoordinates = new Coordinate[] {
                coordinate.up(),
                coordinate.down(),
                coordinate.left(),
                coordinate.right(),

                coordinate.up().left(),
                coordinate.up().right(),

                coordinate.down().left(),
                coordinate.down().right()
        };

        return Arrays.stream(adjacentCoordinates)
                .map(islandsMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public int numberOfIslands() {
        return islandToCoordinateMap.size();
    }
}
