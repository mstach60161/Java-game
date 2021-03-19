package main;

public class Vector2D {
    final public int x;
    final public int y;
    public Vector2D(int a, int b){
        this.x = a;
        this.y = b;
    }

    public String toString(){

        return "(" + this.x + "," + this.y + ")";
    }

    public boolean precedes(Vector2D other){

        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2D other){

        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2D upperRight(Vector2D other){
        int a = Math.max(this.x, other.x);
        int b = Math.max(this.y, other.y);
        return new Vector2D(a, b);
    }

    public Vector2D lowerLeft(Vector2D other){
        int a = Math.min(this.x, other.x);
        int b = Math.min(this.y, other.y);
        return new Vector2D(a, b);
    }

    public Vector2D add(Vector2D other){
        int a = this.x + other.x;
        int b = this.y + other.y;
        return new Vector2D(a, b);
    }

    public Vector2D subtract(Vector2D other){
        int a = this.x - other.x;
        int b = this.y - other.y;
        return new Vector2D(a, b);
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2D))
            return false;
        Vector2D that = (Vector2D) other;
        return this.x == that.x && this.y == that.y;

    }

    public Vector2D opposite(){
        int a = this.x * -1;
        int b = this.y * -1;
        return new Vector2D(a, b);
    }

    @Override
    public int hashCode(){
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 13;
        return hash;
    }

}
