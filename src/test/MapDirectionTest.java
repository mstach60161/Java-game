package test;

import main.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    void next() {
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.NORTH.next(), MapDirection.EAST);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH);

        assertNotEquals(MapDirection.EAST.next(), MapDirection.EAST);
        assertNotEquals(MapDirection.SOUTH.next(), MapDirection.NORTH);
    }



    @Test
    void previous() {
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.previous(), MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH);

        assertNotEquals(MapDirection.SOUTH.previous(), MapDirection.WEST);
        assertNotEquals(MapDirection.NORTH.previous(), MapDirection.NORTH);
    }

}
