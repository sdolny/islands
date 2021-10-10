package sdolny.islands;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoordinateTest {
    @Test
    public void shouldCalculateDirectionsCorrectly() {
        var coord = new Coordinate(10, 10);

        assertThat(coord.up()).isEqualTo(new Coordinate(10, 9));
        assertThat(coord.down()).isEqualTo(new Coordinate(10, 11));
        assertThat(coord.left()).isEqualTo(new Coordinate(9, 10));
        assertThat(coord.right()).isEqualTo(new Coordinate(11, 10));
    }
}
