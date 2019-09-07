package GameCore;

public class Game {

    public static void main(String[] args) {

        Ship ship = new Ship(1, Orientation.HORIZONTAL);
        Ship ship3 = new Ship(2, Orientation.HORIZONTAL);
        Ship ship2 = new Ship(2, Orientation.HORIZONTAL);

        Map map = new Map();

        map.addShip(ship, "8E");
        map.addShip(ship3, "0D");
        map.addShip(ship2, "2C");
        map.shootShip("4C");

        map.printPositionsMap();

/*        AI ai = new AI();
        ai.mapAI.printMap();*/

    }
}
