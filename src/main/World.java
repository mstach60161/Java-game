package main;

public class World {
    public static void main(String[] args) {
        try {
            String[] arguments = {"R", "F", "F", "B", "B", "F", "F", "R"};
            MoveDirection[] directions = OptionsParser.parse(arguments);


            IWorldMap map = new RectangularMap(10,10);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2D(2, 3)));
            map.run(directions);
            System.out.println(map.isOccupied(new Vector2D(2, 3)));
            System.out.println(map.isOccupied(new Vector2D(3, 4)));
            System.out.println(((RectangularMap) map).animals.get(0).getPosition());
            System.out.println(((RectangularMap) map).animals.get(1).getPosition());
            System.out.println(map);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
