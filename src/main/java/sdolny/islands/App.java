package sdolny.islands;

import java.io.File;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        if(args.length < 1) {
            System.out.println("Missing map file. Please provide the file in arguments");
            return;
        }

        File mapFile = new File(args[0]);

        System.out.printf("Given file with map: %s\n", mapFile);

        // Calculate maps in that file
        IslandsCalculator calculator = new IslandsCalculator();
        FileMapLoader loader = new FileMapLoader();
        loader.loadIslandFieldsFromFile(mapFile, calculator);

        System.out.printf("Number of islands in the map: %d\n", calculator.getNumberOfIslands());
    }
}
