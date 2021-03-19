package main;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {


    public RectangularMap(int width, int height){
        this.rightUp = new Vector2D(width-1, height-1);
    }

    public boolean canMoveTo(Vector2D position){
        return super.canMoveTo(position);
    }

    public boolean place(Animal animal){
        return super.place(animal);
    }

    public void run(MoveDirection[] directions){
        super.run(directions);
    }

    public boolean isOccupied(Vector2D position){
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2D position){

        return super.objectAt(position);
    }


}
