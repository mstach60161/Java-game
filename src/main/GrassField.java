package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private List<Grass> fields;

    public GrassField(int numberOfFields){
        this.fields = new ArrayList<>();
        int size = (int) Math.sqrt(numberOfFields*10);

        this.rightUp = new Vector2D(size, size);
        Random generator = new Random();
        for(int i = 0; i < size; i++){
            int x = generator.nextInt(size+2)-1;
            int y = generator.nextInt(size+2)-1;
            while((objectAt(new Vector2D(x,y)) instanceof Grass)){
                x = generator.nextInt(size+2)-1;
                y = generator.nextInt(size+2)-1;
            }
            fields.add(new Grass(new Vector2D(x, y)));
        }

    }

    public boolean canMoveTo(Vector2D position) {

        return !(super.objectAt(position) instanceof Animal);
    }



    public Object objectAt(Vector2D position){
        if(super.objectAt(position) != null)
            return super.objectAt(position);
        for(Grass field : this.fields)
            if(field.getPosition().equals(position))
                return field;
        return null;
    }


}
