package main;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2D position = new Vector2D(2, 2);
    private IWorldMap map;
            List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
    }

    public Animal(IWorldMap map, Vector2D initialPosition){
        this(map);
        this.position = initialPosition;
        addObserver((IPositionChangeObserver) map);
    }

    public Vector2D getPosition(){
        return this.position;
    }

     public void move(MoveDirection direction){
        Vector2D newPosition = null;
        out.println(this.getPosition());
        switch (direction) {
            case FORWARD:
                newPosition = this.position.add(this.direction.toUnitVector());
                break;
            case BACKWARD:
                newPosition = this.position.add(this.direction.toUnitVector().opposite());
                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            default:
                out.println("zly kierunek" + direction);
            break;
        }
         out.println(this.getPosition());
        if (newPosition != null && map.canMoveTo(newPosition))
            this.position = newPosition;
         out.println(this.getPosition());
    }

    public void movements(MoveDirection[] directions){
        for (MoveDirection moveDirection : directions)
            this.move(moveDirection);
    }

    @Override
    public String toString() {
        return(this.direction.toString());
    }

    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChanged(MoveDirection direction){
        Vector2D oldPosition = this.position;
        this.move(direction);
        out.println(this.getPosition());
        Vector2D newPosition = this.position;
        observers.get(0).positionChanged(oldPosition, newPosition);

    }

}
