package test;
import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IWorldMapTest {
    @Test
    void RectangularMapTest() {
        String[] arguments = {"F", "R", "F", "R", "F", "F", "F", "F", "F", "F", "F", "F", "F", "F"};
        MoveDirection[] directions = OptionsParser.parse(arguments);


        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2D(3, 4)));
        //assertFalse(map.place(new Animal(map, new Vector2D(3, 4))));

        map.run(directions);

        assertTrue(map.isOccupied(new Vector2D(2, 4)));
        assertTrue(map.isOccupied(new Vector2D(3, 0)));

        assertFalse(map.isOccupied(new Vector2D(1, 1)));
    }

    @Test
    void GrassFieldTest() {
        String[] arguments = {"F", "F", "R", "R", "B", "F", "F", "R"};
        MoveDirection[] directions = OptionsParser.parse(arguments);


        IWorldMap map = new GrassField(8);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2D(3, 4)));
        //assertFalse(map.place(new Animal(map, new Vector2D(3, 4))));

        map.run(directions);
        map.toString();
        assertTrue(map.isOccupied(new Vector2D(2, 3)));
        assertTrue(map.isOccupied(new Vector2D(4, 5)));
    }
}
