package GameCore;

public class Game {

    public static void main(String[] args) {

        Ship ship = new Ship(2, Orientation.HORIZONTAL);
        Ship ship3 = new Ship(2, Orientation.HORIZONTAL);
        Ship ship2 = new Ship(2, Orientation.HORIZONTAL);

        Map map = new Map();

        map.addShip(ship, "0A");
        map.addShip(ship3, "0D");
        map.addShip(ship2, "2C");
        map.shootShip("1C");
        map.shootShip("0C");
        map.shootShip("2C");
        map.shootShip("1D");
        map.shootShip("1E");
        map.printPositionsMap();
    }
}
