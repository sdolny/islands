package sdolny.islands;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

class ResourceFileFinder {
    public static File find(String filename) throws URISyntaxException {
        URL resource = ResourceFileFinder.class.getClassLoader().getResource(filename);
        return new File(resource.toURI());
    }
}
