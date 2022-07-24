import java.util.Random;


public class ColourGrid {
    public static void main(String[] args) {
        int rows = 15;
        int columns = 10;
        int numOfColours = 4;

        Grid[][] grids = createGrid(rows, columns, numOfColours);
        selectLargestConnectingBlock(grids, rows, columns);

    }

    private static void selectLargestConnectingBlock(Grid[][] grids, int rows, int columns) {
        int maxX = 0;
        int maxY = 0;
        int maxCount = 0;
        int[][] counts = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (checkInside(i, j + 1) && grids[i][j].getColour() == grids[i][j + 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i, j - 1) && grids[i][j].getColour() == grids[i][j - 1].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i + 1, j) && grids[i][j].getColour() == grids[i + 1][j].getColour()) {
                    counts[i][j] += counts[i + 1][j] + 1;
                }

                if (checkInside(i - 1, j) && grids[i][j].getColour() == grids[i - 1][j].getColour()) {
                    counts[i][j] += counts[i - 1][j] + 1;
                }

            }
        }

    }

    private static boolean checkInside(int i, int j) {
        return false;
    }

    private static Grid[][] createGrid(int rows, int columns, int numOfColours) {
        Random random = new Random();
        Grid[][] grids = new Grid[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grids[i][j] = new Grid();
                grids[i][j].setColour(random.nextInt(numOfColours - 1) + 1);
                grids[i][j].setX(i);
                grids[i][j].setY(j);
            }
        }
        return grids;
    }
}
