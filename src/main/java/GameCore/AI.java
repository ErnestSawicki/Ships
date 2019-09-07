package GameCore;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AI {

    public AI() {

        setShipsOnMap();
    }


    Ship carrier = new Ship(5, Orientation.HORIZONTAL);
    Ship battleship = new Ship(4, Orientation.HORIZONTAL);
    Ship crusier = new Ship(3, Orientation.HORIZONTAL);
    Ship submarine = new Ship(3, Orientation.HORIZONTAL);
    Ship destroyer = new Ship(2, Orientation.HORIZONTAL);
    Map mapAI = new Map();


    private void setShipsOnMap() {
        placeShipOnMap(carrier, randomPosition());
        placeShipOnMap(battleship, randomPosition());
        placeShipOnMap(crusier, randomPosition());
        placeShipOnMap(submarine, randomPosition());
        placeShipOnMap(destroyer, randomPosition());
    }


    private String randomPosition() {
        int randomLetter = ThreadLocalRandom.current().nextInt(65, 75 + 1);
        System.out.println((int) (Math.random() * 11) + String.valueOf((char) randomLetter));
        return (int) (Math.random() * 11) + String.valueOf((char) randomLetter);
    }

    private void placeShipOnMap(Ship ship, String position){
            try{
                if (mapAI.addShip(ship, position) == false)
                    placeShipOnMap(ship, randomPosition());
            } catch (IndexOutOfBoundsException e){
                placeShipOnMap(ship, randomPosition());
            }
    }
}
