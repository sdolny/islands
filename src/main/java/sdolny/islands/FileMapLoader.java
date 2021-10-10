package sdolny.islands;

import java.io.*;
import java.util.function.Consumer;

public class FileMapLoader {
    private static final char ISLAND_FIELD = '1';

    public void loadIslandFieldsFromFile(File file, Consumer<Coordinate> islandCoordinatesConsumer) throws IOException {
        System.out.printf("Processing file: %s\n", file.getName());

        try(var reader = new BufferedReader(new FileReader(file))) {
            int y = 0;

            String line;
            while((line = reader.readLine()) != null) {
                if(!validateLineFormat(line)) {
                    throw new MapLoaderException(String.format("Line %d has invalid format", y));
                }

                generateIslandFieldsFromLine(y, line, islandCoordinatesConsumer);

                y += 1;
            }
        }

        System.out.println("Processing finished successfully");
    }

    private boolean validateLineFormat(String line) {
        return line.matches("[10]+");
    }

    private void generateIslandFieldsFromLine(int y, String line, Consumer<Coordinate> islandCoordinatesCollection) {
        for(int x=0; x<line.length(); x++) {
            if(line.charAt(x) == ISLAND_FIELD) {
                islandCoordinatesCollection.accept(new Coordinate(x, y));
            }
        }
    }
}
