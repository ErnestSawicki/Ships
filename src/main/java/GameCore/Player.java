package GameCore;

import java.util.Scanner;

public class Player {

    Map playerMap = new Map();
    Fleet fleet = new Fleet();

    public void setUpFleet(){
        fleet.ships.forEach(this::placeShipOnMap);
    }


    public void placeShipOnMap(Ship ship){
        try{
            System.out.println(ship.toString() + " Is ready for battle!");
            setUpOrientationOfShip(ship);
            if (playerMap.addShip(ship, choosePosition()) == false){
                System.out.println("Invalid position. Try again.");
                placeShipOnMap(ship);
            }
        } catch (IndexOutOfBoundsException e){
            System.out.print("Wrong position of your ship.\n It is outside of map!\n Try again!\n");
            placeShipOnMap(ship);
        }
    }
    private String choosePosition(){
        System.out.println("Choose your position: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void setUpOrientationOfShip(Ship ship){
        System.out.println("Set up your orientation: \"HORIZONTAL/VERTICAL\"");
        Scanner sc = new Scanner(System.in);
        String orientation = sc.nextLine();
        if (orientation.toUpperCase().equals("HORIZONTAL")){
            ship.setOrientation(Orientation.HORIZONTAL);
        }
        if (orientation.toUpperCase().equals("VERTICAL")){
            ship.setOrientation(Orientation.VERTICAL);
        }
        if (!orientation.toUpperCase().equals("HORIZONTAL") && !orientation.toUpperCase().equals("VERTICAL")){
            System.out.println("Invalid orientation. Try again!");
            setUpOrientationOfShip(ship);
        }
    }


}
