package sdolny.islands;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

public class FileMapLoaderTest {
    @Test
    public void should_Throw_Error_On_Improper_File_Format() {
        assertThatThrownBy(() -> {
            File improperMapFile = ResourceFileFinder.find("improper_map.txt");

            FileMapLoader loader = new FileMapLoader();
            loader.loadIslandFieldsFromFile(improperMapFile, coordinate -> {});
        }).isInstanceOf(MapLoaderException.class);
    }

    @Test
    public void should_Load_Map_With_Islands() throws URISyntaxException, IOException {
        File mapFile = ResourceFileFinder.find("4_islands_map.txt");

        AtomicInteger fieldsCounter = new AtomicInteger();

        FileMapLoader loader = new FileMapLoader();
        loader.loadIslandFieldsFromFile(mapFile, coordinate -> fieldsCounter.incrementAndGet());

        assertThat(fieldsCounter.get()).isEqualTo(17);

    }
}
