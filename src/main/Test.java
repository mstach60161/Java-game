package main;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Vector2D, Animal> zwierzaki = new HashMap<>();
        IWorldMap map = new RectangularMap(4,4);
        Animal zwierze1 = new Animal(map, new Vector2D(2,2));
        zwierzaki.put(zwierze1.getPosition(), zwierze1);
        System.out.println("ok");
        Animal zwierze2 = zwierzaki.get(new Vector2D(2, 2));
        System.out.println(zwierze2.getPosition());
    }
}
