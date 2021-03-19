package main;

public class Grass {
    private Vector2D position;
    public Grass(Vector2D position){
        this.position = position;
    }

    Vector2D getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return "*";
    }

}
