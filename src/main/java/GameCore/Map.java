package GameCore;


public class Map {

    private final int MAP_SIZE = 10;
    private final int MAP_POSITIONS_SIZE = MAP_SIZE + 2;
    private String[][] mapMask = new String[MAP_SIZE][MAP_SIZE];
    private boolean[][] mapPositions = new boolean[MAP_POSITIONS_SIZE][MAP_POSITIONS_SIZE];

    private int lives = 0;

    public Map() {
        mapSetUp();
    }

    private void mapSetUp() {
        //MASK
        for (int i = 0; i < MAP_SIZE; i++)
            for (int j = 0; j < MAP_SIZE; j++)
                mapMask[i][j] = ".";
        //POSITIONS
        for (int i = 0; i < MAP_POSITIONS_SIZE; i++)
            for (int j = 0; j < MAP_POSITIONS_SIZE; j++)
                mapPositions[i][j] = true;
    }


    public void addShip(Ship ship, String position) {
        int xPosition = (int) position.charAt(0) % 48;
        int yPosition = (int) position.charAt(1) % 65;

        if (ship.getOrientation().equals(Orientation.HORIZONTAL) && checkShipsCollisions(ship, xPosition, yPosition)) {
            for (int i = 0; i < ship.getLength(); i++) {
                mapMask[xPosition][yPosition + i] = "X";
                surroundPositionsWithTakenSpace(ship, xPosition, yPosition);
            }
            lives += ship.getLength();
            printMap();
        } else if (checkShipsCollisions(ship, xPosition, yPosition)) {
            for (int i = 0; i < ship.getLength(); i++) {
                mapMask[xPosition + i][yPosition] = "X";
            }
            lives += ship.getLength();
            printMap();
        }
    }

    private boolean checkShipsCollisions(Ship ship, int xPosition, int yPosition) {
           for (int i = 0; i < ship.getLength() + 1; i++)
               for (int j = 0; j < 2; j++) {
                   if (mapPositions[xPosition + 1 + j][yPosition + 1 + i] == false)
                       return false;
               }
           return true;
    }

    private void surroundPositionsWithTakenSpace(Ship ship, int xPosition, int yPosition) {
            for (int i = -1; i < ship.getLength() + 1; i++)
                for (int j = -1; j < 2; j++) {
                    mapPositions[xPosition + 1 + j][yPosition + 1 + i] = false;
                }
    }

    public void shootShip(String position) {
        int xPosition = (int) position.charAt(0) % 48;
        int yPosition = (int) position.charAt(1) % 65;

        if (mapMask[xPosition][yPosition].equals(".")) {
            mapMask[xPosition][yPosition] = "O";
        } else {
            mapMask[xPosition][yPosition] = "*";
            lives--;
        }
        printMap();
    }

    public void printMap() {
        System.out.println("Ship lives = " + lives);
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(mapMask[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }

    public void printPositionsMap() {
        for (int i = 0; i < MAP_POSITIONS_SIZE; i++) {
            for (int j = 0; j < MAP_POSITIONS_SIZE; j++) {
                System.out.print(mapPositions[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }

}
