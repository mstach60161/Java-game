package test;
import main.MoveDirection;
import main.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    @Test
    void parseTest(){
        String[] array = new String[]{"F", "B", "abcd", "asdf", "R", "L"};
        MoveDirection[] directions = OptionsParser.parse(array);

        assertEquals(directions[0], MoveDirection.FORWARD);
        assertEquals(directions[2], MoveDirection.RIGHT);

    }
  /*  @Test
    void testAnimalMove(){
        Animal animal = new Animal();
        assertEquals(animal.toString(), "polnoc (2,2)");
        String[] array = new String[]{"FORWARD", "RIGHT", "qwerty", "B", "BACKWARD", "LEFT"};
        MoveDirection[] directions = OptionsParser.parse(array);
        animal.movements(directions);

        assertEquals(animal.toString(), "polnoc (0,3)");

        animal = new Animal();
        array = new String[]{"F", "F", "F", "F", "F", "BACKWARD", "RIGHT", "F", "F", "F", "L", "B",
                "B", "B", "B", "B", "B", "L", "F", "F", "F", "F", "F", "L"};
        directions = OptionsParser.parse(array);
        animal.movements(directions);

        assertEquals(animal.toString(), "poludnie (0,0)");
    } */
}
