package main;

import java.util.ArrayList;
import java.util.List;


public class OptionsParser {
    public static MoveDirection[] parse(String[] array) {
            List<MoveDirection> directions = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                switch (array[i]) {
                    case "F":
                    case "FORWARD":
                        directions.add(MoveDirection.FORWARD);
                        break;
                    case "B":
                    case "BACKWARD":
                        directions.add(MoveDirection.BACKWARD);
                        break;
                    case "R":
                    case "RIGHT":
                        directions.add(MoveDirection.RIGHT);
                        break;
                    case "L":
                    case "LEFT":
                        directions.add(MoveDirection.LEFT);
                        break;
                    default:
                        throw new IllegalArgumentException(array[i] + " is not legal move specification");
                }
            }

            MoveDirection[] result = new MoveDirection[directions.size()];
            for (int i = 0; i < directions.size(); i++)
                result[i] = directions.get(i);

            return result;
    }
}
