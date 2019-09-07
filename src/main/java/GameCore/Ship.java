package GameCore;

public class Ship {

    private int length;
    private Orientation orientation;

    public Ship(int length, Orientation orientation){
        this.length = length;
        this.orientation = orientation;
    }

    public int getLength(){
        return length;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
