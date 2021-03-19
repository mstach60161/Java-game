package main;

import java.util.*;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Vector2D leftDown = new Vector2D(0, 0);
    protected Vector2D rightUp;
    public List<Animal> animals = new LinkedList<>();
    protected Map<Vector2D, Animal> animalsMap = new LinkedHashMap<>();

    @Override
    public void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
        Animal currentAnimal = animalsMap.get(oldPosition);
        animalsMap.remove(oldPosition);
        animalsMap.put(newPosition, currentAnimal);
    }

    public boolean canMoveTo(Vector2D position){
        return (!this.isOccupied(position)) && position.follows(this.leftDown)
                && position.precedes(this.rightUp);
    }

    public boolean place(Animal animal){
        if(this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            animalsMap.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("position " +  animal.getPosition().toString() + " is occupied");
    }

    public void run(MoveDirection[] directions){
        if(animals.isEmpty())
            return;
        for(int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).positionChanged(directions[i]);
        }


    }


    public Object objectAt(Vector2D position){
        return animalsMap.get(position);
    }


    public boolean isOccupied(Vector2D position){
        return objectAt(position) != null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.leftDown, this.rightUp);
    }
}
