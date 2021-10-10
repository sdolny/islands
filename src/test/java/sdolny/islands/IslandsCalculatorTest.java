package sdolny.islands;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class IslandsCalculatorTest
{
    @ParameterizedTest
    @CsvSource({
            "4_islands_map.txt, 4",
            "1_big_island_map.txt, 1",
            "400_islands_map.txt, 400",
            "25_small_islands_map.txt, 25",
    })
    public void shouldLoadMapFromFile(String mapFileName, Integer numberOfIslandsOnMap) throws URISyntaxException, IOException {
        File fileFromResource = ResourceFileFinder.find(mapFileName);

        IslandsCalculator islandsCalculator = new IslandsCalculator();

        FileMapLoader fileMapLoader = new FileMapLoader();
        fileMapLoader.loadIslandFieldsFromFile(fileFromResource, islandsCalculator);

        assertThat(islandsCalculator.getNumberOfIslands()).isEqualTo(numberOfIslandsOnMap);
    }
}
