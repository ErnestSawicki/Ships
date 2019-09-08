package GameCore;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    List<Ship> ships = new ArrayList<>();

    public Fleet(){
        ships.add(new Ship(5, Orientation.HORIZONTAL, "carrier"));
        ships.add(new Ship(4, Orientation.HORIZONTAL, "battleship"));
        ships.add(new Ship(3, Orientation.HORIZONTAL, "cruiser"));
        ships.add(new Ship(3, Orientation.HORIZONTAL, "submarine"));
        ships.add(new Ship(2, Orientation.HORIZONTAL, "destroyer"));
    }
}
