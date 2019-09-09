package GameCore;

public class Ship {

    private int length;
    private Orientation orientation;
    private String name;

    public Ship(int length, Orientation orientation, String name){
        this.length = length;
        this.orientation = orientation;
        this.name = name;
    }

    public int getLength(){
        return length;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String getName(){
        return name;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Ship: " + getName() + ", length: " + getLength() + ".";
    }
}
