package test;

import main.Vector2D;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {
    @Test
    void testToString() {
        Vector2D vector2D = new Vector2D(2, 1);
        assertEquals(vector2D.toString(), "(2,1)");
    }

    @Test
    void precedes() {
        Vector2D vector2D = new Vector2D(0, 0);
        assertTrue(vector2D.precedes(new Vector2D(3, 1)));
    }

    @Test
    void follows() {
        Vector2D vector2D = new Vector2D(2, 2);
        assertTrue(vector2D.follows(new Vector2D(1, 1)));
    }

    @Test
    void upperRight() {
        Vector2D vector2D = new Vector2D(2, 1);
        Vector2D vector2D2 = new Vector2D(12, -4);
        assertEquals(vector2D.upperRight(vector2D2).toString(), "(12,1)");

    }

    @Test
    void lowerLeft() {
        Vector2D vector2D = new Vector2D(2, 1);
        Vector2D vector2D2 = new Vector2D(12, -4);
        assertEquals(vector2D.lowerLeft(vector2D2).toString(), "(2,-4)");
    }

    @Test
    void add() {
        Vector2D vector2D = new Vector2D(2, 1);
        Vector2D vector2D2 = new Vector2D(12, -4);
        assertEquals(vector2D.add(vector2D2).toString(), "(14,-3)");
    }

    @Test
    void subtract() {
        Vector2D vector2D = new Vector2D(2, 1);
        Vector2D vector2D2 = new Vector2D(12, -4);
        assertEquals(vector2D.subtract(vector2D2).toString(), "(-10,5)");

    }

    @Test
    void testEquals() {
        Vector2D vector = new Vector2D(2, 1);
        assertTrue(vector.equals(new Vector2D(2, 1)));
        assertFalse(vector.equals(new Vector2D(0, 0)));
    }


}
