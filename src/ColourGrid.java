import java.util.Random;

public class ColourGrid {
    public static void main(String[] args) {
        int rows = 15;
        int columns = 10;
        int numOfColours = 4;

        Grid[] grids = createGrid(rows, columns, numOfColours);

    }

    private static Grid[] createGrid(int rows, int columns, int numOfColours) {
        Random random = new Random();
        Grid[] grids = new Grid[rows * columns];
        for (int k = 0; k < grids.length; k++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    grids[k] = new Grid();
                    grids[k].setX(i);
                    grids[k].setY(j);
                    grids[k].setColour(random.nextInt(numOfColours - 1) + 1);
                }
            }
        }
        return grids;
    }
}
