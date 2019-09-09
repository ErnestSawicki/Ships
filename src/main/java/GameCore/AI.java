package GameCore;

import java.util.concurrent.ThreadLocalRandom;

public class AI {

    Fleet fleet = new Fleet();
    Map mapAI = new Map();

    public AI() {
        setShipsOnMap();
    }
    private void setShipsOnMap() {
        fleet.ships.forEach(this::placeShipOnMap);
    }
    private String randomPosition() {
        int randomLetter = ThreadLocalRandom.current().nextInt(65, 75 + 1);
        return (int) (Math.random() * 11) + String.valueOf((char) randomLetter);
    }
    private void randomOrientation(Ship ship){
        double random = Math.random();
        if (random > 0.5){
            ship.setOrientation(Orientation.HORIZONTAL);
        } else {
            ship.setOrientation(Orientation.VERTICAL);
        }
    }
    private void placeShipOnMap(Ship ship){
            try{
                randomOrientation(ship);
                if (mapAI.addShip(ship, randomPosition()) == false)
                    placeShipOnMap(ship);
            } catch (IndexOutOfBoundsException e){
                placeShipOnMap(ship);
            }
    }
}
