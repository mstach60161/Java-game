package main;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    @Override
    public String toString(){
        switch (this){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            case WEST:
                return "W";
            default:
                return null;
        }
    }

    public MapDirection next(){
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            default:
                return null;
        }
    }
    public Vector2D toUnitVector(){
        switch (this){
            case NORTH:
                return new Vector2D(0, 1);
            case SOUTH:
                return new Vector2D(0, -1);
            case EAST:
                return new Vector2D(1, 0);
            case WEST:
                return new Vector2D(-1, 0);
            default:
                return null;
        }
    }

}
